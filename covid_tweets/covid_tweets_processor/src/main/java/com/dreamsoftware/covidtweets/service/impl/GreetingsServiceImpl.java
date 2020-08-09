package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.model.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import com.dreamsoftware.covidtweets.config.streams.AppStreamsConfig;

/**
 *
 * @author ssanchez
 */
@Service
public class GreetingsServiceImpl implements IGreetingsService {

    @Autowired
    private AppStreamsConfig greetingsStreams;

    /**
     *
     * @param greetings
     */
    @Override
    public void sendGreeting(Greetings greetings) {

        MessageChannel messageChannel = greetingsStreams.outboundProcessedTweets();
        boolean sent = messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

    }
}
