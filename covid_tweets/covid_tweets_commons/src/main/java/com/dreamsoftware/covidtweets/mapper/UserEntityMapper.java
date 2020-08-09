package com.dreamsoftware.covidtweets.mapper;

import com.dreamsoftware.covidtweets.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import twitter4j.User;

/**
 *
 * @author ssanchez
 */
@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class UserEntityMapper {

    @Mappings({})
    @Named("entityToDTO")
    public abstract UserEntity entityToDTO(User tweetUser);

}
