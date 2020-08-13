package com.dreamsoftware.covidtweets.persistence.model;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class EntityMentionEntity {

    @Field(type = FieldType.Text)
    private String entityType;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<String> entitySet;

}
