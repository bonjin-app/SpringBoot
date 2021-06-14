package kr.co.bonjin.slackhook.services;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import kr.co.bonjin.slackhook.enums.SlackMessageLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

@Service
public class SlackServiceImpl implements SlackService {

    @Value("${slack.webhook-url.info}")
    private String INFO;

    @Value("${slack.webhook-url.warn}")
    private String WARN;

    @Value("${slack.webhook-url.error}")
    private String ERROR;

    public SlackServiceImpl() {}

    @PostConstruct
    public void init() {
        System.out.println("INFO = " + INFO);
        System.out.println("WARN = " + WARN);
        System.out.println("ERROR = " + ERROR);
    }

    @Override
    public void sendMessage(SlackMessageLevel messageLevel) {
        Slack slack = Slack.getInstance();
        String webhookUrl = getWebHookUrl(messageLevel);
        System.out.println("webhookUrl = " + webhookUrl);

        Payload payload = Payload.builder()
                .text("Hello World!")
                .build();

        try {
            WebhookResponse response = slack.send(webhookUrl, payload);
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getWebHookUrl(SlackMessageLevel messageLevel) {
        if (SlackMessageLevel.INFO == messageLevel) {
            return INFO;
        } else if (SlackMessageLevel.WARN == messageLevel) {
            return WARN;
        } else if (SlackMessageLevel.ERROR == messageLevel) {
            return ERROR;
        } else {
            return "";
        }
    }
}
