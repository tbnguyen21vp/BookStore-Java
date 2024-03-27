package bookstorre.Repository;

import bookstorre.Model.Order;
import bookstorre.utils.DatabaseUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO  {
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE orderID = ?";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String UPDATE_ORDER_SQL = "UPDATE orders SET ... WHERE orderID = ?";
    private static final String DELETE_ORDER_SQL = "DELETE FROM orders WHERE orderID = ?";

    public class Order {
        // Existing code...

        public Order(ResultSet rs) throws SQLException {
            // Initialize Order object with data from ResultSet
            // Example:
            // this.orderID = rs.getString("orderID");
            // this.orderDate = rs.getDate("orderDate");
            // ...
        }

        // Existing code...
    }

    public List<Order> getAllOrders() throws SQLException, ClassNotFoundException {
        List<Order> orders = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();
        try (Connection connection = databaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                // Assuming Order class has a constructor that takes ResultSet or its data
                orders.add(new Order(rs));
            }
        }
        return orders;
    }

    public void updateOrder(Order order) throws SQLException, ClassNotFoundException {
        DatabaseUtils databaseUtils = new DatabaseUtils();
        try (Connection connection = databaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_SQL)) {
            // Set parameters from order object
            // preparedStatement.set...
            preparedStatement.executeUpdate();
        }
    }

    public void deleteOrder(String orderID) throws SQLException, ClassNotFoundException {
        DatabaseUtils databaseUtils = new DatabaseUtils();
        try (Connection connection = databaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_SQL)) {
            preparedStatement.setString(1, orderID);
            preparedStatement.executeUpdate();
        }
    }
}
