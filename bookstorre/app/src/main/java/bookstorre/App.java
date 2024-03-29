
package bookstorre;

import javax.swing.*;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Statement;

import bookstorre.Service.BookService;
import bookstorre.utils.DatabaseUtils;
import view.auth.*;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String args[]) throws SQLException {
        BookService bookService = new BookService();

        // try {
        // // Gọi phương thức getAllBooks và lưu kết quả vào một List
        // List<bookstorre.Model.Book> allBooks = bookService.getAllBooks();

        // // Kiểm tra xem danh sách có rỗng không và in thông tin của mỗi cuốn sách
        // if (allBooks != null && !allBooks.isEmpty()) {
        // for (bookstorre.Model.Book book : allBooks) {
        // System.out.println("Book ID: " + book.getBookID());
        // System.out.println("Title: " + book.getTitle());
        // // In thêm thông tin khác của sách tùy thuộc vào thuộc tính có sẵn
        // }
        // } else {
        // System.out.println("Không có sách nào trong danh sách.");
        // }
        // } catch (ClassNotFoundException e) {
        // System.out.println("Không tìm thấy driver cơ sở dữ liệu: " + e.getMessage());
    }

}
