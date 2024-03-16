package bookstore.Repository;

public class BookDAO {

    private String bookID;
    private String title;
    private String authorID;
    private String categoryID;
    private String publisherID;
    private String publishYear;
    private String language;
    private String status;

    public BookDAO(String bookID, String title, String authorID, String categoryID, String publisherID, String publishYear, String language, String status) {
        this.bookID = bookID;
        this.title = title;
        this.authorID = authorID;
        this.categoryID = categoryID;
        this.publisherID = publisherID;
        this.publishYear = publishYear;
        this.language = language;
        this.status = status;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getCategoryID() {
        return categoryID;
    }
}
