package pl.kkolodziejski.primefaces.db;

import pl.kkolodziejski.primefaces.model.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbFunctions {

        public static Connection connectToDb(String databaseName, String user, String password) {
                Connection connection = null;

                try {
                        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + databaseName, user, password);
                        if(connection != null) {
                                System.out.println("Connected to: " + databaseName);
                        } else {
                                System.out.println("Connection to: " + databaseName + " failed.");
                        }

                } catch (SQLException error) {
                        error.printStackTrace();
                }

                return connection;
        }

        public static void updateDatabase(Account account) {

                try {
                Connection connection = connectToDb("j2ee", "kkolodziejski", "guest");
//                Statement statement = connection.createStatement();
//
//                String query = "INSERT INTO account (name, phone) VALUES('" + account.getName() + "', '" + account.getPhone() + "'";
//
//                statement.executeUpdate(query);

                connection.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

}
