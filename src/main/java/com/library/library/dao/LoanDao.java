package com.library.library.DAO;

import com.library.library.DTO.LoanDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoanDao implements LoanDaoInterface{
    private Helper helper = Helper.getInstance();
    private List<LoanDTO> loanDTOS = helper.createLoanList();

    @Override
    public List<LoanDTO> getAll(){
        return loanDTOS;
    }

    @Override
    public LoanDTO getLoan(String id){
        LoanDTO selectedLoanDTO = null;
        for(LoanDTO loanDTO : loanDTOS){
            if(loanDTO.getId().equals(id)){
                selectedLoanDTO = loanDTO;
                break;
            }
        }
        return selectedLoanDTO;
    }

    @Override
    public LoanDTO addLoan(LoanDTO loanDTO){
        loanDTOS.add(loanDTO);
        return loanDTO;
    }

    @Override
    public LoanDTO updateLoan(LoanDTO loanDTO, String id){
        LoanDTO selectedLoanDTO = getLoan(id);
        selectedLoanDTO.setDueDate(loanDTO.getDueDate());
        selectedLoanDTO.setIsReturned(loanDTO.getIsReturned());
        return selectedLoanDTO;
    }

    @Override
    public void removeLoan(String id){
        LoanDTO loanDTO = getLoan(id);
        loanDTOS.remove(loanDTO);
    }

}
