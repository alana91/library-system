package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Video extends Item {
    public Video(Date date, String title, List<PersonOrCompany> authors, String area, String country) {
        super(date, title, authors, area, country);
    }
}
