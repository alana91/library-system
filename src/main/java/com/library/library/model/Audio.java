package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Audio {
    private String recordCompany;
    private Date date;
    private String title;
    private String author;
    private String area;
    private String country;
    private String id;
    private Boolean isBorrowed;
    private List<String> loansIds;

    public Audio(){}

    public Audio(Date date, String title, String author, String area, String country, String recordCompany,
                 Boolean borrowed, String id, List<String> loanIds) {
        this.date = date;
        this.title = title;
        this.author = author;
        this.area = area;
        this.country = country;
        this.isBorrowed = borrowed;
        this.id = id;
        this.recordCompany = recordCompany;
        this.loansIds = loanIds;
    }

}
