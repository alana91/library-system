package com.library.library.service.converter;

import com.library.library.DTO.ItemDTO;
import com.library.library.DTO.LoanDTO;
import com.library.library.model.Loan;
import com.library.library.service.CollectionService;
import com.library.library.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class LoanToDTO {

    private static LoanToDTO instance = null;
    private UserService userService = UserService.getInstance();
    private CollectionService collectionService = CollectionService.getInstance();

    private LoanToDTO(){}

    public static LoanToDTO getInstance() {
        if(instance == null) {
            instance = new LoanToDTO();
        }
        return instance;
    }

    public LoanDTO convert(Loan loan){

        LoanDTO loanDTO = new LoanDTO();
        loanDTO.setBorrower(userService.getUser(loan.getBorrowerId()));
        loanDTO.setClerk(userService.getUser(loan.getClerkId()));
        loanDTO.setIsReturned(loan.getReturned());
        loanDTO.setDueDate(loan.getDueDate());
        loanDTO.setId(loan.getId());
        loanDTO.setLoanDate(loan.getLoanDate());
        List<ItemDTO> items = loan.getItemIds()
                .stream()
                .map(id -> collectionService.getItem(id))
                .collect(Collectors.toList());
        loanDTO.setItemDTOS(items);

        return loanDTO;
    }
}
