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
}
