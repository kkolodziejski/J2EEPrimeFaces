package pl.kkolodziejski.primefaces.demo;

import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.model.AccountModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "accountManagedBean")
public class AccountManagedBean {

    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public AccountManagedBean() {
        AccountModel accountModel = new AccountModel();
        this.accounts = accountModel.findAll();
    }
}
