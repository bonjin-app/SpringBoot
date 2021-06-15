package kr.co.bonjin.slackhook.model;

import com.slack.api.webhook.Payload;
import kr.co.bonjin.slackhook.services.SlackMessage;

public class SlackNormalMessage implements SlackMessage {

    private String text;

    public SlackNormalMessage(String text) {
        this.text = text;
    }

    @Override
    public Payload getPayload() {
        Payload payload = Payload.builder()
        .text(this.text)
//        .username("Slack WebHook Bot")  // default: 웹 설정값
//        .iconUrl("https://bonjin.co.kr/bonjin/images/sample.png")  // default: 웹 설정값
//        .iconEmoji(":ghost:")
        .build();
        return payload;
    }
}
