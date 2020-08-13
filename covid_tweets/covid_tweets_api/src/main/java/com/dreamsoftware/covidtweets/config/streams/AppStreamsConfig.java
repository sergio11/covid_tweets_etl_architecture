package com.dreamsoftware.covidtweets.config.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 *
 * @author ssanchez
 */
public interface AppStreamsConfig {

    String PROCESSED_TWEETS_CHANNEL = "processed-tweets";

    /**
     * Input Channel definition
     *
     * @return
     */
    @Input(PROCESSED_TWEETS_CHANNEL)
    MessageChannel inputProcessedTweets();
}
