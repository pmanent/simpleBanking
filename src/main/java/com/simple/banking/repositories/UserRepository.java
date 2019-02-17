package com.simple.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.banking.entities.Users;


public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}
