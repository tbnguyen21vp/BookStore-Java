package com.groupseven.model;

import com.groupseven.swing.table.Action;
import com.groupseven.swing.table.EventAction;
import java.text.DecimalFormat;

public class Book {
    private int bookID; // Assuming bookID is a numeric identifier
    private String title;
    private String author; // Assuming author is referenced by ID
    private String publisher;
    private Double price;
    private String category; // Assuming category is referenced by ID
    private Boolean status;
    private int volume; // Assuming volume is a numeric field

    public Book(int bookID, String title, String author,
            String publisher,
            Double price, String category, Boolean status, int volume) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
        this.status = status;
        this.volume = volume;
    }
    
    public Book( String title, String author,
            String publisher,
            Double price, String category, Boolean status, int volume) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
        this.status = status;
        this.volume = volume;
    }

    // Getters
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getStatus() {
        return status;
    }

    public int getVolume() {
        return volume;
    }

    // Setters
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    public Object[] toRowTable(EventAction event){
        DecimalFormat df = new DecimalFormat("$#, ##0.00");
        return new Object[]{bookID, title, author, publisher, df.format(price), category, status, volume, new Action(this, event)};
    }
}
