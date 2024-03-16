package bookstore.Entity;

// import list
import java.util.List;
public class ListBook {
    private List<Book> ListBook;

    public ListBook(List<Book> Books) {
        this.ListBook = Books;
    }

    public List<Book> getBooks() {
        return ListBook;
    }
    //add book to list
    public void addBook(Book book) {
        ListBook.add(book);
    }
    //remove book from list
    public void removeBook(Book book) {
        ListBook.remove(book);
    }
    //get book by id
    public Book getBookByID(String bookID) {
        for (Book book : ListBook) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }
    //get book by title
    public Book getBookByTitle(String title) {
        for (Book book : ListBook) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
