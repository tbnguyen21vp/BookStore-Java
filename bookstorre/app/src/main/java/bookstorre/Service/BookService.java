package bookstorre.Service;

import bookstorre.Repository.BookDAO;
import bookstorre.Model.Book;
import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService() {
        this.bookDAO = new BookDAO();
    }

    // Adds a new book to the database
    public boolean addBook(Book book) {
        try {
            bookDAO.insertBook(book);
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
            return false;
        }
    }

    // Retrieves a book by its ID
    public Book getBook(String bookID) {
        return bookDAO.selectBook(bookID);
    }

    // Retrieves all books from the database
    public List<Book> getAllBooks() {
        return bookDAO.selectAllBooks();
    }

    // Updates an existing book's details
    public boolean updateBook(Book book) {
        try {
            return bookDAO.updateBook(book);
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
            return false;
        }
    }

    // Deletes a book from the database
    public boolean deleteBook(String bookID) {
        try {
            return bookDAO.deleteBook(bookID);
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
            return false;
        }
    }
}
