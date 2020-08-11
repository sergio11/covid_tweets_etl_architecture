package com.dreamsoftware.covidtweets.handler;

import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;
import com.dreamsoftware.covidtweets.model.TextAnalysisResult;
import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.service.impl.ITextAnalyzerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 *
 * @author ssanchez
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class TweetsIngestHandler {

    /**
     * Text Analyzer Service
     */
    private final ITextAnalyzerService textAnalyzerService;

    /**
     *
     * @param newTweet
     * @param acknowledgment
     * @return
     */
    @StreamListener(AppStreamsConfig.TWEET_INGEST_CHANNEL)
    @SendTo(AppStreamsConfig.PROCESSED_TWEETS_CHANNEL)
    public TweetDTO onNewTweet(
            @Payload final TweetDTO newTweet,
            @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment) {

        final TextAnalysisResult analysisResult = textAnalyzerService.analyze(newTweet.getText());
        newTweet.setSentimentLabel(analysisResult.getSentiment().name());
        newTweet.setSentimentValue(analysisResult.getSentiment().getValue());
        newTweet.setEntityMentions(analysisResult.getEntityMentions());
        newTweet.setTokensAndNERTags(analysisResult.getTokensAndNERTags());

        if (acknowledgment != null) {
            acknowledgment.acknowledge();
        }

        log.debug("Sentiment For Current Tweet -> " + analysisResult.getSentiment().name());
        return newTweet;

    }
}
