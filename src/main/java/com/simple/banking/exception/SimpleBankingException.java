package com.simple.banking.exception;

import javax.validation.ValidationException;

/**
 * Parent class for all the exceptions throwed by our framework.
 */
public abstract class SimpleBankingException extends ValidationException {
	
	public SimpleBankingException(String message) {
		super(message);
	}

}
