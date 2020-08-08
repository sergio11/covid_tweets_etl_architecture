package com.dreamsoftware.covidtweetsprocessor.config;

import com.dreamsoftware.covidtweetsprocessor.streams.TweetStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 *
 * @author ssanchez
 */
@EnableBinding(TweetStreams.class)
public class StreamsConfig {

}
