package com.dreamsoftware.covidtweets.handler;

import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 *
 * @author ssanchez
 */
@Component
@Slf4j
public class TweetsIngestHandler {

    @StreamListener(AppStreamsConfig.TWEET_INGEST_CHANNEL)
    @SendTo(AppStreamsConfig.PROCESSED_TWEETS_CHANNEL)
    public String onNewTweet(final String newTweet) {
        log.debug("NewTweet -> " + newTweet);
        return newTweet;
    }
}
