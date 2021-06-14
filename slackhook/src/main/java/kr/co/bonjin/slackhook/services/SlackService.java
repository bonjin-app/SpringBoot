package kr.co.bonjin.slackhook.services;

import kr.co.bonjin.slackhook.enums.SlackMessageLevel;

import java.util.Map;

public interface SlackService {
    void sendMessage(SlackMessageLevel messageLevel);
}
