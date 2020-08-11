package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.model.TextAnalysisResult;

/**
 *
 * @author ssanchez
 */
public interface ITextAnalyzerService {

    /**
     * @param text
     * @return
     */
    TextAnalysisResult analyze(final String text);
}
