package bookstore.Entity;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private String publisher;
    private Double price;

    private Boolean status;

    public Book( String bookID, String title, String author, String publisher, Double price, Boolean status) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
    // update book

    public void updateBook(String title, String author, String publisher, Double price, Boolean status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.status = status;
    }
    // disable book
    public void disableBook() {
        this.status = false;
    }
    // enable book
    public void enableBook() {
        this.status = true;
    }

}
