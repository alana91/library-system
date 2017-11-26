package com.library.library.controller;

import com.library.library.DTO.LoanDTO;
import com.library.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

    @RestController
    public class LoanController {

        @Autowired
        private LoanService service;

        @GetMapping("/loans")
        public List<LoanDTO> getAll(){
            return service.getAll();
        }

        @GetMapping("/loans/{id}")
        public LoanDTO getLoan(@PathVariable String id){
            return service.getLoan(id);
        }

        @PostMapping("/loans")
        public ResponseEntity<Void> addLoan(@RequestBody LoanDTO newLoanDTO){
            LoanDTO loanDTO = service.addLoan(newLoanDTO);
            if(loanDTO == null){
                return ResponseEntity.status(500).build();
            }
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(loanDTO.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }

        @PutMapping("/loans/{id}")
        public ResponseEntity<?> updateLoan(@PathVariable String id, @RequestBody LoanDTO newLoanDTO){
            LoanDTO updatedLoanDTO = service.updateLoan(newLoanDTO, id);
            return new ResponseEntity<LoanDTO>(updatedLoanDTO, HttpStatus.OK);
        }
}
