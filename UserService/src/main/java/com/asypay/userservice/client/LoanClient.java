package com.asypay.userservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.asypay.userservice.DTO.LoanDTO;

@FeignClient(name = "loanservice") // Must match spring.application.name
public interface LoanClient {
    @GetMapping("/loans/user/{userId}")
    List<LoanDTO> getLoansByUserId(@PathVariable Long userId);
}
