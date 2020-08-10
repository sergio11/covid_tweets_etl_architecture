package com.dreamsoftware.covidtweets.mapper;

import com.dreamsoftware.covidtweets.models.TweetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.Status;

/**
 *
 * @author ssanchez
 */
@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class TweetEntityMapper {

    @Autowired
    protected UserEntityMapper userEntityMapper;

    @Mappings({
        @Mapping(expression = "java(userEntityMapper.entityToDTO(tweetStatus.getUser()))", target = "user"),
        @Mapping(source = "tweetStatus.geoLocation.latitude", target = "geoLocationLatitude"),
        @Mapping(source = "tweetStatus.geoLocation.longitude", target = "geoLocationLongitude")
    })
    @Named("entityToDTO")
    public abstract TweetDTO entityToDTO(Status tweetStatus);

}
