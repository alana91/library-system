// codebeat:disable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]

package com.library.library.model;

import java.util.Date;
import java.util.List;

public class Loan {
    private String id;
    private String borrowerId;
    private String clerkId;
    private Date loanDate;
    private Date dueDate;
    private Boolean isReturned;
    private List<String> itemIds;

    public Loan(){}

    public Loan(String borrowerId, String clerkId, Date loanDate, Date dueDate, List<String> itemIds, Boolean isReturned,
                   String id) {
        this.borrowerId = borrowerId;
        this.clerkId = clerkId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.itemIds = itemIds;
        this.id = id;
        this.isReturned = isReturned;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getReturned() {
        return isReturned;
    }

    public void setReturned(Boolean returned) {
        isReturned = returned;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }
}

// codebeat:enable[TOO_MANY_IVARS, ABC, TOTAL_COMPLEXITY]
