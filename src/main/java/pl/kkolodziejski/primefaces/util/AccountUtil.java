package pl.kkolodziejski.primefaces.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pl.kkolodziejski.primefaces.entities.Account;

public class AccountUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {

        if(sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();

            configuration.addAnnotatedClass(Account.class);


            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }


        return sessionFactory;
    }

}
