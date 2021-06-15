package kr.co.bonjin.slackhook.services;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class SlackServiceImpl implements SlackService {
    private static Logger logger = LoggerFactory.getLogger(SlackServiceImpl.class);

    @Value("${slack.webhook-url}")
    private String WEBHOOK_URL;

    public SlackServiceImpl() {}

    @PostConstruct
    public void init() {
        logger.info("SlackServiceImpl init");
        System.out.println("WEBHOOK_URL = " + WEBHOOK_URL);
    }

    @Override
    public void sendMessage(SlackMessage slackMessage) {
        logger.info("SlackServiceImpl sendMessage: {}", slackMessage.getPayload());

        try {
            Slack slack = Slack.getInstance();
            Payload payload = slackMessage.getPayload();

            WebhookResponse response = slack.send(WEBHOOK_URL, payload);
            logger.info("Webhook Response :{}", response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
