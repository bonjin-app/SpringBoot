package kr.co.bonjin.slackhook.model;

import com.slack.api.model.block.LayoutBlock;
import com.slack.api.webhook.Payload;
import kr.co.bonjin.slackhook.exception.ApiError;
import kr.co.bonjin.slackhook.services.SlackMessage;

import java.util.ArrayList;
import java.util.List;

public class SlackErrorMessage implements SlackMessage {

    private ApiError error;
    private String imageUrl;

    public SlackErrorMessage(ApiError error, String imageUrl) {
        this.error = error;
        this.imageUrl = imageUrl;
    }

    @Override
    public Payload getPayload() {
        // Blocks Config
        List<LayoutBlock> blockList = new ArrayList<>();
        blockList.add(SlackMessageBlock.getHeader(":exclamation: An error has occurred :exclamation:"));
        blockList.add(SlackMessageBlock.getDivider());
        blockList.add(SlackMessageBlock.getSection("*ERROR*"));
        blockList.add(SlackMessageBlock.getSection(
                "*Type:* " + this.error.getCode() + " Error\n" +
                        "*Comments:* " + this.error.getMessage(),
                this.imageUrl, "image"));
        blockList.add(SlackMessageBlock.getDivider());

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
        return payload;
    }
}
