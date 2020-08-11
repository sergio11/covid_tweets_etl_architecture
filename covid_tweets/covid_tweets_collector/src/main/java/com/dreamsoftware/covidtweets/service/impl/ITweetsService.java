package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.models.TweetDTO;

/**
 *
 * @author ssanchez
 */
public interface ITweetsService {

    /**
     *
     * @param tweetDto
     */
    void save(final TweetDTO tweetDto);

}
