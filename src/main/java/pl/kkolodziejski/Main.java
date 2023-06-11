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
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("dziobak1", "dziobafone"));
        accounts.add(new Account("dziobak2", "dziobafone"));
        accounts.add(new Account("dziobak3", "dziobafone"));
        accounts.add(new Account("dziobak4", "dziobafone"));
        accounts.replaceAll(account -> {
            if (account.getName().equals("dziobak2")) {
                account.setName("changedDziobak");
                return account;
            };
            return account;
        });
        for (Account account : accounts) {
            System.out.println(account.getName());
        }
    }
}
