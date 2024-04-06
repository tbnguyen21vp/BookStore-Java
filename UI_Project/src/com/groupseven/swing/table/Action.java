package com.groupseven.swing.table;

import com.groupseven.model.Book;

public class Action {
    private Book book;
    private EventAction event;

    public void setBook(Book book) {
        this.book = book;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public Book getBook() {
        return book;
    }

    public EventAction getEvent() {
        return event;
    }
    
    public Action(){
        
    }
    
    public Action(Book book, EventAction event) {
        this.book = book;
        this.event = event;
    }
}
