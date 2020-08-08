package com.dreamsoftware.covidtweets.config.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *
 * @author ssanchez
 */
public interface AppStreamsConfig {

    String TWEET_INGEST_CHANNEL = "tweets-ingest";

    /**
     * Outbound Tweets Ingest
     *
     * @return
     */
    @Output(TWEET_INGEST_CHANNEL)
    MessageChannel outboundTweetsIngest();

}
