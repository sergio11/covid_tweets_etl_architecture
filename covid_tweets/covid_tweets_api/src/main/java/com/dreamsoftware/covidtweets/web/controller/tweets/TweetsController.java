package com.dreamsoftware.covidtweets.web.controller.tweets;

import com.dreamsoftware.covidtweets.models.TweetDTO;
import com.dreamsoftware.covidtweets.service.impl.ITweetsService;
import com.dreamsoftware.covidtweets.web.controller.core.SupportController;
import com.dreamsoftware.covidtweets.web.controller.core.response.APIResponse;
import com.dreamsoftware.covidtweets.web.controller.core.response.ErrorResponseDTO;
import com.dreamsoftware.covidtweets.web.controller.tweets.error.exception.NoTweetsProcessedFoundException;
import com.dreamsoftware.covidtweets.web.controller.tweets.error.exception.TweetProcessedNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ssanchez
 */
@RestController
@Validated
@RequestMapping("/api/v1/tweets/")
@Tag(name = "tweets", description = "/api/v1/tweets/ (Code Response interval -> 1XX)")
@RequiredArgsConstructor
public class TweetsController extends SupportController {

    /**
     * Tweets Service
     */
    private final ITweetsService tweetsService;

    /**
     *
     * @param page
     * @param size
     * @return
     * @throws Throwable
     */
    @Operation(summary = "GET_TWEETS_PROCESSED - Get Tweets Processed", description = " Get Tweets Processed", tags = {"tweets"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notification List",
                content = @Content(schema = @Schema(implementation = Page.class))),
        @ApiResponse(responseCode = "404", description = "No Notifications found",
                content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse<Page<TweetDTO>>> getTweetsProcessed(
            @RequestParam(name = "page", required = false, defaultValue = "0") final Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") final Integer size) throws Throwable {

        final Page<TweetDTO> tweetsProcessedPage = tweetsService.findPaginated(page, size);

        if (!tweetsProcessedPage.hasContent()) {
            throw new NoTweetsProcessedFoundException();
        }

        return responseHelper.createAndSendResponse(
                TweetsProcessedResponseCodeEnum.GET_TWEETS_PROCESSED,
                HttpStatus.OK, tweetsProcessedPage);

    }

    /**
     *
     * @param id
     * @return
     * @throws Throwable
     */
    @Operation(summary = "GET_TWEET_PROCESSED_DETAIL - Get Tweet Processed Detail", description = "Get Tweet Processed Detail", tags = {"tweets"})
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse<TweetDTO>> getTweetProcessedById(
            @Parameter(name = "id", description = "Tweet Id", required = true)
            @PathVariable final Long id) throws Throwable {

        return tweetsService.findById(id)
                .map(tweetResource -> responseHelper.<TweetDTO>createAndSendResponse(TweetsProcessedResponseCodeEnum.GET_TWEET_PROCESSED_DETAIL, HttpStatus.OK, tweetResource))
                .orElseThrow(() -> {
                    throw new TweetProcessedNotFoundException();
                });
    }

}
