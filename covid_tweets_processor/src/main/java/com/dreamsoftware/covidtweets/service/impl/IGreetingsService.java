package com.dreamsoftware.covidtweets.service.impl;

import com.dreamsoftware.covidtweets.model.Greetings;

/**
 *
 * @author ssanchez
 */
public interface IGreetingsService {

    /**
     * Send Greeting
     *
     * @param greetings
     */
    void sendGreeting(final Greetings greetings);

}
