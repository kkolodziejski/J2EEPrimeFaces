package pl.kkolodziejski.primefaces.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AccountModel {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private List<Account> accounts = new ArrayList<>();

    public List<Account> findAll() {
        List<Account> accounts;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query<Account> query = session.createQuery("from Account ", Account.class);
            accounts = query.getResultList();
            transaction.commit();
            this.accounts.addAll(accounts);
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

    public Account findById(Long id) {
        Account account;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            account = session.get(Account.class, id);
        } finally {
            assert session != null;
            session.close();
        }
        return account;
    }

    public boolean persistAccount(Account account) {
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
            return false;
        } finally {
            assert session != null;
            session.close();
        }
        return true;
    }

    public void editAccount(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
        } finally {
            assert session != null;
            session.close();
        }
    }

    public boolean deleteAccount(Account account) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(account);
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            return false;
        } finally {
            assert session != null;
            session.close();
        }
        return true;
    }
}
