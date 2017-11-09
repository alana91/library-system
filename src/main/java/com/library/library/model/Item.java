package com.library.library.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.security.SecureRandom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Audio.class, name = "Audio"),
        @JsonSubTypes.Type(value = Book.class, name = "Book"),
        @JsonSubTypes.Type(value = Periodical.class, name = "Periodical"),
        @JsonSubTypes.Type(value = Video.class, name = "Video")})

public abstract class Item {
    private Date date;
    private String title;
    private List<PersonOrCompany> authors;
    private String area;
    private String country;
    private String id;

    public Item(){}

    public Item(Date date, String title, List<PersonOrCompany> authors, String area, String country) {
        this.date = date;
        this.title = title;
        this.authors = authors;
        this.area = area;
        this.country = country;
        setId();
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public List<PersonOrCompany> getAuthors() {
        return authors;
    }

    public String getArea() {
        return area;
    }

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }

    public void setDate(Date date) {
        if(date != null) {
            this.date = date;
        }
    }

    public void setTitle(String title) {
        if(title != null) {
            this.title = title;
        }
    }

    public void setAuthors(List<PersonOrCompany> authors) {
        if(authors != null) {
            this.authors = authors;
        }
    }

    public void setArea(String area) {
        if (area != null){
            this.area = area;
        }
    }

    public void setCountry(String country) {
        if(country != null) {
            this.country = country;
        }
    }

    public void setId() {
        SecureRandom random = new SecureRandom();
        this.id = new BigInteger(130, random).toString(32);
    }
}
