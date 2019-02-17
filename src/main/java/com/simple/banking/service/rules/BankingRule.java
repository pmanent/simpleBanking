/**
 * 
 */
package com.simple.banking.service.rules;

import com.simple.banking.exception.SimpleBankingException;

/**
 * Interface that Rule Pattern to validate objects
 * @author peremanent
 *
 */
public interface BankingRule {
	/**
	 * Method used to validate the rules.
	 * @throws SimpleBankingException
	 */
	public void validate()throws SimpleBankingException;
}
