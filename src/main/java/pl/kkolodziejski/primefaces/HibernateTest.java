package pl.kkolodziejski.primefaces;

import pl.kkolodziejski.primefaces.model.Account;
import pl.kkolodziejski.primefaces.service.JpaService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class HibernateTest {

    private static final JpaService jpaService = JpaService.getInstance();

    public static void main(String[] args) {


        try {

            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(new Account("dzalapandzo", "+734126321"));
                entityManager.persist(new Account("dzalapandzo2", "+734126321"));
                entityManager.persist(new Account("dzalapandzo31", "+734126321"));

                return true;
            });

        } finally {
        jpaService.shutdown();
        }
    }
}
