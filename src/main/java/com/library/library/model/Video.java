package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Video extends Item {
    public Video(){}
    public Video(Date date, String title, List<PersonOrCompany> authors, String area, String country, Boolean borrowed,
                 String id) {
        super(date, title, authors, area, country, borrowed, id);
    }
}
