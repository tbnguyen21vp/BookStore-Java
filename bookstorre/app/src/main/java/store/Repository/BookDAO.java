package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Book;
import store.utils.DatabaseUtils;

public class BookDAO {
    // Assuming DatabaseUtils is already defined and includes the connect method
    private static final String INSERT_BOOK_SQL = "INSERT INTO books ( title, author, publisher, price, category, status, volume) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM book WHERE bookID =?";
    private static final String SELECT_ALL_BOOKS = "SELECT book.bookID, book.title, author.name AS authorName, publisher.name AS publisherName, book.price, category.name AS categoryName, book.status , book.volume\n" + //
            "FROM book\n" + //
            "JOIN author ON book.authorID = author.authorID\n" + //
            "JOIN publisher ON book.publisherID = publisher.publisherID\n" + //
            "JOIN category ON book.categoryID = category.categoryID;\n" + //
            ""; //

    private static final String DELETE_BOOK_SQL = "DELETE FROM book WHERE bookID = ?";
    private static final String UPDATE_BOOK_SQL = "UPDATE book SET title = ?, author = ?, publisher = ?, price = ?, category = ?, status = ?, volume = ? WHERE bookID = ?";

    // add book
    public void insertBook(Book book) throws SQLException {
        try (@SuppressWarnings("static-access")
        Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPublisher());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setString(5, book.getCategory());
            preparedStatement.setBoolean(6, book.getStatus());
            preparedStatement.setInt(7, book.getVolume());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // delete book
    public boolean deleteBook(int bookID) throws SQLException {
        try (@SuppressWarnings("static-access")
        Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL)) {
            preparedStatement.setInt(1, bookID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // update book
    public boolean updateBook(Book book) throws SQLException {
        try (@SuppressWarnings("static-access")
        Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPublisher());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setString(5, book.getCategory());
            preparedStatement.setBoolean(6, book.getStatus());
            preparedStatement.setLong(7, book.getBookID());
            preparedStatement.setLong(8, book.getVolume());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // disable book
    public boolean disableBook(long bookID) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            preparedStatement.setBoolean(6, false);
            preparedStatement.setLong(7, bookID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // enable book
    public boolean enableBook(long bookID) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            preparedStatement.setBoolean(6, true);
            preparedStatement.setLong(7, bookID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // get book by id
    public Book selectBook(int bookID) throws SQLException {
        Book book = null;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setLong(1, bookID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                boolean status = rs.getBoolean("status");
                int volume = rs.getInt("volume");
                book = new Book(bookID, title, author, publisher, price, category, status, volume);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return book;
    }

    // get all books
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int bookID = rs.getInt("bookID");
                String title = rs.getString("title");
                String author = rs.getString("authorName"); // Đọc trường tên tác giả dưới dạng chuỗi
                String publisher = rs.getString("publisherName"); // Đọc trường tên nhà xuất bản dưới dạng chuỗi
                double price = rs.getDouble("price");
                String category = rs.getString("categoryName");
                boolean status = rs.getBoolean("status");
                int volume = rs.getInt("volume");

                // Create a new Book object and set its properties
                Book book = new Book(bookID, title, author, publisher, price, category, status, volume);

                // Add the book object to the list of books
                books.add(book);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

}
