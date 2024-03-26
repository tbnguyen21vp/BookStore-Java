package bookstorre.Service;

import java.sql.*;

import javax.sql.PooledConnection;
import javax.xml.crypto.Data;

public class DatabaseUtils {
    private String url;
    private String user;
    private String password;

    public DatabaseUtils() {
        this.url = "jdbc:mysql://localhost:3307/bookstore";
        this.user = "root";
        this.password = "123456";
    }

    public DatabaseUtils(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection connect() throws ClassNotFoundException, SQLException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish a connection
        return DriverManager.getConnection(url, user, password);
    }

    private PooledConnection connectPool() throws ClassNotFoundException, SQLException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish a connection
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn.unwrap(PooledConnection.class);
    }
//  using

    public void printTableNames() {
        try (Connection conn = connect()) {
            // Get DatabaseMetaData
            DatabaseMetaData dbmd = conn.getMetaData();
            // Get a list of tables
            ResultSet rs = dbmd.getTables(null, null, null, new String[] { "TABLE" });
            // Print the table names
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
}
