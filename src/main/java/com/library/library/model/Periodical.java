// codebeat:disable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if(publisher != null){
            this.publisher = publisher;
        }
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        if(edition != null){
            this.edition = edition;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if(date != null) {
            this.date = date;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title != null){
            this.title = title;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author != null){
            this.author = author;
        }
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if(area != null) {
            this.area = area;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(country != null){
            this.country = country;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id != null){
            this.id = id;
        }
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        if(borrowed != null) {
            isBorrowed = borrowed;
        }
    }

    public List<String> getLoansIds() {
        return loansIds;
    }

    public void setLoansIds(List<String> loansIds) {
        this.loansIds = loansIds;
    }
}

// codebeat:enable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]