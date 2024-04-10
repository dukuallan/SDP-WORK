package org.pahappa.systems.kimanyisacco.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.pahappa.systems.kimanyisacco.models.Account;
import org.pahappa.systems.kimanyisacco.models.Member;
import org.pahappa.systems.kimanyisacco.models.Patient;
import org.pahappa.systems.kimanyisacco.models.Transaction;
import org.pahappa.systems.kimanyisacco.models.account.Invoice;
import org.pahappa.systems.kimanyisacco.models.account.ServiceOffered;

public class SessionConfiguration {
    private final static SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
            AnnotationConfiguration configuration = new AnnotationConfiguration();
            configuration.configure();

            configuration.addAnnotatedClass(Member.class);
            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(Transaction.class);
            configuration.addAnnotatedClass(Patient.class);
            configuration.addAnnotatedClass(Invoice.class);
            configuration.addAnnotatedClass(ServiceOffered.class);
            return configuration.buildSessionFactory();
        }catch (Throwable e){
            System.err.println("Failed to create session Factory: " +e);
            throw new ExceptionInInitializerError(e);

        }

    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
