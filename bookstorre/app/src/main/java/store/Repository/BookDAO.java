package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Book;
import store.utils.DatabaseUtils;

public class BookDAO {
    // Assuming DatabaseUtils is already defined and includes the connect method
    private static final String INSERT_BOOK_SQL = "INSERT INTO books (bookID, title, author, publisher, price, category, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE bookID =?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM `book`";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE bookID = ?";
    private static final String UPDATE_BOOK_SQL = "UPDATE books SET title = ?, author = ?, publisher = ?, price = ?, category = ?, status = ? WHERE bookID = ?";

    //add book
    public void insertBook(Book book) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setLong(1, book.getBookID());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setLong(3, book.getAuthorID());
            preparedStatement.setLong(4, book.getPublisherID());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.setLong(6, book.getCategoryID());
            preparedStatement.setBoolean(7, book.getStatus());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // update book
    public boolean updateBook(Book book) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setLong(2, book.getAuthorID());
            preparedStatement.setLong(3, book.getPublisherID());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setLong(5, book.getCategoryID());
            preparedStatement.setBoolean(6, book.getStatus());
            preparedStatement.setLong(7, book.getBookID());
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

    // delete book

    public boolean deleteBook(long bookID) throws SQLException {
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL)) {
            preparedStatement.setLong(1, bookID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    // get all books

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                long bookID = rs.getLong("bookID");
                String title = rs.getString("title");
                long authorID = rs.getLong("author");
                long publisherID = rs.getLong("publisher");
                double price = rs.getDouble("price");
                long categoryID = rs.getLong("category");
                boolean status = rs.getBoolean("status");
                Book book = new Book(categoryID, title, categoryID, categoryID, price, categoryID, status, categoryID, null);
                book.setBookID(bookID);
                book.setTitle(title);
                book.setAuthorID(authorID);
                book.setPublisherID(publisherID);
                book.setPrice(price);
                book.setCategoryID(categoryID);
                book.setStatus(status);
                books.add(book);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }
   
    // get book by id
    public Book selectBook(long bookID) throws SQLException {
        Book book = null;
        try (Connection connection = new DatabaseUtils().connect();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setLong(1, bookID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                long authorID = rs.getLong("author");
                long publisherID = rs.getLong("publisher");
                double price = rs.getDouble("price");
                long categoryID = rs.getLong("category");
                boolean status = rs.getBoolean("status");
                book = new Book(categoryID, title, categoryID, categoryID, price, categoryID, status, categoryID, null);
                book.setBookID(bookID);
                book.setTitle(title);
                book.setAuthorID(authorID);
                book.setPublisherID(publisherID);
                book.setPrice(price);
                book.setCategoryID(categoryID);
                book.setStatus(status);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return book;
    }




}
