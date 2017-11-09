package com.library.library.dao;

import com.library.library.model.Loan;

import java.util.List;

public class LoanDao {
    private Helper helper = new Helper();
    private List<Loan> loans = helper.createLoanList();

    public List<Loan> getAll(){
        return loans;
    }

    public Loan getLoan(String id){
        Loan selectedLoan = null;
        for(Loan loan : loans){
            if(loan.getId().equals(id)){
                selectedLoan = loan;
                break;
            }
        }
        return selectedLoan;
    }

    public Loan addLoan(Loan loan){
        loans.add(loan);
        return loan;
    }

    public Loan updateLoan(Loan loan, String id){
        Loan selectedLoan = getLoan(id);
        selectedLoan.setBorrower(loan.getBorrower());
        selectedLoan.setClerk(loan.getClerk());
        selectedLoan.setDueDate(loan.getDueDate());
        selectedLoan.setLoanDate(loan.getLoanDate());
        selectedLoan.setItems(loan.getItems());
        return selectedLoan;
    }

    public void removeLoan(String id){
        Loan loan = getLoan(id);
        loans.remove(loan);
    }
}
