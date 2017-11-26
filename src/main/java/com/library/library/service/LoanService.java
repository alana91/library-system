package com.library.library.service;

import com.library.library.DAO.Loan_ItemDAOImpl;
import com.library.library.DTO.LoanDTO;
import com.library.library.DAO.LoanDAOImpl;
import com.library.library.DTO.ItemDTO;
import com.library.library.model.Loan;
import com.library.library.model.Loan_Item;
import com.library.library.model.User;
import com.library.library.service.converter.DTOToLoan;
import com.library.library.service.converter.LoanToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("LoanService")

public class LoanService {

    @Autowired
    private LoanDAOImpl loanDAO;
    
    @Autowired
    private Loan_ItemDAOImpl loanItemDAO;

    private UserService userService = UserService.getInstance();
    private CollectionService collectionService = CollectionService.getInstance();
    private LoanToDTO loanToDTO = LoanToDTO.getInstance();
    private DTOToLoan dtoToLoan = DTOToLoan.getInstance();

    public List<LoanDTO> getAll(){
        return loanDAO.getAll().stream()
               .map(loanToDTO::convert)
               .collect(Collectors.toList());
    }

    public LoanDTO getLoan(String id){
        return loanToDTO.convert(loanDAO.getLoan(id));
    }

    public LoanDTO addLoan(LoanDTO loanDTO){
        User user = userService.getUser(loanDTO.getBorrower().getId());
        Boolean hasDebt = user.getHasDebt();
        if(hasDebt){
            return null;
        }

        loanDTO.setBorrower(userService.getUser(loanDTO.getBorrower().getId()));

        String accessLevel = userService.getUser(loanDTO.getClerk().getId()).getAccessLevel();
        if(!accessLevel.equals("clerk")){
            return null;
        }

        loanDTO.setClerk(userService.getUser(loanDTO.getClerk().getId()));

        if(!checkAvailability(loanDTO.getItemDTOS())){
            return null;
        }

        for(ItemDTO itemDTO : loanDTO.getItemDTOS()){
            itemDTO.setIsBorrowed(true);
            collectionService.updateItem(itemDTO, itemDTO.getId());
            loanItemDAO.addRelation(new Loan_Item(loanDTO.getLoanDate().getTime(), itemDTO.getId(), loanDTO.getId()));
        }

        loanDTO.setIsReturned(false);

        Loan loan = dtoToLoan.convert(loanDTO);
        return loanToDTO.convert(loanDAO.addLoan(loan));
    }

    public LoanDTO updateLoan(LoanDTO loanDTO, String id){

        Loan loan = dtoToLoan.convert(getLoan(id));

        if(isDue(loanDTO)){
            loanDTO.getBorrower().setHasDebt(true);
            userService.updateUser(loanDTO.getBorrower(), loanDTO.getBorrower().getId());
        }
        if(loanDTO.getIsReturned()){
            for(ItemDTO itemDTO : getLoan(loanDTO.getId()).getItemDTOS()) {
                itemDTO.setIsBorrowed(false);
                collectionService.updateItem(itemDTO, itemDTO.getId());
            }
        }

        loan.setDueDate(loanDTO.getDueDate());
        loan.setReturned(loanDTO.getIsReturned());

        return loanToDTO.convert(loanDAO.updateLoan(loan, id));
    }

    private Boolean isDue(LoanDTO loanDTO) {
        Date today = new Date();
        long diff = today.getTime() - getLoan(loanDTO.getId()).getDueDate().getTime();
        return diff >= 86400000;
    }

    private Boolean checkAvailability(List<ItemDTO> loanItemDTOS){
        for(ItemDTO itemDTO : loanItemDTOS) {
            if(collectionService.getItem(itemDTO.getId()).getIsBorrowed()){
                return false;
            }
        }
        return  true;
    }

}
