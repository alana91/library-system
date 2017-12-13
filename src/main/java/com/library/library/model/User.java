package com.library.library.model;

public class User {
    private String id;
    private String name;
    private Boolean hasDebt;
    private String accessLevel; //client, clerk, manager

    public User(){}

    public User(String name, Boolean hasDebt, String accessLevel, String id) {
        this.name = name;
        this.hasDebt = hasDebt;
        this.accessLevel = accessLevel;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getHasDebt() {
        return hasDebt;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setId(String id) {
        if(id!=null){
            this.id = id;
        }
    }

    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
    }

    public void setHasDebt(Boolean hasDebt) {
        if(hasDebt != null) {
            this.hasDebt = hasDebt;
        }
    }

    public void setAccessLevel(String accessLevel) {
        if(accessLevel != null) {
            this.accessLevel = accessLevel;
        }
    }

}
