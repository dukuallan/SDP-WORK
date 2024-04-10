package org.pahappa.systems.kimanyisacco.views.chat;

import org.pahappa.systems.kimanyisacco.models.chat.Chat;
import org.pahappa.systems.kimanyisacco.models.users.User;
import org.pahappa.systems.kimanyisacco.services.ChatService;
import org.pahappa.systems.kimanyisacco.services.UserService;
import org.pahappa.systems.kimanyisacco.services.impl.ChatServiceImpl;
import org.pahappa.systems.kimanyisacco.services.impl.UserServiceImpl;
import org.pahappa.systems.kimanyisacco.views.Messages.MessageComposer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ManagedBean
@SessionScoped
public class ChatBean{
    private List<User> receivers=new ArrayList<>();;
    private String[] selectedReceivers;
    private UserService userService;
    private ChatService chatService;
    private Chat chat;
    private List<Chat> chats=new ArrayList<>();

 @PostConstruct
 public void init() {
     this.userService =new UserServiceImpl();
     this.chatService = new ChatServiceImpl();
     reloadView();
     this.chat=new Chat();

 }
    public void sendMessage() {
     LocalDateTime sent= LocalDateTime.now();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        User user1 = (User) facesContext.getExternalContext().getSessionMap().get("User");
        System.out.println("selected users size "+selectedReceivers.length);
     if(user1 !=null && (selectedReceivers.length !=0)) {
         for (String user : selectedReceivers) {
             System.out.println("Logged in user "+user1.getLastname()+"Email"+user);
             this.chat.setReceiver(userService.getUserByEmail(user));
             this.chat.setSender(user1);
           this.chat.setSentTime(sent);
             try {
                 chatService.saveChat(this.chat);
                 reloadView();
             } catch (Exception e) {
                 MessageComposer.warn("Failure!", "Chat not saved to the database");
             }
         }
         MessageComposer.compose("Success","Message sent to the receivers");
     }else
         MessageComposer.compose("Failed","No user in the session!");
    }
    public String getFormattedSentTime(LocalDateTime sentTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return sentTime.format(formatter);
    }


    public List<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<User> receivers) {
        this.receivers = receivers;
    }


    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
    public void getChatsByUser(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        User user = (User) facesContext.getExternalContext().getSessionMap().get("User");
        this.chats= chatService.getAllChats(user);
    }
    public void reloadView(){
        this.receivers = userService.getAllUsers();
        getChatsByUser();
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
 }

    public String[] getSelectedReceivers() {
        return selectedReceivers;
    }

    public void setSelectedReceivers(String[] selectedReceivers) {
        this.selectedReceivers = selectedReceivers;
    }
}
