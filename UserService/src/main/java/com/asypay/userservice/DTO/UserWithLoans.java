package com.asypay.userservice.DTO;

import java.util.List;

import com.asypay.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWithLoans {
    private User user;
    private List<LoanDTO> loans;

    public UserWithLoans(User user, List<LoanDTO> loans) {
        this.user = user;
        this.loans = loans;
    }

    // Getters and setters (or use Lombok)
}
