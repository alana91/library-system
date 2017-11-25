package com.library.library.DTO;

import java.util.Date;

public class AudioDTO implements ItemDTO{
    private String recordCompany;
    private Date date;
    private String title;
    private String author;
    private String area;
    private String country;
    private String id;
    private Boolean isBorrowed;

    public AudioDTO(){}

    public AudioDTO(Date date, String title, String author, String area, String country,
                    String recordCompany, Boolean borrowed, String id) {
        this.date = date;
        this.title = title;
        this.author = author;
        this.area = area;
        this.country = country;
        this.isBorrowed = borrowed;
        this.id = id;
        this.recordCompany = recordCompany;
    }

    public String getRecordCompanies() {
        return recordCompany;
    }

    public void setRecordCompanies(String recordCompany) {
        if(recordCompany != null) {
            this.recordCompany = recordCompany;
        }
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getArea() {
        return area;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Boolean getIsBorrowed() {
        return isBorrowed;
    }

    @Override
    public void setDate(Date date) {
        if(date != null) {
            this.date = date;
        }
    }

    @Override
    public void setTitle(String title) {
        if(title != null) {
            this.title = title;
        }
    }

    @Override
    public void setAuthor(String author) {
        if(author != null) {
            this.author = author;
        }
    }

    @Override
    public void setArea(String area) {
        if (area != null){
            this.area = area;
        }
    }

    @Override
    public void setCountry(String country) {
        if(country != null) {
            this.country = country;
        }
    }

    @Override
    public void setIsBorrowed(Boolean borrowed) {
        if(borrowed != null) {
            this.isBorrowed = borrowed;
        }
    }

    @Override
    public void setId(String id) {
        if(id != null) {
            this.id = id;
        }
    }
}
