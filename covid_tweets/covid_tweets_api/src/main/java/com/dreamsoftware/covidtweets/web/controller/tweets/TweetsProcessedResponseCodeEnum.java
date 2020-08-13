package com.dreamsoftware.covidtweets.web.controller.tweets;

import com.dreamsoftware.covidtweets.web.controller.core.response.IResponseCodeTypes;

/**
 *
 * @author ssanchez
 */
public enum TweetsProcessedResponseCodeEnum implements IResponseCodeTypes {

    GET_TWEETS_PROCESSED(100L),
    GET_TWEET_PROCESSED_DETAIL(101L),
    NO_TWEETS_PROCESSED_FOUND(102L),
    TWEET_PROCESSED_NOT_FOUND(103L);

    private final Long code;

    public static final String CATEGORY_NAME = "TWEETS_PROCESSED";

    private TweetsProcessedResponseCodeEnum(Long code) {
        this.code = code;
    }

    @Override
    public Long getResponseCode() {
        return code;
    }

    @Override
    public String getCategoryName() {
        return CATEGORY_NAME;
    }

}
