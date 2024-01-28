package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DATABASE_USER = "your_username";
    private static final String DATABASE_PASSWORD = "your_password";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu MySQL.");
            e.printStackTrace();
        }
        return connection;
    }
}