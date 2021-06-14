package kr.co.bonjin.slackhook.services;

import com.slack.api.Slack;
import kr.co.bonjin.slackhook.enums.SlackMessageLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
@Async("taskExecutor")
public class SlackServiceImpl implements SlackService {

    @Value("${slack.webhook-url.info}")
    private String INFO;

    @Value("${slack.webhook-url.warn}")
    private String WARN;

    @Value("${slack.webhook-url.error}")
    private String ERROR;

    public SlackServiceImpl() {

    }

    @PostConstruct
    public void init() {
        System.out.println("INFO = " + INFO);
        System.out.println("WARN = " + WARN);
        System.out.println("ERROR = " + ERROR);
    }

    @Override
    public void sendMessage(Map<String, String> fieldMap, SlackMessageLevel messageLevel) {
        Slack slack = Slack.getInstance();

    }
}
