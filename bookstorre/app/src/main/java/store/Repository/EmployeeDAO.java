package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Book;
import store.utils.DatabaseUtils;

public class EmployeeDAO {



    // add employee
    public boolean addEmployee(String name, String email, String phone, String address, String username, String password) throws SQLException {
        Connection connection = DatabaseUtils.connectToDatabase();
        String query = "INSERT INTO employee (name, email, phone, address, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
            throw e;
        } finally {
            connection.close();
        }
    }

}