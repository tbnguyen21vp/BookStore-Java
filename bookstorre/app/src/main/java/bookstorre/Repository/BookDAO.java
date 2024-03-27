package bookstorre.Repository;

import bookstorre.Model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import bookstorre.utils.DatabaseUtils;

public class BookDAO {
    // Assuming DatabaseUtils is already defined and includes the connect method
    private static final String INSERT_BOOK_SQL = "INSERT INTO books (bookID, title, author, publisher, price, category, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE bookID =?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE bookID = ?";
    private static final String UPDATE_BOOK_SQL = "UPDATE books SET title = ?, author = ?, publisher = ?, price = ?, category = ?, status = ? WHERE bookID = ?";

    public BookDAO() {
    }

    public void insertBook(Book book) throws SQLException {
        try {
            DatabaseUtils databaseUtils = new DatabaseUtils();
            Connection connection = databaseUtils.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL);
            preparedStatement.setString(1, book.getBookID());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getPublisher());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.setString(6, book.getCategory());
            preparedStatement.setBoolean(7, book.getStatus());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Book selectBook(String bookID) {
        Book book = null;
        DatabaseUtils databaseUtils = new DatabaseUtils();
        try (Connection connection = databaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setString(1, bookID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                Double price = rs.getDouble("price");
                String category = rs.getString("category");
                Boolean status = rs.getBoolean("status");
                book = new Book(bookID, title, author, publisher, price, category, status);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String bookID = rs.getString("bookID");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                Double price = rs.getDouble("price");
                String category = rs.getString("category");
                Boolean status = rs.getBoolean("status");
                books.add(new Book(bookID, title, author, publisher, price, category, status));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    public boolean deleteBook(String bookID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_SQL)) {
            statement.setString(1, bookID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowDeleted = false;
        }
        return rowDeleted;
    }

    public boolean updateBook(Book book) throws SQLException {
        boolean rowUpdated;
        DatabaseUtils databaseUtils = new DatabaseUtils();
        try (Connection connection = databaseUtils.connect();
                PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setDouble(4, book.getPrice());
            statement.setString(5, book.getCategory());
            statement.setBoolean(6, book.getStatus());
            statement.setString(7, book.getBookID());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }
}
