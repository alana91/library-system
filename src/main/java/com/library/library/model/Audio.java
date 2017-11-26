// codebeat:disable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]

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

    public String getRecordCompany() {
        return recordCompany;
    }

    public void setRecordCompany(String recordCompany) {
        if(recordCompany != null) {
            this.recordCompany = recordCompany;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date != null){
            this.date = date;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title != null) {
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
        if(country != null) {
            this.country = country;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id != null) {
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