package com.library.library.model;

import java.util.List;

public class PersonOrCompany {
    private String name;
    private List<Item> items;

    public PersonOrCompany(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }
}
