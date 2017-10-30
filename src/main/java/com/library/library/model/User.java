package com.library.library.model;

import java.util.List;

public class User {
    private static int id = 0;
    private String name;
    private Boolean hasDebt;
    private String accessLevel; //client, clerk, manager
    private List<Loan> loans;

    public User(String name, Boolean hasDebt, String accessLevel, List<Loan> loans) {
        this.name = name;
        this.hasDebt = hasDebt;
        this.accessLevel = accessLevel;
        this.loans = loans;
        id++;
    }

    public static int getId() {
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

    public List<Loan> getLoans() {
        return loans;
    }
}
