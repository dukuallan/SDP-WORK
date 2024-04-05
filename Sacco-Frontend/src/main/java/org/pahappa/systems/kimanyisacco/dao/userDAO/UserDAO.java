package org.pahappa.systems.kimanyisacco.dao.userDAO;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
import org.pahappa.systems.kimanyisacco.models.users.User;

import java.util.List;
public class UserDAO {
    public void save(User user) throws Exception{
        Transaction transaction = null;
        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e.getMessage());
        }
    }
    public List<User> getUsers() {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("FROM User WHERE status = :status");
            query.setParameter("status", 0);
            return (List<User>) query.list();
        } catch (Exception e) {
            System.out.println("No user available");
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    // login method
    public User getUser(Long userid) {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        Query query = session.createQuery("FROM User WHERE user_id = :userId");
        query.setParameter("userId", userid);
        try {
            return (User) query.uniqueResult();
        }catch (Exception e){
            return null;
        }finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    // Disabling a user of the system
    public boolean deleteUser(Long userId) {
        Transaction transaction = null;
        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Create a criteria instance for the User class
            Criteria criteria = session.createCriteria(User.class);
            // create criteria to check the account for the member
            criteria.add(Restrictions.eq("userId", userId));
            // Get the user (if found) based on the criteria
            User user = (User) criteria.uniqueResult();
            if ((user != null)) {
                // Delete the user
                user.setStatus(1);
                session.update(user);
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
    public boolean checkEmail(String email) {
        Transaction transaction = null;

        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // Create a criteria instance for the User class
            Criteria criteria = session.createCriteria(User.class);
            // create criteria to check the user for the email
            criteria.add(Restrictions.eq("email", email));
            // Get the user (if found) based on the criteria
            User user = (User) criteria.uniqueResult();
            if(user!=null){
                return false;
            }
            else
                return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    //check if the phone already exists in the system
    public boolean checkPhone(String phone) {
        Transaction transaction = null;
        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            // Create a criteria instance for the User class
            Criteria criteria = session.createCriteria(User.class);
            // create criteria to check the user for the email
            criteria.add(Restrictions.eq("phone", phone));
            // Get the user (if found) based on the criteria
            User user = (User) criteria.uniqueResult();
            if(user !=null){
                return false;
            }
            else
                return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    //update the user details
    public boolean updateUser(User user) {
        Transaction transaction = null;

        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
