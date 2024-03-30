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
        private static final String GET_ORDER_DETAIL_BY_ID = "SELECT od.id_order_detail, od.orderID, b.bookID, od.quantity, b.title, b.price "
                +
                "FROM order_detail od " +
                "JOIN book b ON od.bookID = b.bookID WHERE od.orderID = ?;";

        // get all orders
        public List<Order> getAllOrders() throws SQLException, ClassNotFoundException {
            try {
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

        // get order detail by id
        public List<OrderDetail> getOrderDetailByID(int orderID_Input) throws SQLException, ClassNotFoundException {
            List<OrderDetail> orderDetails = new ArrayList<>();
            try (Connection connection = new DatabaseUtils().connect();
                    PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_DETAIL_BY_ID)) {
                preparedStatement.setInt(1, orderID_Input);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Long idOrderDetail = resultSet.getLong("id_order_detail");
                        Long bookID = resultSet.getLong("bookID");
                        int orderID = resultSet.getInt("orderID"); // Đảm bảo này phù hợp với kiểu dữ liệu
                        Long quantity = resultSet.getLong("quantity");
                        String title = resultSet.getString("title");
                        Double price = resultSet.getDouble("price");

                        OrderDetail orderDetail = new OrderDetail(idOrderDetail, bookID, orderID, quantity, title,
                                price);
                        orderDetails.add(orderDetail);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error getting order detail by id: " + e.getMessage());
                return null;
            }
            return orderDetails;
        }
        // create order
        public boolean createOrder(Order order) throws SQLException, ClassNotFoundException {
            String sql = "INSERT INTO orders (orderID, date, customerID, employeeID, discount, status, totalCost) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (Connection connection = new DatabaseUtils().connect();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, order.getOrderID());
                preparedStatement.setDate(2, order.getDate());
                preparedStatement.setLong(3, order.getCustomerID());
                preparedStatement.setLong(4, order.getEmployeeID());
                preparedStatement.setDouble(5, order.getDiscount());
                preparedStatement.setString(6, order.getStatus());
                preparedStatement.setDouble(7, order.getTotalCost());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                System.out.println("Error creating order: " + e.getMessage());
                return false;
            }
        }
    
    }
