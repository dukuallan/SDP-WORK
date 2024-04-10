package org.pahappa.systems.kimanyisacco.views.chat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String receiver;
    private LocalDateTime sentTime;
    private String content;

    public Message(String sender, String receiver, LocalDateTime sentTime, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.sentTime = sentTime;
        this.content = content;
    }

    // Getters
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public String getContent() {
        return content;
    }

    // Setters
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
