package com.library.library.model;

import sun.util.calendar.BaseCalendar;

import java.util.List;

public abstract class Item {
    private BaseCalendar.Date date;
    private String title;
    private List<PersonOrCompany> authors;
    private Area area;
    private Subject subject;
    private String country;
    private String state;
    private String city;
    private static long id = 0;

    public Item(){}

    public Item(BaseCalendar.Date date, String title, List authors, Area area, Subject subject, String country,
                String state, String city) {
        this.date = date;
        this.title = title;
        this.authors = authors;
        this.area = area;
        this.subject = subject;
        this.country = country;
        this.state = state;
        this.city = city;
        id++;
    }

    public BaseCalendar.Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public List getAuthors() {
        return authors;
    }

    public Area getArea() {
        return area;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public boolean alreadyExists(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!title.equals(item.title)) return false;
        return authors.equals(item.authors);
    }

    public static long getId() {
        return id;
    }
}
