package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.models.TweetDTO;

/**
 *
 * @author ssanchez
 */
public interface ITweetsService {

    void save(final TweetDTO tweetDto);

}
