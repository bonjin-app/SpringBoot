package kr.co.bonjin.slackhook.model;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class SlackMessage {
    private String text;
    private String channel;
    private String username;
    private String iconEmoji;
    private String iconUrl;

    public SlackMessage(String text, String channel, String username, String iconEmoji, String iconUrl) {
        this.text = text;
        this.channel = channel;
        this.username = username;

        if (!ObjectUtils.isEmpty(iconEmoji)) {
            this.iconEmoji = iconEmoji;
        }

        if (!ObjectUtils.isEmpty(iconUrl)) {
            this.iconUrl = iconUrl;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIconEmoji() {
        return iconEmoji;
    }

    public void setIconEmoji(String iconEmoji) {
        this.iconEmoji = iconEmoji;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
