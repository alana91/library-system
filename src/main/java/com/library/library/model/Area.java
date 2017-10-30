package com.library.library.model;

import java.util.List;

public class Area {
    private String name;
    private List<Item> items;
    private List<Subject> subjects;

    public Area(String name, List<Item> items, List<Subject> subjects) {
        this.name = name;
        this.items = items;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
