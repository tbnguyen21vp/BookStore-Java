package bookstorre.Repository;

import bookstorre.Model.Book;
import bookstorre.utils.DatabaseUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE bookID = ?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String UPDATE_BOOK_SQL = "UPDATE books SET ... WHERE bookID = ?";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE bookID = ?";

    public class Book {
        // Existing code...

        public Book(ResultSet rs) {
            // Initialize the book object using the ResultSet data
        }

        // Existing code...
    }

    private DatabaseUtils databaseUtils;

    public List<Book> getAllBooks() throws SQLException, ClassNotFoundException {
        List<Book> books = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils(); // Create an instance of DatabaseUtils
        try (Connection connection = databaseUtils.connect(); // Call connect() on the instance
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                // Assuming Book class has a constructor that takes ResultSet or its data
                books.add(new Book(rs));
            }
        }
        return books;
    }

    public void updateBook(Book book) throws SQLException, ClassNotFoundException {
        DatabaseUtils databaseUtils = new DatabaseUtils(); // Create an instance of DatabaseUtils
        try (Connection connection = databaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            // Set parameters from book object
            // preparedStatement.set...
            preparedStatement.executeUpdate();
        }
    }

    public boolean deleteBook(String bookID) throws SQLException, ClassNotFoundException {
        DatabaseUtils databaseUtils = new DatabaseUtils(); // Create an instance of DatabaseUtils
        try (Connection connection = databaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL)) {
            preparedStatement.setString(1, bookID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

}