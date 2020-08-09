package com.dreamsoftware.covidtweets.handler;

import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;
import com.dreamsoftware.covidtweets.models.TweetDTO;
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

    /**
     * New Tweet Handler
     *
     * @param newTweet
     * @return
     */
    @StreamListener(AppStreamsConfig.TWEET_INGEST_CHANNEL)
    @SendTo(AppStreamsConfig.PROCESSED_TWEETS_CHANNEL)
    public TweetDTO onNewTweet(final TweetDTO newTweet) {
        log.debug("NewTweet -> " + newTweet.getText());
        return newTweet;
    }
}
