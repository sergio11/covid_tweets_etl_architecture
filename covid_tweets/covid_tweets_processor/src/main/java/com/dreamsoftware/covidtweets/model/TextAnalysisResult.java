package com.dreamsoftware.covidtweets.model;

import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
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
@Builder
public class TextAnalysisResult {

    private TextSentimentEnum sentiment;
    private Map<String, Set<String>> entityMentions;
    private String tokensAndNERTags;

}
