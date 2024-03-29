package store.Model;
import java.util.Date;
public class Book {
    private Long bookID; // Assuming bookID is a numeric identifier
    private String title;
    private Long authorID; // Assuming author is referenced by ID
    private Long publisherID; // Assuming publisher is referenced by ID
    private Double price;
    private Long categoryID; // Assuming category is referenced by ID
    private Boolean status;
    private Long volume; // Assuming volume is a numeric field
    // date 
    private Date date;

    public Book(Long bookID, String title, Long authorID, Long publisherID, Double price, Long categoryID,
            Boolean status, Long volume, Date date) {
        this.bookID = bookID;
        this.title = title;
        this.authorID = authorID;
        this.publisherID = publisherID;
        this.price = price;
        this.categoryID = categoryID;
        this.status = status;
        this.volume = volume;
    }

    // Getters
    public Long getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public Long getPublisherID() {
        return publisherID;
    }

    public Double getPrice() {
        return price;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public Boolean getStatus() {
        return status;
    }

    public Long getVolume() {
        return volume;
    }

    public Date getDate() {
        return date;
    }
    // Setters
    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public void setPublisherID(Long publisherID) {
        this.publisherID = publisherID;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
