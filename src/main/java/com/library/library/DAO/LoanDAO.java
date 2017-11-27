package com.library.library.DAO;

import com.library.library.model.Loan;

import java.util.List;

public interface LoanDAO {
    List<Loan> getAll();

    Loan getLoan(String id);

    Loan addLoan(Loan loan);

    Loan updateLoan(Loan loan, String id);
}
