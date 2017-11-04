package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Periodical extends Item{
    private List<PersonOrCompany> publisher;
    private Integer edition;

    public Periodical(Date date, String title, List<PersonOrCompany> authors, String area, String country,
                      List<PersonOrCompany> publisher, Integer edition) {
        super(date, title, authors, area, country);
        this.publisher = publisher;
        this.edition = edition;
    }

    public List<PersonOrCompany> getPublisher() {
        return publisher;
    }

}
