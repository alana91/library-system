package com.library.library.DAO;

import com.library.library.model.Loan_Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Loan_ItemDAOImpl implements Loan_ItemDAO {

    private Helper helper = Helper.getInstance();
    private List<Loan_Item> loans_itens = helper.createLoan_ItemList();

    @Override
    public void addRelation(Loan_Item loan_item){
        loans_itens.add(loan_item);
    }
}
