package com.asypay.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.asypay.entity.User;
import com.asypay.repository.UserRepository;
import com.asypay.userservice.DTO.LoanDTO;
import com.asypay.userservice.DTO.UserWithLoans;
import com.asypay.userservice.client.LoanClient;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepo;
    private final LoanClient loanClient;

    public UserController(UserRepository userRepo, LoanClient loanClient) {
        this.userRepo = userRepo;
        this.loanClient = loanClient;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepo.findAll();
        return ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (user == null || user.getName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user data");
        }
        User savedUser = userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserWithLoans> getUserWithLoans(@PathVariable Long id) {
        User user = userRepo.findById(id).orElseThrow();
        List<LoanDTO> loans = loanClient.getLoansByUserId(id);
        return ResponseEntity.ok(new UserWithLoans(user, loans));
    }
}

