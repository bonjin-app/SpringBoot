package kr.co.bonjin.slackhook.services;

import com.slack.api.Slack;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import kr.co.bonjin.slackhook.model.SlackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            // Blocks Config
            List<LayoutBlock> blockList = new ArrayList<>();
            blockList.add(SlackMessage.getHeader(":exclamation: An error has occurred :exclamation:"));
            blockList.add(SlackMessage.getDivider());
            blockList.add(SlackMessage.getSection("*Error*"));
            blockList.add(SlackMessage.getSection(
                    "*Type:* 404 Error\n*When:* Aug 10-Aug 13\n*Hours:* 16.0 (2 days)\n*Comments:* \"Page Not Found\"",
                    "https://miro.medium.com/max/800/1*hFwwQAW45673VGKrMPE2qQ.png",
                    "computer thumbnail"));
            blockList.add(SlackMessage.getDivider());

            Payload payload = Payload.builder()
                    .blocks(blockList)
                    .build();

            // Non Blocks
//            Payload payload = Payload.builder()
//                    .text(text)
//                    .username("Slack WebHook Bot")  // default: 웹 설정값
//                    .iconUrl("https://bonjin.co.kr/bonjin/images/sample.png")  // default: 웹 설정값
////                  .iconEmoji(":ghost:")
//                    .build();

            WebhookResponse response = slack.send(WEBHOOK_URL, payload);
            logger.info("Webhook Response :{}", response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
