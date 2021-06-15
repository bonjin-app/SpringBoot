package kr.co.bonjin.slackhook.services;

import kr.co.bonjin.slackhook.exception.ApiError;
import kr.co.bonjin.slackhook.model.SlackErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SlackServiceImplTest {

    @Autowired
    private SlackService slackService;


    @Test
    void sendMessageTEST() {
        SlackMessage slackMessage = new SlackErrorMessage(ApiError.INTERNAL_SERVER_ERROR,
                "https://bonjin.co.kr/bonjin/images/sample.png");
        slackService.sendMessage(slackMessage);
    }
}