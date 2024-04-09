package org.pahappa.systems.kimanyisacco.models.chat;

import org.pahappa.systems.kimanyisacco.models.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        Chat chat = (Chat) o;
        return Objects.equals(getSender(), chat.getSender()) && Objects.equals(getReceiver(), chat.getReceiver()) && Objects.equals(getSentTime(), chat.getSentTime()) && Objects.equals(getDescription(), chat.getDescription()) && Objects.equals(getId(), chat.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSender(), getReceiver(), getSentTime(), getDescription(), getId());
    }
}
