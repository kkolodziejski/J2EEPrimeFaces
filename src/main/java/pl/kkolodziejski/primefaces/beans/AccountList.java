package pl.kkolodziejski.primefaces.beans;

import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.model.AccountModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "accountList")
public class AccountList {

    private Account accountToDelete;
    private final AccountModel accountModel = new AccountModel();

    private List<Account> accounts = accountModel.findAll();

    public Account getAccountToDelete() {
        return accountToDelete;
    }

    public void setAccountToDelete(Account accountToDelete) {
        this.accountToDelete = accountToDelete;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void deleteAccount() {
        boolean result = accountModel.deleteAccount(accountToDelete);
        if (result) {
            accounts.remove(accountToDelete);
        }
    }

}
