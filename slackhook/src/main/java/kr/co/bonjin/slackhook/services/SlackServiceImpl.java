package kr.co.bonjin.slackhook.services;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import kr.co.bonjin.slackhook.enums.SlackMessageLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

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
    public void sendMessage(String text) {
        Slack slack = Slack.getInstance();

        Payload payload = Payload.builder()
                .text(text)
//                .username("Slack WebHook Bot")  // default: incoming-webhook
//                .iconUrl("https://a.slack-edge.com/80588/img/icons/app-57.png")
//                .iconUrl("/images/n2soft-logo.png")
//                .iconEmoji(":ghost:")
                .build();

        try {
            WebhookResponse response = slack.send(INFO, payload);
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
