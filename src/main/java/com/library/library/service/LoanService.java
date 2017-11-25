package com.library.library.service;

import com.library.library.DTO.LoanDTO;
import com.library.library.DAO.LoanDao;
import com.library.library.DTO.ItemDTO;
import com.library.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service("LoanService")

public class LoanService {

    @Autowired
    private LoanDao loanDao;

    @Autowired
    private UserService userService;

    @Autowired
    private CollectionService collectionService;

    public List<LoanDTO> getAll(){
        return loanDao.getAll();
    }

    public LoanDTO getLoan(String id){
        return loanDao.getLoan(id);
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

        List<ItemDTO> borrowedItemDTOS = new LinkedList<>();

        for(ItemDTO itemDTO : loanDTO.getItemDTOS()){
            borrowedItemDTOS.add(collectionService.getItem(itemDTO.getId()));
            collectionService.getItem(itemDTO.getId()).setIsBorrowed(true);
        }

        loanDTO.setItemDTOS(borrowedItemDTOS);
        loanDTO.setIsReturned(false);

        return loanDao.addLoan(loanDTO);
    }

    public LoanDTO updateLoan(LoanDTO loanDTO, String id){
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
        return loanDao.updateLoan(loanDTO, id);
    }

    public void removeLoan(String id){
        loanDao.removeLoan(id);
    }

    private Boolean isDue(LoanDTO loanDTO) {
        Date today = new Date();
        long diff = today.getTime() - getLoan(loanDTO.getId()).getDueDate().getTime();
        if (diff >= 86400000) {
            return true;
        }
        return false;
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
