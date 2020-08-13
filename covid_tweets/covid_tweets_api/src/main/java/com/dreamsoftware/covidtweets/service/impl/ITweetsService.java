package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.models.TweetDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author ssanchez
 */
public interface ITweetsService {

    /**
     *
     * @param page
     * @param size
     * @return
     */
    Page<TweetDTO> findPaginated(final Integer page, final Integer size);

    /**
     *
     * @param pageable
     * @return
     */
    Page<TweetDTO> findPaginated(final Pageable pageable);

    /**
     *
     * @param id
     * @return
     */
    Optional<TweetDTO> findById(final Long id);

    /**
     *
     * @param tweetDto
     */
    void send(final TweetDTO tweetDto);

}
