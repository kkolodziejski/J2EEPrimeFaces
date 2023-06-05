package pl.kkolodziejski.primefaces.web;

import pl.kkolodziejski.primefaces.dao.AccountDao;
import pl.kkolodziejski.primefaces.entities.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "accountServlet", value = "/account-servlet")
public class AccountServlet extends HttpServlet {

    private AccountDao accountDao;
    public void init() {
        accountDao = new AccountDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Account> accounts = accountDao.getAccounts();
        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("view_accounts.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        Account account = new Account(name, phone);

        accountDao.addAccount(account);
        handleRequest(request, response);

    }

    public void destroy() {
        accountDao = null;
    }
}
