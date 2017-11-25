package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Periodical {
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

    public Periodical(){}
    public Periodical(Date date, String title, String author, String area, String country, String publisher,
                      Integer edition, Boolean borrowed, String id, List<String> loansIds) {
        this.publisher = publisher;
        this.edition = edition;
        this.date = date;
        this.title = title;
        this.author = author;
        this.area = area;
        this.country = country;
        this.isBorrowed = borrowed;
        this.id = id;
        this.loansIds = loansIds;
    }
}
