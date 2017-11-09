package com.library.library.service;

import com.library.library.dao.LoanDao;
import com.library.library.model.Item;
import com.library.library.model.Loan;
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
        loan.setId();
        loan.setBorrower(userService.getUser(loan.getBorrower().getId()));
        loan.setClerk(userService.getUser(loan.getClerk().getId()));
        List<Item> borrowedItems = new LinkedList<>();
        for(Item item : loan.getItems()){
            borrowedItems.add(collectionService.getItem(item.getId()));
        }
        loan.setItems(borrowedItems);
        return loanDao.addLoan(loan);
    }

    public Loan updateLoan(Loan loan, String id){
        loan.setBorrower(userService.getUser(loan.getBorrower().getId()));
        loan.setClerk(userService.getUser(loan.getClerk().getId()));
        List<Item> borrowedItems = new LinkedList<>();
        for(Item item : loan.getItems()){
            borrowedItems.add(collectionService.getItem(item.getId()));
        }
        loan.setItems(borrowedItems);
        if(isDue(loan)){
            userService
                    .getUser(loan.getBorrower().getId())
                    .setHasDebt(true);
        }
        return loanDao.updateLoan(loan, id);
    }

    public void removeLoan(String id){
        loanDao.removeLoan(id);
    }

    public Boolean isDue(Loan loan){
        Date today = new Date();
        long diff = today.getTime() - loan.getDueDate().getTime();
        if(diff >= 86400000){
            return true;
        }
        return false;
    }
}
