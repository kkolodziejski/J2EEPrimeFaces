package pl.kkolodziejski.primefaces.beans;

import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.model.AccountModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "accountView")
public class AccountView {

    private String accountId;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void loadAccountData() {
        AccountModel accountModel = new AccountModel();
        this.account = accountModel.findById(Long.valueOf(accountId));
    }

    public AccountView() {
    }
}
