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
public abstract class UserMapper {

    @Mappings({})
    @Named("dtoToEntity")
    public abstract UserEntity dtoToEntity(UserDTO userDto);

    @Mappings({})
    @Named("entityToDTO")
    public abstract UserDTO entityToDTO(UserEntity userEntity);

}
