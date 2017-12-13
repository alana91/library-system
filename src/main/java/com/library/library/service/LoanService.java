package com.library.library.service;

import com.library.library.dao.LoanDao;
import com.library.library.model.Item;
import com.library.library.model.Loan;
import com.library.library.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service("LoanService")

public class LoanService {
    LoanDao loanDao = new LoanDao();
    UserService userService = new UserService();
    CollectionService collectionService = new CollectionService();

    public List<Loan> getAll(){
        return loanDao.getAll();
    }

    public Loan getLoan(String id){
        return loanDao.getLoan(id);
    }

    public Loan addLoan(Loan loan){
        User user = userService.getUser(loan.getBorrower().getId());
        Boolean hasDebt = user.getHasDebt();
        if(hasDebt){
            return null;
        }

        loan.setBorrower(userService.getUser(loan.getBorrower().getId()));

        String accessLevel = userService.getUser(loan.getClerk().getId()).getAccessLevel();
        if(!accessLevel.equals("clerk")){
            return null;
        }

        loan.setClerk(userService.getUser(loan.getClerk().getId()));

        if(!checkAvailability(loan.getItems())){
            return null;
        }

        List<Item> borrowedItems = new LinkedList<>();

        for(Item item : loan.getItems()){
            borrowedItems.add(collectionService.getItem(item.getId()));
            collectionService.getItem(item.getId()).setIsBorrowed(true);
        }

        loan.setItems(borrowedItems);
        loan.setIsReturned(false);

        return loanDao.addLoan(loan);
    }

    public Loan updateLoan(Loan loan, String id){
        if(isDue(loan)){
            loan.getBorrower().setHasDebt(true);
            userService.updateUser(loan.getBorrower(), loan.getBorrower().getId());
        }
        if(loan.getIsReturned()){
            for(Item item : getLoan(loan.getId()).getItems()) {
                item.setIsBorrowed(false);
                collectionService.updateItem(item, item.getId());
            }
        }
        return loanDao.updateLoan(loan, id);
    }

    public void removeLoan(String id){
        loanDao.removeLoan(id);
    }

    private Boolean isDue(Loan loan) {
        Date today = new Date();
        long diff = today.getTime() - getLoan(loan.getId()).getDueDate().getTime();
        if (diff >= 86400000) {
            return true;
        }
        return false;
    }

    private Boolean checkAvailability(List<Item> loanItems){
        for(Item item : loanItems) {
            if(collectionService.getItem(item.getId()).getIsBorrowed()){
                return false;
            }
        }
        return  true;
    }

}
