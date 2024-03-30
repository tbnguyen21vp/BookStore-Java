package store.Repository;

import store.Model.Order;
import store.Model.OrderDetail;
import store.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static final String GET_ALL_ORDERS = "SELECT DISTINCT o.orderID, o.date, o.customerID, o.employeeID, o.discount, o.status, o.totalCost\n"
            + //
            "FROM orders o  \n" + //
            "JOIN order_detail od ON o.orderID = od.orderID  \n" + //
            "JOIN book b ON od.bookID = b.bookID;\n" + //
            "";

    // get all orders
    public List<Order> getAllOrders() throws SQLException, ClassNotFoundException {
        try{
            Connection connection = new DatabaseUtils().connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_ORDERS);
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                String orderID = resultSet.getString("orderID");
                Date date = resultSet.getDate("date");
                Long customerID = resultSet.getLong("customerID");
                Long employeeID = resultSet.getLong("employeeID");
                Double totalCost = resultSet.getDouble("totalCost");
                Double discount = resultSet.getDouble("discount");
                String status = resultSet.getString("status");
                Order order = new Order(orderID, date, customerID, employeeID, totalCost, discount, status);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            System.out.println("Error getting all orders: " + e.getMessage());
            return null;
        }
        
    }

}
