package com.library.library.model;

import java.util.List;

public class Subject {
    private String name;
    private Area area;
    private List<Item> items;

    public Subject(String name, Area area, List items) {
        this.name = name;
        this.area = area;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public Area getArea() {
        return area;
    }

    public List<Item> getItems() {
        return items;
    }
}
