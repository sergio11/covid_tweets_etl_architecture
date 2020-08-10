package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.model.Sentiment;

/**
 *
 * @author ssanchez
 */
public interface ITextAnalyzerService {

    /**
     * Find Sentiment
     *
     * @param text
     * @return
     */
    Sentiment findSentiment(final String text);
}
