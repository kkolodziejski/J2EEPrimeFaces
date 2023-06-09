package pl.kkolodziejski.primefaces.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class AccountModel {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private List<Account> accounts = new ArrayList<>();

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Account> findAll() {
        List<Account> accounts = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Account ", Account.class);
            accounts = query.getResultList();
            transaction.commit();
            for (Account account : accounts) {
                this.accounts.add(account);
                System.out.println(account.getName());
            }
        } catch (Exception e) {
            this.accounts = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            assert session != null;
            session.close();
        }
        return this.accounts;
    }

    public void persistAccount(Account account) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(account);
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
        } finally {
            assert session != null;
            session.close();
        }
    }
}
