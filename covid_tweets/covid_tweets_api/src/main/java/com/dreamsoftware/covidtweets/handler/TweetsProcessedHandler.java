package com.dreamsoftware.covidtweets.handler;

import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;
import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.service.impl.ITweetsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 *
 * @author ssanchez
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class TweetsProcessedHandler {

    private final ITweetsService tweetService;

    /**
     *
     * @param newProcessedTweet
     * @param topic
     * @param partition
     * @param offset
     * @param acknowledgment
     * @param deliveryAttempt
     */
    @StreamListener(AppStreamsConfig.PROCESSED_TWEETS_CHANNEL)
    public void onNewProcessedTweet(
            @Payload final TweetDTO newProcessedTweet,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
            @Header(KafkaHeaders.OFFSET) Long offset,
            @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
            @Header(IntegrationMessageHeaderAccessor.DELIVERY_ATTEMPT) Integer deliveryAttempt) {

        log.info("NewsProcessedTweet with id '{}' and text '{}' received from bus. topic: {}, partition: {}, offset: {}, deliveryAttempt: {}",
                newProcessedTweet.getId(), newProcessedTweet.getText(), topic, partition, offset, deliveryAttempt);

        tweetService.send(newProcessedTweet);

        // commit offset
        if (acknowledgment != null) {
            acknowledgment.acknowledge();
            log.info("Commit Offsets ...");
        }
    }
}
