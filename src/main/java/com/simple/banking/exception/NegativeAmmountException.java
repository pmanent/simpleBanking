/**
 * 
 */
package com.simple.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author peremanent
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegativeAmmountException extends SimpleBankingException {

	/**
	 * Constructor of the Exception.
	 */
	public NegativeAmmountException() {
		super("The ammount must be Negative");
	}

}
