package com.dreamsoftware.covidtweets.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Tweet Entity
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class TweetDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("create_at")
    private Date createdAt;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("favorite_count")
    private Integer favoriteCount;

    @JsonProperty("retweet_count")
    private Integer retweetCount;

    @JsonProperty("text")
    private String text;

    @JsonProperty("user")
    private UserDTO user;

    @JsonProperty("geo_location_latitude")
    private Double geoLocationLatitude;

    @JsonProperty("geo_location_longitude")
    private Double geoLocationLongitude;

    @JsonProperty("sentiment_label")
    private String sentimentLabel;

    @JsonProperty("sentiment_value")
    private Integer sentimentValue;

    @JsonProperty("tokens_and_ner_tags")
    private String tokensAndNERTags;

    @JsonProperty("entity_mentions")
    private Map<String, Set<String>> entityMentions;

}
