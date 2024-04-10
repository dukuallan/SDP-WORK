package org.pahappa.systems.kimanyisacco.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
import org.pahappa.systems.kimanyisacco.models.Patient;

import java.util.List;

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

    public List<Patient> getAllPatients() {
        List<Patient> patients = null;
        try {
            session = SessionConfiguration.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Patient");
            patients = (List<Patient>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return patients;
    }
}
