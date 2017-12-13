package com.library.library.controller;

import com.library.library.model.Loan;
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
        public List<Loan> getAll(){
            return service.getAll();
        }

        @GetMapping("/loans/{id}")
        public Loan getLoan(@PathVariable String id){
            return service.getLoan(id);
        }

        @PostMapping("/loans")
        public ResponseEntity<Void> addLoan(@RequestBody Loan newLoan){
            Loan loan = service.addLoan(newLoan);
            if(loan == null){
                return ResponseEntity.status(500).build();
            }
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(loan.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }

        @PutMapping("/loans/{id}")
        public ResponseEntity<?> updateLoan(@PathVariable String id, @RequestBody Loan newLoan){
            Loan updatedLoan = service.updateLoan(newLoan, id);
            return new ResponseEntity<Loan>(updatedLoan, HttpStatus.OK);
        }

        @DeleteMapping("/loans/{id}")
        public ResponseEntity<Void> removeLoan(@PathVariable String id){
            service.removeLoan(id);
            return ResponseEntity.noContent().build();
        }
}
