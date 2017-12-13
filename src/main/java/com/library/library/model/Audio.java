package com.library.library.model;

import java.util.Date;
import java.util.List;


public class Audio extends Item {
    private List<PersonOrCompany> recordCompanies;

    public Audio(){}
    public Audio(Date date, String title, List<PersonOrCompany> authors, String area, String country,
                 List<PersonOrCompany> recordCompanies, Boolean borrowed, String id) {
        super(date, title, authors, area, country, borrowed, id);
        this.recordCompanies = recordCompanies;
    }

    public List<PersonOrCompany> getRecordCompanies() {
        return recordCompanies;
    }

    public void setRecordCompanies(List<PersonOrCompany> recordCompanies) {
        if(recordCompanies != null) {
            this.recordCompanies = recordCompanies;
        }
    }
}
