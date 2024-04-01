
package store;

import javax.swing.*;
import java.awt.*;
import java.awt.print.Book;

import store.Model.OrderDetail;
import store.Repository.BookDAO;
import store.Service.BookService;
import store.utils.DatabaseUtils;
import store.view.auth.*;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
// import order DAO
import store.Repository.OrderDAO;
public class App {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        OrderDAO oder = new OrderDAO();
          try {
            // Thay đổi giá trị 1 bằng ID đơn hàng cụ thể mà bạn muốn lấy chi tiết
            int orderID = 1;
            List<OrderDetail> orderDetails = oder.getOrderDetailByID(orderID);
            
            // Kiểm tra nếu orderDetails không phải là null
            if (orderDetails != null) {
                for (OrderDetail detail : orderDetails) {
                    System.out.println(detail);
                }
            } else {
                System.out.println("Không tìm thấy chi tiết đơn hàng cho ID: " + orderID);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Lỗi khi lấy thông tin chi tiết đơn hàng: " + e.getMessage());
        }

    }

}
