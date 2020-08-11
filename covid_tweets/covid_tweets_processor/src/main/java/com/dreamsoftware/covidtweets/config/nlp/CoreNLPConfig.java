package com.dreamsoftware.covidtweets.config.nlp;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ssanchez
 */
@Configuration
public class CoreNLPConfig {

    /**
     * Provide Standford Core NLP
     *
     * @return
     */
    @Bean
    public StanfordCoreNLP provideStanfordCoreNLP() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,sentiment");
        return new StanfordCoreNLP(props);
    }

}
