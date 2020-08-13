package com.dreamsoftware.covidtweets.persistence.model;

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
public class UserEntity {

    @Field(type = FieldType.Integer)
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String email;

    @Field(type = FieldType.Integer)
    private Integer followersCount;

    @Field(type = FieldType.Integer)
    private Integer friendsCount;

    @Field(type = FieldType.Text)
    private String lang;

    @Field(type = FieldType.Text)
    private String url;

    @Field(type = FieldType.Text)
    private String screenName;

    @Field(type = FieldType.Text)
    private String biggerProfileImageURLHttps;

}
