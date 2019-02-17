package com.simple.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MandatoryException extends SimpleBankingException{

	public MandatoryException(String parameter) {
		super("The parameter "+parameter+" is mandatory");
	}

}
