package com.dreamsoftware.covidtweets.model;

import java.util.HashMap;

/**
 *
 * @author ssanchez
 */
public enum Sentiment {

    VERY_NEGATIVE(0),
    NEGATIVE(1),
    NEUTRO(2),
    POSITIVE(3),
    VERY_POSITIVE(4),
    UNKNOW(5);

    private static final HashMap<Integer, Sentiment> lookup = new HashMap<>();

    static {
        for (Sentiment s : Sentiment.values()) {
            lookup.put(s.getValue(), s);
        }
    }

    private final int value;

    private Sentiment(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Sentiment getFromValue(Integer value) {
        return lookup.get(value) != null ? lookup.get(value) : lookup.get(5);
    }

}
