package com.dreamsoftware.covidtweetsprocessor.service.impl;

import com.dreamsoftware.covidtweetsprocessor.model.Greetings;
import com.dreamsoftware.covidtweetsprocessor.streams.TweetStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 *
 * @author ssanchez
 */
@Service
public class GreetingsServiceImpl implements IGreetingsService {

    @Autowired
    private TweetStreams greetingsStreams;

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
