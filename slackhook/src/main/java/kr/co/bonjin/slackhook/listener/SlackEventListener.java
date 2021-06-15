package kr.co.bonjin.slackhook.listener;

import kr.co.bonjin.slackhook.model.SlackNormalMessage;
import kr.co.bonjin.slackhook.services.SlackMessage;
import kr.co.bonjin.slackhook.services.SlackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SlackEventListener {

    private static final Logger logger = LoggerFactory.getLogger(SlackEventListener.class);

    private SlackService slackService;

    public SlackEventListener(SlackService slackService) {
        this.slackService = slackService;
    }

    @EventListener(ApplicationReadyEvent.class)
    void doSomethingAfterStartup() {
        logger.info("doSomethingAfterStartup");

        SlackMessage slackMessage = new SlackNormalMessage("[APPLICATION_STARTED]");
        slackService.sendMessage(slackMessage);
    }

    @EventListener(ApplicationFailedEvent.class)
    void doSomethingAfterFailure() {
        logger.info("doSomethingAfterFailure");

        SlackMessage slackMessage = new SlackNormalMessage("[APPLICATION_FAILED]");
        slackService.sendMessage(slackMessage);
    }
}
