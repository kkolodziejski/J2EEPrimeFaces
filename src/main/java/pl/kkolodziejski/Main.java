package pl.kkolodziejski;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.util.HibernateUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.persist(new Account("pepedziobak", "+743625"));
        session.getTransaction().commit();
        session.close();
    }
}
