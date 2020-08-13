package com.dreamsoftware.covidtweets.mapper;

import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.persistence.model.EntityMentionEntity;
import com.dreamsoftware.covidtweets.persistence.model.TweetEntity;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 *
 * @author ssanchez
 */
@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class TweetMapper {

    @Autowired
    protected UserMapper userEntityMapper;

    @Mappings({
        @Mapping(expression = "java(userEntityMapper.dtoToEntity(tweetDto.getUser()))", target = "user"),
        @Mapping(expression = "java(mappingEntityMentions(tweetDto.getEntityMentions()))", target = "entityMentionList")
    })
    @Named("dtoToEntity")
    public abstract TweetEntity dtoToEntity(TweetDTO tweetDto);

    @Mappings({
        @Mapping(expression = "java(userEntityMapper.entityToDTO(tweetEntity.getUser()))", target = "user")
    })
    @Named("entityToDTO")
    public abstract TweetDTO entityToDTO(TweetEntity tweetEntity);

    /**
     *
     * @param tweetEntityList
     * @return
     */
    @IterableMapping(qualifiedByName = "entityToDTO")
    public abstract List<TweetDTO> entityToDTO(List<TweetEntity> tweetEntityList);

    /**
     *
     * @param entityMentions
     * @return
     */
    protected List<EntityMentionEntity> mappingEntityMentions(final Map<String, Set<String>> entityMentions) {
        Assert.notNull(entityMentions, "Entity Mentions can not be null");
        return entityMentions.entrySet().stream().map(entry -> new EntityMentionEntity(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }

}
