package org.pahappa.systems.kimanyisacco.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
import org.pahappa.systems.kimanyisacco.models.Patient;

public class PatientDao {
    Transaction transaction = null;
    Session session = null;
    public void save(Patient patient){
        try{
            session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        } catch(Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Patient getPatientById(long id) {
        try {
            session = SessionConfiguration.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Patient WHERE id = :id");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
