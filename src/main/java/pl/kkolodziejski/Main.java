package pl.kkolodziejski;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.util.HibernateUtil;

import java.util.List;

public class Main {
//    List<Account> accounts = null;
//    Session session = null;
//    Transaction transaction = null;
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
//        Query query = session.createQuery("from Account ", Account.class);
        String nameTest = session.createSQLQuery("SELECT name FROM account ").getResultList().get(0).toString();
        session.getTransaction().commit();
//        AccountDao dao = new AccountDao();
//        List<Account> accounts = dao.getAccounts();
//        accounts.forEach(account -> System.out.println(account.getName()));
        System.out.println(nameTest);
        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        session2.beginTransaction();
        List<Account> accounts = session2.createQuery("from Account ", Account.class).getResultList();
        session2.getTransaction().commit();
        for (Account account : accounts) {
            System.out.println(account.getName());
        }
    }
}
