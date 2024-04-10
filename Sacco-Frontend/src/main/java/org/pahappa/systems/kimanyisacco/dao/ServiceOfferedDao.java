package org.pahappa.systems.kimanyisacco.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
import org.pahappa.systems.kimanyisacco.models.account.ServiceOffered;

import java.util.List;

public class ServiceOfferedDao {
    public static void save(ServiceOffered serviceOffered){
        Transaction transaction = null;
        try{
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(serviceOffered);
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public static List<ServiceOffered> getServiceOffered(){
        Session session = SessionConfiguration.getSessionFactory().openSession();

        return session.createCriteria(ServiceOffered.class).list();
    }
}
