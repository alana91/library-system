package com.library.library.model;

import java.time.LocalDate;
import java.util.List;

public class Video extends Item {
    private List<PersonOrCompany> directors;
    private List<PersonOrCompany> producers;
    private List<PersonOrCompany> scriptwriters;

    public Video(LocalDate date, String title, List authors, Area area, Subject subject, String country,
                 String state, String city, List<PersonOrCompany> directors, List<PersonOrCompany> producers,
                 List<PersonOrCompany> scriptwriters) {
        super(date, title, authors, area, subject, country, state, city);
        this.directors = directors;
        this.producers = producers;
        this.scriptwriters = scriptwriters;
    }

    public List<PersonOrCompany> getDirectors() {
        return directors;
    }

    public List<PersonOrCompany> getProducers() {
        return producers;
    }

    public List<PersonOrCompany> getScriptwriters() {
        return scriptwriters;
    }
}
