package pl.kkolodziejski.primefaces.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Function;

public class JpaService {

    private static JpaService instance;

    private final EntityManagerFactory entityManagerFactory;
    private JpaService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("primefaces-app-persistence-manager");
    }

    public static JpaService getInstance() {
        return instance == null ? instance = new JpaService() : instance;
    }

    public void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public <T> T runInTransaction(Function<EntityManager, T> runner) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean success = false;

        transaction.begin();

        try {
           T returnValue = runner.apply(entityManager);
            success = true;
            return returnValue;
        } finally {
            if (success) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
        }
    }

}
