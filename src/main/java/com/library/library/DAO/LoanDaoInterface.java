package com.library.library.DAO;

import com.library.library.DTO.LoanDTO;

import java.util.List;

public interface LoanDaoInterface {

    public List<LoanDTO> getAll();

    public LoanDTO getLoan(String id);

    public LoanDTO addLoan(LoanDTO loanDTO);

    public LoanDTO updateLoan(LoanDTO loanDTO, String id);

    public void removeLoan(String id);
}
