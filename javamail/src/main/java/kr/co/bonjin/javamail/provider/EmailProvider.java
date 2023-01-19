package kr.co.bonjin.javamail.provider;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailProvider {

    // Java 메일
    private JavaMailSender javaMailSender;

    // Thymeleaf Template 사용
    private TemplateEngine templateEngine;

    // 의존성 주입
    public EmailProvider(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    /**
     * Mail 전송 함수
     *
     * @param to
     * @param subject
     * @param value
     */
    public void sendSimpleMessage(String to, String subject, String value) {
        // Thymeleaf 사용
        MimeMessagePreparator message = mimeMessage -> {

            String template = "test";

            String content = build(value, template);

            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);
        };
        javaMailSender.send(message);
    }

    /**
     * Thymeleaf 셋팅
     *
     * @return
     */
    private String build(String value, String template) {
        Context context = new Context();
        context.setVariable("value", value);
        return templateEngine.process(template, context);
    }
}
