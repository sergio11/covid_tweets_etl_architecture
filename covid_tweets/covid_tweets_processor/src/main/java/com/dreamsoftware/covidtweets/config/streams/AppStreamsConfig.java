package com.dreamsoftware.covidtweets.config.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *
 * @author ssanchez
 */
public interface AppStreamsConfig {

    String PROCESSED_TWEETS_CHANNEL = "processed-tweets";
    String TWEET_INGEST_CHANNEL = "tweets-ingest";

    @Input(TWEET_INGEST_CHANNEL)
    MessageChannel inputTweetsIngest();

    @Output(PROCESSED_TWEETS_CHANNEL)
    MessageChannel outboundProcessedTweets();

}
