package com.library.library.model;

import sun.util.calendar.BaseCalendar;

import java.util.List;

public class Book extends Item {
    private String ISBN;
    private String publisher;
    private String edition;

    public Book(BaseCalendar.Date date, String title, List authors, Area area, Subject subject, String country,
                String state, String city, String ISBN, String publisher, String edition) {
        super(date, title, authors, area, subject, country, state, city);
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.edition = edition;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getEdition() {
        return edition;
    }
}
