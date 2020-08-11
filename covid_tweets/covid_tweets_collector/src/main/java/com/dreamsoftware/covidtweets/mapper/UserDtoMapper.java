package com.dreamsoftware.covidtweets.mapper;

import com.dreamsoftware.covidtweets.models.UserDTO;
import com.dreamsoftware.covidtweets.persistence.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

/**
 *
 * @author ssanchez
 */
@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class UserDtoMapper {

    @Mappings({})
    @Named("dtoToEntity")
    public abstract UserEntity dtoToEntity(UserDTO userDto);

}
