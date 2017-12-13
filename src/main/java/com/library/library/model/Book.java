package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Book extends Item {
    private String ISBN;
    private List<PersonOrCompany> publisher;
    private Integer edition;

    public Book(){}

    public Book(Date date, String title, List<PersonOrCompany> authors, String area, String country, String ISBN,
                List<PersonOrCompany> publisher, Integer edition, Boolean borrowed, String id) {
        super(date, title, authors, area, country, borrowed, id);
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.edition = edition;
    }

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
        if(ISBN != null) {
            this.ISBN = ISBN;
        }
    }

    public void setPublisher(List<PersonOrCompany> publisher) {
        if(publisher != null) {
            this.publisher = publisher;
        }
    }

    public void setEdition(Integer edition) {
        if(edition != null) {
            this.edition = edition;
        }
    }
}
