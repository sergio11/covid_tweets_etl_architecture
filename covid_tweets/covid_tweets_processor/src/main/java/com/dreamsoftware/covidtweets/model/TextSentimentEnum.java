package com.dreamsoftware.covidtweets.model;

import java.util.HashMap;

/**
 *
 * @author ssanchez
 */
public enum TextSentimentEnum {

    VERY_NEGATIVE(0),
    NEGATIVE(1),
    NEUTRO(2),
    POSITIVE(3),
    VERY_POSITIVE(4),
    UNKNOW(5);

    private static final HashMap<Integer, TextSentimentEnum> lookup = new HashMap<>();

    static {
        for (TextSentimentEnum s : TextSentimentEnum.values()) {
            lookup.put(s.getValue(), s);
        }
    }

    private final int value;

    private TextSentimentEnum(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TextSentimentEnum getFromValue(Integer value) {
        return lookup.get(value) != null ? lookup.get(value) : lookup.get(5);
    }

}
