package com.dreamsoftware.covidtweets.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;

/**
 *
 * @author ssanchez
 */
@EnableBinding(AppStreamsConfig.class)
public class AppConfig {

}
