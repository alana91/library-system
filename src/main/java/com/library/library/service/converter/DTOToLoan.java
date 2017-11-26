package com.library.library.service.converter;

import com.library.library.DTO.ItemDTO;
import com.library.library.DTO.LoanDTO;
import com.library.library.model.Loan;

import java.util.List;
import java.util.stream.Collectors;

public class DTOToLoan {
    private static DTOToLoan instance = null;

    private DTOToLoan(){}

    public static DTOToLoan getInstance() {
        if(instance == null) {
            instance = new DTOToLoan();
        }
        return instance;
    }

    public Loan convert(LoanDTO loanDTO){

        Loan loan = new Loan();

        loan.setDueDate(loanDTO.getDueDate());
        loan.setReturned(loanDTO.getIsReturned());
        loan.setBorrowerId(loanDTO.getBorrower().getId());
        loan.setClerkId(loanDTO.getBorrower().getId());
        loan.setId(loanDTO.getId());
        loan.setLoanDate(loanDTO.getLoanDate());
        List<String> itemIds = loanDTO.getItemDTOS()
                .stream()
                .map(ItemDTO::getId)
                .collect(Collectors.toList());
        loan.setItemIds(itemIds);

        return loan;
    }
}
