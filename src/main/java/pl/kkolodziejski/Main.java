package pl.kkolodziejski;

import pl.kkolodziejski.primefaces.dao.AccountDao;
import pl.kkolodziejski.primefaces.entities.Account;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AccountDao dao = new AccountDao();
        List<Account> accounts = dao.getAccounts();
        accounts.forEach(account -> System.out.println(account.getName()));
    }
}
