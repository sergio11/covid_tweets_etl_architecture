package com.dreamsoftware.covidtweets.persistence.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Tweet Entity
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "tweets_processed")
public class TweetEntity {

    @Id
    private Long id;

    /**
     * Create At
     */
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date createdAt;

    /**
     * Tweet Lang
     */
    @Field(type = FieldType.Text)
    private String lang;

    /**
     * Favorite Count
     */
    @Field(type = FieldType.Integer)
    private Integer favoriteCount;

    /**
     * Retweet Count
     */
    @Field(type = FieldType.Integer)
    private Integer retweetCount;

    /**
     * Text
     */
    @Field(type = FieldType.Text)
    private String text;

    /**
     * GeoLocation Latitude
     */
    @Field(type = FieldType.Double)
    private Double geoLocationLatitude;

    /**
     * GeoLocation Longitude
     */
    @Field(type = FieldType.Double)
    private Double geoLocationLongitude;

    /**
     * Sentiment Label
     */
    @Field(type = FieldType.Text)
    private String sentimentLabel;

    /**
     * Sentiment Value
     */
    @Field(type = FieldType.Integer)
    private Integer sentimentValue;

    /**
     * Tokens And NER Tags
     */
    @Field(type = FieldType.Text)
    private String tokensAndNERTags;

    /**
     * Entity Mention List
     */
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<EntityMentionEntity> entityMentionList;

    /**
     * User
     */
    @Field(type = FieldType.Nested, includeInParent = true)
    private UserEntity user;

}
