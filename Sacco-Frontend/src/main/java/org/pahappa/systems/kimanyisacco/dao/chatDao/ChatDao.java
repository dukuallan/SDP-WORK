package org.pahappa.systems.kimanyisacco.dao.chatDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
import org.pahappa.systems.kimanyisacco.models.chat.Chat;

import java.util.List;

public class ChatDao {
    public void save(Chat chat) throws Exception{
        Transaction transaction = null;
        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(chat);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e.getMessage());
        }
    }
    public List<Chat> getAllChats() {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        try {
            return session.createCriteria(Chat.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public boolean deleteChat(Long chatId) {
        Transaction transaction = null;
        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Create a criteria instance for the User class
            Criteria criteria = session.createCriteria(Chat.class);
            // create criteria to check the account for the member
            criteria.add(Restrictions.eq("chatId", chatId));
            // Get the user (if found) based on the criteria
           Chat chat = (Chat) criteria.uniqueResult();
            if ((chat != null)) {
                session.delete(chat);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
