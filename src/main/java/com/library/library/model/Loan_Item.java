package com.library.library.model;

public class Loan_Item {
    private Long id;
    private String itemId;
    private String loanId;

    public Loan_Item(){}

    public Loan_Item(Long id, String itemId, String loanId) {
        this.id = id;
        this.itemId = itemId;
        this.loanId = loanId;
    }
}
