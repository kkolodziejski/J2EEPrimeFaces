package pl.kkolodziejski.primefaces.bean;

import pl.kkolodziejski.primefaces.entities.Account;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "bean")
@SessionScoped
public class AccountBean implements Serializable {
    private List<Account> accounts;

    public AccountBean() {
//        AccountDao accountDao = new AccountDao();
//        accounts = new ArrayList<Account>(accountDao.getAccounts());
        this.accounts = new ArrayList<>();
        this.accounts.add(new Account("Mike", "12"));
        this.accounts.add(new Account("Mike2", "12"));
        this.accounts.add(new Account("Mike3", "12"));
        this.accounts.add(new Account("Mike4", "12"));
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
