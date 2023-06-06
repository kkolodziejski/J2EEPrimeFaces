package pl.kkolodziejski.primefaces.demo;

import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.model.AccountModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "accountManagedBean")
public class AccountManagedBean {

    private String name = "";
    private String phone = "";
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String addAccount() {
        AccountModel accountModel = new AccountModel();
        Account account = new Account();
        account.setName(name);
        account.setPhone(phone);
        accountModel.persistAccount(account);
        this.accounts.add(account);
        return "success";
    }

    public AccountManagedBean() {
        AccountModel accountModel = new AccountModel();
        this.accounts = accountModel.findAll();
    }
}
