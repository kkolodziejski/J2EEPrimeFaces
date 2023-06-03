package pl.kkolodziejski.primefaces;

import pl.kkolodziejski.primefaces.model.Account;
import pl.kkolodziejski.primefaces.service.JpaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/database-operations")
public class DbOperationsServlet extends HttpServlet {

    private JpaService jpaService;

    public void init() {
        jpaService = JpaService.getInstance();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/DisplayInfo.jsp";

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        Account account = new Account(name, phone);

        updateDB(account);

        request.setAttribute("account", account);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void updateDB(Account account) {

        try {
            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(account);
                return null;
            });
        } finally {
            jpaService.shutdown();
        }

    }

    public void destroy() {
    }

}
