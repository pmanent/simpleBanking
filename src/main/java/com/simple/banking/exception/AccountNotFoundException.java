package com.simple.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends SimpleBankingException {

	public AccountNotFoundException(String user) {
		super("Account not found in the DDBB with the user "+user);
	}
	
}
