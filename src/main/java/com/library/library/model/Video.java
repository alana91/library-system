package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Video {
    private Date date;
    private String title;
    private String author;
    private String area;
    private String country;
    private String id;
    private Boolean isBorrowed;
    private List<String> loansIds;

    public Video(){}
    public Video(Date date, String title, String author, String area, String country, Boolean borrowed, String id,
                 List<String> loansIds) {
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
