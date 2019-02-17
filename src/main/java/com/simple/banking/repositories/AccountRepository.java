package com.simple.banking.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simple.banking.entities.Account;


public interface AccountRepository extends CrudRepository<Account,Long>{
	public Account findByUsername(String username);
	
}
