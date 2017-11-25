package com.library.library.model;

public class Loan_Item {
    private String itemId;
    private String loanId;

    public Loan_Item(){}

    public Loan_Item(String itemId, String loanId) {
        this.itemId = itemId;
        this.loanId = loanId;
    }
}
