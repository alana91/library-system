package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Book {
    private String ISBN;
    private String publisher;
    private Integer edition;
    private Date date;
    private String title;
    private String author;
    private String area;
    private String country;
    private String id;
    private Boolean isBorrowed;
    private List<String> loansIds;

    public Book(){}

    public Book(Date date, String title, String author, String area, String country, String ISBN,
                   String publisher, Integer edition, Boolean borrowed, String id, List<String> loansIds) {
        this.date = date;
        this.title = title;
        this.author = author;
        this.area = area;
        this.country = country;
        this.isBorrowed = borrowed;
        this.id = id;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.edition = edition;
        this.loansIds = loansIds;
    }
}
