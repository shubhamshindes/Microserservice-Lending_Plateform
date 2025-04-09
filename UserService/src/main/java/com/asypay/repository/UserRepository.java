package com.asypay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asypay.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
