package com.library.library.model;

import sun.util.calendar.BaseCalendar;

import java.util.List;

public class Audio extends Item {
    private List<PersonOrCompany> recordCompanies;

    public Audio(BaseCalendar.Date date, String title, List authors, Area area, Subject subject, String country,
                 String state, String city, List recordCompanies) {
        super(date, title, authors, area, subject, country, state, city);
        this.recordCompanies = recordCompanies;
    }

    public List getRecordCompanies() {
        return recordCompanies;
    }
}
