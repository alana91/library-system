package com.library.library.model;

import java.util.List;

public class Subject {
    private String name;
    private Area area;
    private static List<Item> items;

    public Subject(String name, Area area) {
        this.name = name;
        this.area = area;
    }
}
