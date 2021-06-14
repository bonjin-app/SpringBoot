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
    public void sendMessage(String text) {
        logger.info("SlackServiceImpl sendMessage: {}", text);

        try {
            // create slack message
            Slack slack = Slack.getInstance();

            Payload payload = Payload.builder()
                    .text(text)
                    .username("Slack WebHook Bot")  // default: 웹 설정값
                    .iconUrl("https://bonjin.co.kr/bonjin/images/n2soft-logo.png")  // default: 웹 설정값
//                  .iconEmoji(":ghost:")
                    .build();

            WebhookResponse response = slack.send(WEBHOOK_URL, payload);
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
