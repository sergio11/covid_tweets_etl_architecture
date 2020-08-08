package com.dreamsoftware.covidtweets.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Getter
@Setter
@ToString
@Builder
public class Greetings {

    private long timestamp;
    private String message;

    public Greetings() {
    }

    public Greetings(long timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

}
