package com.asypay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asypay.loanservice.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
}
