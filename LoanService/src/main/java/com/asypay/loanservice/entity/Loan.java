package com.asypay.loanservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Says this class maps to a database table
@Getter @Setter // Automatically adds getter/setter methods (Lombok)
@AllArgsConstructor @NoArgsConstructor // Adds constructors
public class Loan {
    @Id // Marks the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID
    private Long id;

    private Long userId; // ID of the user who took the loan
    private Double amount; // Amount of loan
    
    @Enumerated(EnumType.STRING)
    private LoanStatus status; // Status like "PENDING", "APPROVED", etc.
    
    
    
}

