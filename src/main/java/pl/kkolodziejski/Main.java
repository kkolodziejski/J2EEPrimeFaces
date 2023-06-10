package pl.kkolodziejski;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        String hql = "";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Account accountToDelete = new Account();
        accountToDelete.setId(49L);
        session.beginTransaction();
//        session.persist(new Account("pepedziobak", "+743625"));
//        session.getTransaction().commit();
//        session.createQuery("delete from Account where name = :DziobakRefresh");
        session.delete(accountToDelete);
        List<Account> accounts = session.createQuery("from Account ", Account.class).getResultList();
        session.close();
//        accounts.removeIf(account -> Objects.equals(account.getName(), "Mike"));
        for (Account account : accounts) {
            System.out.println(account.getName());
        }
    }
}
