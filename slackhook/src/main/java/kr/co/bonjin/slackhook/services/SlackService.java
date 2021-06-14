package kr.co.bonjin.slackhook.services;

import kr.co.bonjin.slackhook.enums.SlackMessageLevel;

public interface SlackService {
    void sendMessage(SlackMessageLevel messageLevel);
}
