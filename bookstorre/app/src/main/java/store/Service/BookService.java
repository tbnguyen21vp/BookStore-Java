package store.Service;

import java.sql.SQLException;
import java.util.List;
import store.Model.Author;
import store.Model.Book;
import store.Model.Category;
import store.Model.Publisher;
import store.Repository.AuthorDAO;
import store.Repository.BookDAO;
import store.Repository.CategoryDAO;
import store.Repository.PublisherDAO;

public class BookService {
    private BookDAO bookDAO;
    private AuthorDAO authorDAO;
    private CategoryDAO categoryDAO;
    private PublisherDAO publisherDAO;

    public BookService() {
        this.bookDAO = new BookDAO();
        this.authorDAO = new AuthorDAO();
        this.categoryDAO = new CategoryDAO();
        this.publisherDAO = new PublisherDAO();
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookDAO.getAllBooks();
    }
    // delete book
    public void deleteBook(int bookID) throws SQLException {
        bookDAO.deleteBook(bookID);
    }
    //insert Book
    public void insertBook(Book book) throws SQLException {
        bookDAO.insertBook(book);
    }
}
