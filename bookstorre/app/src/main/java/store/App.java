
package store;

import javax.swing.*;
import java.awt.*;
import java.awt.print.Book;

import view.auth.*;

import store.Repository.BookDAO;
import store.Service.BookService;
import store.utils.DatabaseUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
// import order DAO
import store.Repository.OrderDAO;
public class App {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        OrderDAO oder = new OrderDAO();
        try{
            List<store.Model.Order> orders = oder.getAllOrders();
            for (store.Model.Order order : orders) {
                System.out.println(order);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all orders: " + e.getMessage());
        }

    }

}
