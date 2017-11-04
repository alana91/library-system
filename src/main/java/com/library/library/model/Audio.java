package com.library.library.model;

import java.util.Date;
import java.util.List;


public class Audio extends Item {
    private List<PersonOrCompany> recordCompanies;

    public Audio(Date date, String title, List<PersonOrCompany> authors, String area, String country,
                 List<PersonOrCompany> recordCompanies) {
        super(date, title, authors, area, country);
        this.recordCompanies = recordCompanies;
    }

    public List<PersonOrCompany> getRecordCompanies() {
        return recordCompanies;
    }
}