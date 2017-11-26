package com.library.library.DAO;

import com.library.library.model.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoanDAOImpl implements LoanDAO {
    private Helper helper = Helper.getInstance();
    private List<Loan> loans = helper.createLoanList();

    @Override
    public List<Loan> getAll(){
        return loans;
    }

    @Override
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

    @Override
    public Loan addLoan(Loan loan){
        loans.add(loan);
        return loan;
    }

    @Override
    public Loan updateLoan(Loan loan, String id){
        Loan selectedLoan = getLoan(id);
        selectedLoan.setDueDate(loan.getDueDate());
        selectedLoan.setReturned(loan.getReturned());
        return selectedLoan;
    }
}
