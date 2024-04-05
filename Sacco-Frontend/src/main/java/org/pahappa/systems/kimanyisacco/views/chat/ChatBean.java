package org.pahappa.systems.kimanyisacco.views.chat;

import org.pahappa.systems.kimanyisacco.models.chat.Chat;
import org.pahappa.systems.kimanyisacco.models.users.User;
import org.pahappa.systems.kimanyisacco.services.ChatService;
import org.pahappa.systems.kimanyisacco.services.UserService;
import org.pahappa.systems.kimanyisacco.services.impl.ChatServiceImpl;
import org.pahappa.systems.kimanyisacco.services.impl.UserServiceImpl;

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
    private List<User> receivers=new ArrayList<>();;
    private List<User> selectedReceivers= new ArrayList<>();
    private UserService userService;
    private ChatService chatService;
    private List<Chat> chats=new ArrayList<>();

 @PostConstruct
 public void init() {
     this.userService =new UserServiceImpl();
     this.chatService = new ChatServiceImpl();
     this.receivers = userService.getAllUsers();
     this.chats=chatService.getAllChats();
     this.currentUser = "admin";

 }
    public void sendMessage() {

    }
    public String getFormattedSentTime(LocalDateTime sentTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return sentTime.format(formatter);
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public List<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<User> receivers) {
        this.receivers = receivers;
    }

    public List<User> getSelectedReceivers() {
        return selectedReceivers;
    }

    public void setSelectedReceivers(List<User> selectedReceivers) {
        this.selectedReceivers = selectedReceivers;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}
