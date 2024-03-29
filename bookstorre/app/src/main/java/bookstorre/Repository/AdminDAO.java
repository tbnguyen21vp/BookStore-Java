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

}
