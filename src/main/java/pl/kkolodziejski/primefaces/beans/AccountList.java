package pl.kkolodziejski.primefaces.beans;

import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.model.AccountModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "accountList")
public class AccountList {

    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void refreshAccountList() {
        AccountModel accountModel = new AccountModel();
        this.accounts = accountModel.findAll();
    }


    public AccountList() {
        refreshAccountList();
    }
}
