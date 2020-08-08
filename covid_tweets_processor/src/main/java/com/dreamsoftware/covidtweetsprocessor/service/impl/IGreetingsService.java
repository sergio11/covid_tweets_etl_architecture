package com.dreamsoftware.covidtweetsprocessor.service.impl;

import com.dreamsoftware.covidtweetsprocessor.model.Greetings;

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
