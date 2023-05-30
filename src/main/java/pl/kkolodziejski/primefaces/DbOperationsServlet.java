package pl.kkolodziejski.primefaces;

import pl.kkolodziejski.primefaces.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static pl.kkolodziejski.primefaces.db.DbFunctions.updateDatabase;

@WebServlet("/database-operations")
public class DbOperationsServlet extends HttpServlet {

    public DbOperationsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/DisplayInfo.jsp";

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        Account account = new Account();
        account.setName(name);
        account.setPhone(phone);

        updateDB(name, phone);

        request.setAttribute("account", account);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void updateDB(String name, String phone) {
        Connection con;

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/j2ee";
            String user = "kkolodziejski";
            String pw = "guest";

            // Used to issue queries to the DB
            con = DriverManager.getConnection(url, user, pw);

            // Sends queries to the DB for results
            Statement s = con.createStatement();

            // Add a new entry
            String query = "INSERT INTO account " +
                    "(name, phone) " +
                    "VALUES ('" + name + "', '" +
                    phone + "')";

            // Execute the Query
            s.executeUpdate(query);

            // Close DB connection
            con.close();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String url = "/DisplayInfo.jsp";
//
//        String name = request.getParameter("name");
//        String phone = request.getParameter("phone");
//
//        Account account = new Account();
//        account.setName(name);
//        account.setPhone(phone);
//
//        updateDatabase(account);
//
//        request.setAttribute("account", account);
//
//        getServletContext().getRequestDispatcher(url).forward(request, response);
//    }

}
