package com.dreamsoftware.covidtweets.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UserDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("email")
    private String email;

    @JsonProperty("followers_count")
    private Integer followersCount;

    @JsonProperty("friends_count")
    private Integer friendsCount;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("url")
    private String url;

    @JsonProperty("screen_name")
    private String screenName;

    @JsonProperty("bigger_profile_image_url_https")
    private String biggerProfileImageURLHttps;

}
