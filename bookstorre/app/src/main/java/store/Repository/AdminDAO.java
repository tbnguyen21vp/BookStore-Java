package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Order;
import store.utils.DatabaseUtils;

public class AdminDAO  {
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE orderID = ?";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String UPDATE_ORDER_SQL = "UPDATE orders SET ... WHERE orderID = ?";
    private static final String DELETE_ORDER_SQL = "DELETE FROM orders WHERE orderID = ?";

}
