package com.dreamsoftware.covidtweets.mapper;

import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.persistence.model.TweetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

/**
 *
 * @author ssanchez
 */
@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class TweetDtoMapper {

    @Mappings({})
    @Named("dtoToEntity")
    public abstract TweetEntity dtoToEntity(TweetDTO tweetDto);

}
