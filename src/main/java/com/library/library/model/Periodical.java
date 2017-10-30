package com.library.library.model;

import sun.util.calendar.BaseCalendar;

import java.util.List;

public class Periodical extends Item{
    private String publisher;
    private String edition;

    public Periodical(BaseCalendar.Date date, String title, List authors, Area area, Subject subject, String country,
                      String state, String city, String publisher, String edition) {
        super(date, title, authors, area, subject, country, state, city);
        this.publisher = publisher;
        this.edition = edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getEdition() {
        return edition;
    }
}
