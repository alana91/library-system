package com.library.library.model;

import java.math.BigInteger;
import java.security.SecureRandom;

public class User {
    private String id;
    private String name;
    private Boolean hasDebt;
    private String accessLevel; //client, clerk, manager

    public User(){}

    public User(String name, Boolean hasDebt, String accessLevel) {
        this.name = name;
        this.hasDebt = hasDebt;
        this.accessLevel = accessLevel;
        setId();
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

    public void setId() {
        SecureRandom random = new SecureRandom();
        this.id = new BigInteger(130, random).toString(32);
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
