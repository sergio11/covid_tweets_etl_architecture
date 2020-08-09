package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.mapper.TweetDtoMapper;
import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.persistence.model.TweetEntity;
import com.dreamsoftware.covidtweets.persistence.repository.TweetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 *
 * @author ssanchez
 */
@Service("tweetsService")
@RequiredArgsConstructor
public class TweetsServiceImpl implements ITweetsService {

    /**
     * Tweets Repository
     */
    private final TweetsRepository tweetsRepository;
    private final TweetDtoMapper tweetDtoMapper;

    @Override
    public void save(TweetDTO tweetDto) {
        Assert.notNull(tweetDto, "Tweet can not be null");

        final TweetEntity tweetToSave = tweetDtoMapper.dtoToEntity(tweetDto);
        tweetsRepository.save(tweetToSave);
    }

}
