package com.raven.model;

/**
 *
 * @author TCCom
 */
public class Book {
    private String bookID;
    private String bookName;
    private String description;
    private int price;
    private boolean status;

    // Constructor
    public Book(String bookID, String bookName, String title, String description, int price) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.description = description;
        this.price = price;
        this.status = true;
    }

    // Getter methods
    public String getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
    
    public boolean isStatus() {
        return status;
    }

    // Setter methods
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
}

