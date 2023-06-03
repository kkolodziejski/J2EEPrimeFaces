package pl.kkolodziejski.primefaces.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.kkolodziejski.primefaces.model.Account;
import pl.kkolodziejski.primefaces.service.JpaService;
//import pl.kkolodziejski.primefaces.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    public void saveAccount(Account account) {
//        Transaction transaction = null;
//        boolean success = false;
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(account);
//            success = true;
//        } finally {
//            if (success) {
//                transaction.commit();
//            } else {
//                if(transaction != null) {
//                    transaction.rollback();
//                }
//            }
//        }
        JpaService jpaService = null;
        try {
            jpaService = JpaService.getInstance();
            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(account);
                return true;
            });
        } finally {
            assert jpaService != null;
            jpaService.shutdown();
        }


    }

    public List<Account> getAccounts() {
        Transaction transaction = null;
        boolean success = false;
//        List<Account> accounts = null;

        JpaService jpaService = null;

        Account account1 = new Account("dzalapapana", "21313");
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);

//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            accounts = session.createQuery("FROM Account").getResultList();
//            success = true;
//        } finally {
//            if (success) {
//                transaction.commit();
//            } else {
//                if(transaction != null) {
//                    transaction.rollback();
//                }
//            }
//        }
        return accounts;
    }

}

