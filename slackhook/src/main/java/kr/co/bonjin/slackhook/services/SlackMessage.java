package kr.co.bonjin.slackhook.services;

import com.slack.api.webhook.Payload;

public interface SlackMessage {
    Payload getPayload();
}
