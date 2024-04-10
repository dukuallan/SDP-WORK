package org.pahappa.systems.kimanyisacco.dao.accountReconcilationDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
<<<<<<< HEAD
import org.pahappa.systems.kimanyisacco.models.AccountReceivable;
=======
import org.pahappa.systems.kimanyisacco.models.account.AccountReceivable;
>>>>>>> origin/ft-chat

import java.util.List;

public class AccountReceivableDao {
    public void saveToAccountReceivable(AccountReceivable obj){
        Transaction transaction = null;

        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public List<AccountReceivable> getAllAccountReceivableEntries() {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(AccountReceivable.class);
        return criteria.list();

    }

    public void updateAccountReceivable(AccountReceivable obj){
        Transaction transaction = null;
        try {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(obj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}
