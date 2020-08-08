package com.dreamsoftware.covidtweets.config.twitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/**
 *
 * @author ssanchez
 */
@Configuration
public class TwitterConfig {

    /**
     * Provide Twitter Stream Factory
     *
     * @return
     */
    @Bean
    TwitterStreamFactory provideTwitterStreamFactory() {
        return new TwitterStreamFactory();
    }

    /**
     * Provide Twitter Stream
     *
     * @param twitterStreamFactory
     * @return
     */
    @Bean
    TwitterStream provideTwitterStream(final TwitterStreamFactory twitterStreamFactory) {
        return twitterStreamFactory.getInstance();
    }
}
