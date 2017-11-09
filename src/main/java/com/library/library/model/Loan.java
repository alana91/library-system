package com.library.library.model;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

public class Loan {
    private String id;
    private User borrower;
    private User clerk;
    private Date loanDate;
    private Date dueDate;
    private Boolean returned;
    private List<Item> items;

    public Loan(){}

    public Loan(User borrower, User clerk, Date loanDate, Date dueDate, List<Item> items) {
        this.borrower = borrower;
        this.clerk = clerk;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.items = items;
        setId();
        this.returned = null;
    }

    public String getId() {
        return id;
    }

    public User getBorrower() {
        return borrower;
    }

    public User getClerk() {
        return clerk;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setId() {
        SecureRandom random = new SecureRandom();
        this.id = new BigInteger(130, random).toString(32);
    }

    public void setBorrower(User borrower) {
        if(borrower != null) {
            this.borrower = borrower;
        }
    }

    public void setClerk(User clerk) {
        if(clerk != null) {
            this.clerk = clerk;
        }
    }

    public void setLoanDate(Date loanDate) {
        if(loanDate != null) {
            this.loanDate = loanDate;
        }
    }

    public void setDueDate(Date dueDate) {
        if(dueDate != null) {
            this.dueDate = dueDate;
        }
    }

    public void setItems(List<Item> items) {
        if(items != null) {
            this.items = items;
        }
    }

    public void setReturned(Boolean returned) {
        if(returned != null) {
            this.returned = returned;
        }
    }
}
