package kr.co.bonjin.javamail;

import kr.co.bonjin.javamail.provider.EmailProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavamailApplicationTests {

    @Autowired
    private EmailProvider emailProvider;


    @Test
    void contextLoads() {
    }

    @Test
    public void sendEmail() {
        String to = "tp.gigas@gmail.com";
        String subject = "메일 테스트";
        String text = "메일 내용";

        emailProvider.sendSimpleMessage(to, subject, text);
    }
}
