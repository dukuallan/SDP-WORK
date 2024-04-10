package org.pahappa.systems.kimanyisacco.services;

import org.pahappa.systems.kimanyisacco.models.chat.Chat;
import org.pahappa.systems.kimanyisacco.models.users.User;
import org.pahappa.systems.kimanyisacco.services.observer.ChatObserver;


import java.util.List;

public interface ChatService extends ChatObserver {
    void saveChat(Chat chat) throws Exception;
    List<Chat> getAllChats(User user);
    boolean deleteChat(Long chat_id);
}
