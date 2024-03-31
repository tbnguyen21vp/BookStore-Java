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

    // Existing BookDAO methods
    // ...

    // New methods for Author, Category, and Publisher
    public List<Author> getAllAuthors() throws SQLException {
        return authorDAO.selectAllAuthors();
    }

    public Author getAuthorById(int authorId) throws SQLException {
        return authorDAO.selectAuthor(authorId);
    }

    public List<Category> getAllCategories() throws SQLException, ClassNotFoundException {
        return categoryDAO.getAllCategories();
    }

    public Category getCategoryById(int categoryId) throws SQLException, ClassNotFoundException {
        // Assuming CategoryDAO has a method to select by ID similar to selectAuthor in
        // AuthorDAO
        // return categoryDAO.selectCategoryById(categoryId);
        return null; // Placeholder implementation
    }

    public List<Publisher> getAllPublishers() throws SQLException {
        return publisherDAO.getAllPublishers();
    }

    public Publisher getPublisherById(int publisherId) throws SQLException {
        return publisherDAO.selectPublisher(publisherId);
    }

    // Methods to add/update/delete authors, categories, publishers can be added
    // similarly
}
