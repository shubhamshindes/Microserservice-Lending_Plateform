package com.asypay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asypay.loanservice.entity.Loan;
import com.asypay.repository.LoanRepository;

@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
	private final LoanRepository loanRepo;
    
    

    public LoanController(LoanRepository loanRepo) {
        this.loanRepo = loanRepo;
    }

    // Fetch all loans for a user
    @GetMapping("/user/{userId}")
    public List<Loan> getLoansByUser(@PathVariable Long userId) {
        return loanRepo.findByUserId(userId);
    }

    // Add a new loan
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        if (loan == null || loan.getAmount() == null || loan.getUserId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Loan savedLoan = loanRepo.save(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLoan);
    }
}

