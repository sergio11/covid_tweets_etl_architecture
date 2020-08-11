package com.dreamsoftware.covidtweets.models;

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

    private Long id;
    private Date createdAt;
    private String lang;
    private Integer favoriteCount;
    private Integer retweetCount;
    private String text;
    private UserDTO user;
    private Double geoLocationLatitude;
    private Double geoLocationLongitude;
    private String sentimentLabel;
    private Integer sentimentValue;
    private String tokensAndNERTags;
    private Map<String, Set<String>> entityMentions;

}
