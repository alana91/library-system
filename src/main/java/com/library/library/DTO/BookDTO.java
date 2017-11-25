package com.library.library.DTO;

import java.util.Date;
import java.util.List;

public class BookDTO implements ItemDTO {
    private String ISBN;
    private String publisher;
    private Integer edition;
    private Date date;
    private String title;
    private String  author;
    private String area;
    private String country;
    private String id;
    private Boolean isBorrowed;

    public BookDTO(){}

    public BookDTO(Date date, String title, String author, String area, String country, String ISBN,
                   String publisher, Integer edition, Boolean borrowed, String id) {
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
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
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

    public void setPublisher(String publisher) {
        if(publisher != null) {
            this.publisher = publisher;
        }
    }

    public void setEdition(Integer edition) {
        if(edition != null) {
            this.edition = edition;
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
