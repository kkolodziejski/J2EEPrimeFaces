package pl.kkolodziejski.primefaces.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.kkolodziejski.primefaces.model.Account;
import pl.kkolodziejski.primefaces.util.AccountUtil;

import java.util.List;

public class AccountDao {

    public void addAccount(Account account) {
        SessionFactory sessionFactory = AccountUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    public List<Account> getAccounts() {
        SessionFactory sessionFactory = AccountUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Account> accounts = session.createQuery("from Account", Account.class).getResultList();
        session.close();
        return accounts;
    }

}