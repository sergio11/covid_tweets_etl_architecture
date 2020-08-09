package com.dreamsoftware.covidtweets.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;
import static com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig.TWEET_INGEST_CHANNEL;
import com.dreamsoftware.covidtweets.config.twitter.TwitterConfig;
import com.dreamsoftware.covidtweets.mapper.TweetEntityMapper;
import com.dreamsoftware.covidtweets.producer.TwitterMessageProducer;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;
import twitter4j.TwitterStream;

/**
 *
 * @author ssanchez
 */
@EnableBinding(AppStreamsConfig.class)
@Import(TwitterConfig.class)
public class AppConfig {

    /**
     * Provide Ingest Producer
     *
     * @param twitterStream
     * @param outputChannel
     * @return
     */
    @Bean
    TwitterMessageProducer provideIngestProducer(
            final TwitterStream twitterStream,
            @Qualifier(TWEET_INGEST_CHANNEL)
            final MessageChannel outputChannel,
            final TweetEntityMapper tweetEntityMapper) {

        TwitterMessageProducer twitterMessageProducer
                = new TwitterMessageProducer(twitterStream, outputChannel, tweetEntityMapper);

        twitterMessageProducer.setTerms(Arrays.asList("covid", "covid-19", "pandemic"));

        return twitterMessageProducer;
    }

}
