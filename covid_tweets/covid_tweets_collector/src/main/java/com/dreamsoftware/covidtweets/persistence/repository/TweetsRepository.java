package com.dreamsoftware.covidtweets.persistence.repository;

import com.dreamsoftware.covidtweets.persistence.model.TweetEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * @author ssanchez
 */
public interface TweetsRepository extends ElasticsearchRepository<TweetEntity, Long> {

}
