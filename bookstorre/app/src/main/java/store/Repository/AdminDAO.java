package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Order;
import store.utils.DatabaseUtils;

public class AdminDAO {
    
    // add admin
    public boolean addAdmin(String username, String password) throws SQLException {
        Connection connection = DatabaseUtils.connectToDatabase();
        String query = "INSERT INTO admin (username, password) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding admin: " + e.getMessage());
            throw e;
        } finally {
            connection.close();
        }
    }
    
    // update admin
    public boolean updateAdmin(String username, String password) throws SQLException {
        Connection connection = DatabaseUtils.connectToDatabase();
        String query = "UPDATE admin SET password = ? WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error updating admin: " + e.getMessage());
            throw e;
        } finally {
            connection.close();
        }
    }
    // enable admin
    public boolean enableAdmin(String username) throws SQLException {
        Connection connection = DatabaseUtils.connectToDatabase();
        String query = "UPDATE admin SET status = 1 WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error enabling admin: " + e.getMessage());
            throw e;
        } finally {
            connection.close();
        }
    }
    // disable admin
    public boolean disableAdmin(String username) throws SQLException {
        Connection connection = DatabaseUtils.connectToDatabase();
        String query = "UPDATE admin SET status = 0 WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error disabling admin: " + e.getMessage());
            throw e;
        } finally {
            connection.close();
        }
    }

}
