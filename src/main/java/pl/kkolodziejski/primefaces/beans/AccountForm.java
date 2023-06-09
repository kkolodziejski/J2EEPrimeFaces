package pl.kkolodziejski.primefaces.beans;

import pl.kkolodziejski.primefaces.entities.Account;
import pl.kkolodziejski.primefaces.model.AccountModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "accountForm")
public class AccountForm {

    private String name = "";
    private String phone = "";

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
        return "success";
    }

}
