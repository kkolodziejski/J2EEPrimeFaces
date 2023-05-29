package pl.kkolodziejski.primefaces.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFunctions {

        public Connection connectToDb(String databaseName, String user, String password) {
                Connection connection = null;

                try {
                        connection = DriverManager.getConnection("jdbc:postgresql://postgressql:5432/" + databaseName, user, password);
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

}
