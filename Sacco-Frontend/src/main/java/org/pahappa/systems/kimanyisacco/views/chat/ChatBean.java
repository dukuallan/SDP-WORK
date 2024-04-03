package org.pahappa.systems.kimanyisacco.views.chat;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class ChatBean{
    private String currentUser;
    private List<String> receivers;
    private List<String> selectedReceivers;
    private List<Message> messages;

 @PostConstruct
 public void init() {
     this.messages=new ArrayList<>();
     this.receivers = new ArrayList<>();
     this.selectedReceivers = new ArrayList<>();
     this.currentUser = "admin";
     receivers.add("user");
     receivers.add("admin");
     receivers.add("Accountant");
     receivers.add("Manager");
     messages.add(new Message("admin", "user", LocalDateTime.now(), "Hello, how are you?"));
     messages.add(new Message("user", "admin", LocalDateTime.now(), "I am fine, thank you"));
     messages.add(new Message("admin", "user", LocalDateTime.now(), "I am doing great. Thank you"));
     messages.add(new Message("user", "admin", LocalDateTime.now(), "I am doing good. How about you?"));
     messages.add(new Message("admin", "user", LocalDateTime.now(), "I am doing good. Hope you are doing great?"));
     messages.add(new Message("user", "admin", LocalDateTime.now(), "yaaa u a right. But how is the work?"));
 }
    public void sendMessage() {

    }
    public String getFormattedSentTime(LocalDateTime sentTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return sentTime.format(formatter);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public List<String> getSelectedReceivers() {
        return selectedReceivers;
    }

    public void setSelectedReceivers(List<String> selectedReceivers) {
        this.selectedReceivers = selectedReceivers;
    }
}
