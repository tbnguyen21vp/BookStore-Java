package store.Service;

import java.sql.SQLException;
import java.util.List;

import store.Model.Book;
import store.Repository.BookDAO;

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

    // get all books
    public List<Book> getAllBooks() throws ClassNotFoundException {
        try {
            return bookDAO.getAllBooks();
        } catch (SQLException e) {
            System.out.println("Error getting all books: " + e.getMessage());
            return null;
        }
    }
}
