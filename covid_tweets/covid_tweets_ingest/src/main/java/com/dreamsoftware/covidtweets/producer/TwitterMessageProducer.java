package com.dreamsoftware.covidtweets.producer;

import com.dreamsoftware.covidtweets.mapper.TweetEntityMapper;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.CollectionUtils;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.TwitterStream;

/**
 *
 * @author ssanchez
 */
@Slf4j
@RequiredArgsConstructor
public class TwitterMessageProducer extends MessageProducerSupport {

    private final TwitterStream twitterStream;
    private final MessageChannel outputChannel;
    private final TweetEntityMapper tweetEntityMapper;

    @Getter
    @Setter
    private List<String> terms;

    /**
     * Init Message Producer
     */
    @Override
    protected void onInit() {
        super.onInit();
        logger.info("TwitterMessageProducer - onInit CALLED ");
    }

    /**
     * Start Message Producer
     */
    @Override
    protected void doStart() {
        logger.info("TwitterMessageProducer - doStart CALLED ");
        setOutputChannel(outputChannel);
        twitterStream.addListener(new StatusListener());
        twitterStream.filter(buildFilterQuery());
    }

    /**
     * Stop Message Producer
     */
    @Override
    protected void doStop() {
        logger.info("TwitterMessageProducer - doStop CALLED ");
        twitterStream.cleanUp();
        twitterStream.clearListeners();
    }

    /**
     * Private Methods
     */
    /**
     * Build Filter Query
     *
     * @return
     */
    private FilterQuery buildFilterQuery() {
        String[] termsArray = null;
        if (!CollectionUtils.isEmpty(terms)) {
            termsArray = terms.toArray(new String[0]);
        }
        final FilterQuery filterQuery = new FilterQuery(termsArray);
        filterQuery.language(new String[]{"en"});
        return filterQuery;
    }

    class StatusListener extends StatusAdapter {

        @Override
        public void onStatus(Status status) {
            logger.info("TwitterMessageProducer - onStatus sendMessage CALLED ");
            sendMessage(MessageBuilder
                    .withPayload(tweetEntityMapper.entityToDTO(status))
                    .build());
        }

        @Override
        public void onException(Exception ex) {
            logger.info("TwitterMessageProducer - onException CALLED -> " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }

        @Override
        public void onStallWarning(StallWarning warning) {
            logger.info("TwitterMessageProducer - onStallWarning CALLED -> " + warning.getMessage());
        }

    }

    @PostConstruct
    protected void onPostConstruct() {
        logger.info("TwitterMessageProducer - onPostConstruct");
        this.start();
    }
}
