package com.library.library.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Loan {
    private static long id = 0;
    private User borrower;
    private User clerk;
    private LocalDateTime loanDate;
    private LocalDate dueDate;
    private List<Item> items;

    public Loan(User borrower, User clerk, LocalDateTime loanDate, LocalDate dueDate, List<Item> items) {
        this.borrower = borrower;
        this.clerk = clerk;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.items = items;
        id++;
    }

    public static long getId() {
        return id;
    }

    public User getBorrower() {
        return borrower;
    }

    public User getClerk() {
        return clerk;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public List<Item> getItems() {
        return items;
    }
}
