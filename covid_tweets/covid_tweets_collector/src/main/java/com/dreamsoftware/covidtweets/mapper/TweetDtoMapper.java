package com.dreamsoftware.covidtweets.mapper;

import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.persistence.model.EntityMentionEntity;
import com.dreamsoftware.covidtweets.persistence.model.TweetEntity;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public abstract class TweetDtoMapper {

    @Autowired
    protected UserDtoMapper userDtoMapper;

    @Mappings({
        @Mapping(expression = "java(userDtoMapper.dtoToEntity(tweetDto.getUser()))", target = "user"),
        @Mapping(expression = "java(mappingEntityMentions(tweetDto.getEntityMentions()))", target = "entityMentionList")
    })
    @Named("dtoToEntity")
    public abstract TweetEntity dtoToEntity(TweetDTO tweetDto);

    /**
     *
     * @param entityMentions
     * @return
     */
    protected List<EntityMentionEntity> mappingEntityMentions(final Map<String, Set<String>> entityMentions) {
        Assert.notNull(entityMentions, "Entity Mentions can not be null");
        final List<EntityMentionEntity> entityMentionEntityList = entityMentions.entrySet().stream().map(entry -> new EntityMentionEntity(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        for (final EntityMentionEntity entityMention : entityMentionEntityList) {
            log.info("entityMention -> " + entityMention.getEntityType() + " / " + entityMention.getEntitySet());
        }
        return entityMentionEntityList;
    }

}
