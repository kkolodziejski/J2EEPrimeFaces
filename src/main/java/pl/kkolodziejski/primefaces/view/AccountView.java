package pl.kkolodziejski.primefaces.view;

import pl.kkolodziejski.primefaces.dao.AccountDao;
import pl.kkolodziejski.primefaces.model.Account;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AccountView {
    private List<Account> accountList;

    @PostConstruct
    public void init() {
    }

    public List<Account> getAccountList() {
        AccountDao accountDao = new AccountDao();
        accountList = accountDao.getAccounts();
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
