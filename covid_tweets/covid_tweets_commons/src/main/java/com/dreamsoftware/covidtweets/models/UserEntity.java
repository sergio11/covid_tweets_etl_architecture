package com.dreamsoftware.covidtweets.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private Long id;
    private String name;
    private String description;
    private String email;
    private Integer followersCount;
    private Integer friendsCount;
    private String lang;
    private String url;
    private String screenName;
    private String biggerProfileImageURLHttps;

}
