package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.model.TextAnalysisResult;
import com.dreamsoftware.covidtweets.model.TextSentimentEnum;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
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
    public TextAnalysisResult analyze(final String text) {
        Assert.notNull(text, "Text can not be null");

        final CoreDocument doc = new CoreDocument(text);
        // annotate the document
        stanfordCoreNLP.annotate(doc);

        // Find Sentiment
        final TextSentimentEnum textSentiment = findSentiment(text);

        // Entity Mentions
        final Map<String, Set<String>> entityMentions = doc.entityMentions().stream()
                .collect(groupingBy(CoreEntityMention::entityType, Collectors.mapping(
                        CoreEntityMention::text,
                        Collectors.toSet())));

        // Tokens And Ner Tags
        final String tokensAndNERTags = doc.tokens().stream().map(token -> "(" + token.word() + "," + token.ner() + ")").collect(
                Collectors.joining(" "));

        return TextAnalysisResult.builder()
                .sentiment(textSentiment)
                .entityMentions(entityMentions)
                .tokensAndNERTags(tokensAndNERTags)
                .build();

    }

    /**
     * Private Methods
     */
    private TextSentimentEnum findSentiment(String text) {
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
        return TextSentimentEnum.getFromValue(mainSentiment);
    }
}
