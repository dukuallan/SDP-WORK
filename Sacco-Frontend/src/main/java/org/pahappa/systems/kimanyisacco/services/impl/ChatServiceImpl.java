package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.dao.chatDao.ChatDao;
import org.pahappa.systems.kimanyisacco.models.chat.Chat;
import org.pahappa.systems.kimanyisacco.services.ChatService;

import java.util.List;

public class ChatServiceImpl implements ChatService {
    private ChatDao chatDao = new ChatDao();

    @Override
    public void saveChat(Chat chat) throws Exception {
        chatDao.save(chat);
    }

    @Override
    public List<Chat> getAllChats() {
        return chatDao.getAllChats();
    }

    @Override
    public boolean deleteChat(Long chat_id) {
        return chatDao.deleteChat(chat_id);
    }
}