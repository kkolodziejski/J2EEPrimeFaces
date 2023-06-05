package pl.kkolodziejski.primefaces.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.util.HibernateUtil;

import java.util.List;

public class AccountModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Account> findAll() {
        List<Account> accounts = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Account ");
            accounts = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            accounts = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return accounts;
    }
}
