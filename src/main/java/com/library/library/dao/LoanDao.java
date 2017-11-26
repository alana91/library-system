package com.library.library.DAO;

import com.library.library.model.Loan;

import java.util.List;

public interface LoanDAO {

    public List<Loan> getAll();

    public Loan getLoan(String id);

    public Loan addLoan(Loan loan);

    public Loan updateLoan(Loan loan, String id);
}
