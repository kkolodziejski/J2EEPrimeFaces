package pl.kkolodziejski.primefaces.beans;

import lombok.Getter;
import lombok.Setter;
import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.model.AccountModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "accountList")
@Getter
@Setter
public class AccountList {

    private final AccountModel accountModel = new AccountModel();

    private Account accountToDelete;
    private String name = "";
    private String phone = "";
    private List<Account> accounts = accountModel.findAll();

    public String addAccount() {
        AccountModel accountModel = new AccountModel();
        Account newAccount = new Account();
        newAccount.setName(name);
        newAccount.setPhone(phone);
        boolean result = accountModel.persistAccount(newAccount);
        if (result) {
            accounts.add(newAccount);
            return "success";
        }
        return "failure";
    }

    public String deleteAccount() {
        boolean result = accountModel.deleteAccount(accountToDelete);
        if (result) {
            accounts.remove(accountToDelete);
            return "success";
        }
        return "failure";
    }

}
