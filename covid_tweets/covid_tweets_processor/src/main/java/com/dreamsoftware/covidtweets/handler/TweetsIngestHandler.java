package com.dreamsoftware.covidtweets.handler;

import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;
import com.dreamsoftware.covidtweets.model.Sentiment;
import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.service.impl.ITextAnalyzerService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class TweetsIngestHandler {

    private final ITextAnalyzerService textAnalyzerService;

    /**
     * New Tweet Handler
     *
     * @param newTweet
     * @return
     */
    @StreamListener(AppStreamsConfig.TWEET_INGEST_CHANNEL)
    @SendTo(AppStreamsConfig.PROCESSED_TWEETS_CHANNEL)
    public TweetDTO onNewTweet(final TweetDTO newTweet) {
        // Find Sentiment
        final Sentiment sentiment = textAnalyzerService.findSentiment(newTweet.getText());
        newTweet.setSentimentLabel(sentiment.name());
        newTweet.setSentimentValue(sentiment.getValue());
        log.debug("New Tweet Sentiment -> " + sentiment.name());
        return newTweet;
    }
}
