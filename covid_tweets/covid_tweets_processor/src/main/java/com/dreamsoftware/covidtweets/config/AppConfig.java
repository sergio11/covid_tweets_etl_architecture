package com.dreamsoftware.covidtweets.config;

import com.dreamsoftware.covidtweets.config.nlp.CoreNLPConfig;
import org.springframework.cloud.stream.annotation.EnableBinding;
import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;
import org.springframework.context.annotation.Import;

/**
 *
 * @author ssanchez
 */
@EnableBinding(AppStreamsConfig.class)
@Import(CoreNLPConfig.class)
public class AppConfig {
}
