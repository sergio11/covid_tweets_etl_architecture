package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.model.Sentiment;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 *
 * @author ssanchez
 */
@Service("textAnalyzer")
@RequiredArgsConstructor
public class TextAnalyzerServiceImpl implements ITextAnalyzerService {

    private final StanfordCoreNLP stanfordCoreNLP;

    /**
     *
     * @param text
     * @return
     */
    @Override
    public Sentiment findSentiment(String text) {
        Assert.notNull(text, "Text can not be null");
        int mainSentiment = 0;
        int longest = 0;
        Annotation annotation = stanfordCoreNLP.process(text);
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
            String partText = sentence.toString();
            if (partText.length() > longest) {
                mainSentiment = sentiment;
                longest = partText.length();
            }
        }
        return Sentiment.getFromValue(mainSentiment);
    }

}
