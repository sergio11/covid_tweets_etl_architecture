package com.dreamsoftware.covidtweets.models;

import java.util.Date;
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
public class TweetEntity {

    private Long id;
    private Date createdAt;
    private String lang;
    private Integer favoriteCount;
    private Integer retweetCount;
    private String text;
    private UserEntity user;
    private Double geoLocationLatitude;
    private Double geoLocationLongitude;
}
