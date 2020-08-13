package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.mapper.TweetMapper;
import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.persistence.repository.TweetsRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    private final TweetMapper tweetDtoMapper;
    private final SimpMessagingTemplate simpMessagingtemplate;

    /**
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<TweetDTO> findPaginated(Integer page, Integer size) {
        Assert.notNull(page, "Page can not be null");
        Assert.notNull(size, "Size can not be null");
        return findPaginated(PageRequest.of(page, size));
    }

    /**
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<TweetDTO> findPaginated(Pageable pageable) {
        Assert.notNull(pageable, "Pageable can not be null");

        return tweetsRepository.findAll(pageable)
                .map(tweetDtoMapper::entityToDTO);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<TweetDTO> findById(final Long id) {
        Assert.notNull(id, "id can not be null");
        return tweetsRepository.findById(id).map(tweetDtoMapper::entityToDTO);
    }

    @Override
    public void send(TweetDTO tweetDto) {
        Assert.notNull(tweetDto, "Tweet DTO can not be null");
        simpMessagingtemplate.convertAndSend("/covid-tweets-wss/tweets-processed", tweetDto);
    }

}
