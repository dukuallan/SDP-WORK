package org.pahappa.systems.kimanyisacco.models.chat;

import org.pahappa.systems.kimanyisacco.models.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "chats")
public class Chat {
    private User sender;
    private User receiver;
    private LocalDateTime sentTime;
    private String description;
    private Long id;
    @ManyToOne
    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
@ManyToOne
    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
@Column(name="sent_time")
    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }
@Column(name = "content")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
