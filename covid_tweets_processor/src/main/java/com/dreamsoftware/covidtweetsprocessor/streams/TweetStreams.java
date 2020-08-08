package com.dreamsoftware.covidtweetsprocessor.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *
 * @author ssanchez
 */
public interface TweetStreams {

    String OUTPUT = "processed-tweets";

    @Output(OUTPUT)
    MessageChannel outboundProcessedTweets();

}
