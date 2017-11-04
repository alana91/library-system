package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Book extends Item {
    private String ISBN;
    private List<PersonOrCompany> publisher;
    private Integer edition;

    public Book(Date date, String title, List<PersonOrCompany> authors, String area, String country, String ISBN,
                List<PersonOrCompany> publisher, Integer edition) {
        super(date, title, authors, area, country);
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.edition = edition;
    }

    public Book(){}

    public String getISBN() {
        return ISBN;
    }

    public List<PersonOrCompany> getPublisher() {
        return publisher;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublisher(List<PersonOrCompany> publisher) {
        this.publisher = publisher;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }
}
