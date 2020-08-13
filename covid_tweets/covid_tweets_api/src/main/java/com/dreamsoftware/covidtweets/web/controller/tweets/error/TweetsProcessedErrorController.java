package com.dreamsoftware.covidtweets.web.controller.tweets.error;

import com.dreamsoftware.covidtweets.web.controller.core.SupportController;
import com.dreamsoftware.covidtweets.web.controller.core.response.APIResponse;
import com.dreamsoftware.covidtweets.web.controller.core.response.ErrorResponseDTO;
import com.dreamsoftware.covidtweets.web.controller.tweets.TweetsProcessedResponseCodeEnum;
import com.dreamsoftware.covidtweets.web.controller.tweets.error.exception.NoTweetsProcessedFoundException;
import com.dreamsoftware.covidtweets.web.controller.tweets.error.exception.TweetProcessedNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ssanchez
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TweetsProcessedErrorController extends SupportController {

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(TweetProcessedNotFoundException.class)
    @ResponseBody
    protected ResponseEntity<APIResponse<ErrorResponseDTO>> handleTweetProcessedNotFoundException(TweetProcessedNotFoundException ex, HttpServletRequest request) {
        return responseHelper.<String>createAndSendErrorResponse(TweetsProcessedResponseCodeEnum.TWEET_PROCESSED_NOT_FOUND,
                HttpStatus.NOT_FOUND, "Publication Not Found");
    }

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(NoTweetsProcessedFoundException.class)
    @ResponseBody
    protected ResponseEntity<APIResponse<ErrorResponseDTO>> handleNoTweetsProcessedFoundException(NoTweetsProcessedFoundException ex, HttpServletRequest request) {
        return responseHelper.<String>createAndSendErrorResponse(TweetsProcessedResponseCodeEnum.NO_TWEETS_PROCESSED_FOUND,
                HttpStatus.NOT_FOUND, "No Tweets Processed.");
    }

}
