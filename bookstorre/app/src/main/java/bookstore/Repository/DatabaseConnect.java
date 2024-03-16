package bookstore.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";

    private static String username = "root";
    private static String password = "root";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
