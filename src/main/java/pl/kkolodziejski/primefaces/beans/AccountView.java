package pl.kkolodziejski.primefaces.beans;

import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.model.AccountModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "accountView")
public class AccountView {

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void loadAccountData(String id) {
        AccountModel accountModel = new AccountModel();
        this.account = accountModel.findById(Long.valueOf(id));
    }

    public AccountView() {
    }
}
