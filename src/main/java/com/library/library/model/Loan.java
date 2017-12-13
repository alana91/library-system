package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Loan {
    private String id;
    private User borrower;
    private User clerk;
    private Date loanDate;
    private Date dueDate;
    private Boolean isReturned;
    private List<Item> items;

    public Loan(){}

    public Loan(User borrower, User clerk, Date loanDate, Date dueDate, List<Item> items, Boolean isReturned,
                String id) {
        this.borrower = borrower;
        this.clerk = clerk;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.items = items;
        this.id = id;
        this.isReturned = isReturned;
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

    public Boolean getIsReturned() {
        return isReturned;
    }

    public void setId(String id) {
        if(id != null){
            this.id = id;
        }
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

    public void setIsReturned(Boolean isReturned) {
        if(isReturned != null) {
            this.isReturned = isReturned;
        }
    }
}
