package com.library.library.model;

import java.time.LocalDate;
import java.util.List;

public class Periodical extends Item{
    private String publisher;
    private String edition;

    public Periodical(LocalDate date, String title, List authors, Area area, Subject subject, String country,
                      String state, String city, String publisher, String edition) {
        super(date, title, authors, area, subject, country, state, city);
        this.publisher = publisher;
        this.edition = edition;
    }

    public String getPublisher() {
        return publisher;
    }

}
