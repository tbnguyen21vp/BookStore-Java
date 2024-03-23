package bookstorre.Model;

public class Book {
    private String bookID;
    private String Title;
    private String Author;
    private String Publisher;
    private Double Price;
    private String Category;
    private Boolean Status;

    public Book(String bookID, String title, String author, String publisher, Double price, String category,
            Boolean status) {
        this.bookID = bookID;
        Title = title;
        Author = author;
        Publisher = publisher;
        Price = price;
        Category = category;
        Status = status;
    }

    // Getters
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public Double getPrice() {
        return Price;
    }

    public String getCategory() {
        return Category;
    }

    public Boolean getStatus() {
        return Status;
    }

    // Setters
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }
    // add book
    public void addBook() {
        System.out.println("Book added successfully");
    }

    // update book
    public void updateBook() {
        System.out.println("Book updated successfully");
    }
    // disable book
    public void disableBook() {
        System.out.println("Book disabled successfully");
    }

    // enable book
    public void enableBook() {
        System.out.println("Book enabled successfully");
    }
}
