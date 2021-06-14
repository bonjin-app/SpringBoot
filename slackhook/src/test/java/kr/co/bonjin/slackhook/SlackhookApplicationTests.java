package kr.co.bonjin.slackhook;

import kr.co.bonjin.slackhook.enums.SlackMessageLevel;
import kr.co.bonjin.slackhook.services.SlackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SlackhookApplicationTests {

    @Autowired
    private SlackService slackService;

    @Test
    void contextLoads() {
        slackService.sendMessage(SlackMessageLevel.INFO);
    }

}
