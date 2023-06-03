package pl.kkolodziejski.primefaces.web;

import pl.kkolodziejski.primefaces.dao.AccountDao;
import pl.kkolodziejski.primefaces.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("accounts")
public class AccountServlet extends HttpServlet {

    private AccountDao accountDao;

    public void init() {
        accountDao = new AccountDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/form":
                    createAccountForm(request, response);
                    break;
                case "/register":
                    registerAccount(request, response);
                    break;
                default:
                    accountList(request, response);
                    break;
            }
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
    }

    private void accountList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Account> accounts = accountDao.getAccounts();
        request.setAttribute("accounts", accounts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("account-list.jsp");
        dispatcher.forward(request, response);
    }

    private void createAccountForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("account-form.jsp");
        dispatcher.forward(request, response);
    }

    private void registerAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        Account account = new Account(name, phone);
        accountDao.saveAccount(account);
        response.sendRedirect("list");
    }
}
