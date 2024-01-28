package app.model;

public class book {
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private String year;
    private String price;
    private String description;
    private String category;
    private String image;

    public book(String title, String author, String isbn, String publisher, String year, String price, String description, String category, String image) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public book() {
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getYear() {
        return year;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }
}
