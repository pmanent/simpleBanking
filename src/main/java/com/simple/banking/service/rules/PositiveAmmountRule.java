/**
 * 
 */
package com.simple.banking.service.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simple.banking.exception.PositiveAmmountException;
import com.simple.banking.exception.SimpleBankingException;

/**
 * @author peremanent
 *
 */
public class PositiveAmmountRule implements BankingRule {
	/**
	 * Logger for the actual Class.
	 */
	private static final Logger logger = LoggerFactory.getLogger(PositiveAmmountRule.class);
	/**
	 * Actual ammount.
	 */
	private String ammount;
	/**
	 * Constructor with the actual Ammount to validate.
	 */
	public PositiveAmmountRule(String ammount) {
		this.ammount = ammount;
	}

	/* (non-Javadoc)
	 * @see com.simple.banking.service.rules.BankingRule#validate()
	 * TODO Refactor this method to ohter rules.
	 */
	@Override
	public void validate() throws SimpleBankingException {
		logger.debug("Validation of PositiveAmmountRule with ammount "+ammount);
		if(this.ammount == null ||  "".equals(this.ammount)) {
			throw new PositiveAmmountException();
		} else {
			try {
				Long actualAmmount = Long.valueOf(this.ammount);
				if(actualAmmount <= 0) {
					throw new PositiveAmmountException();
				}
			} catch (NumberFormatException e) {
				throw new PositiveAmmountException();
			}
			
		}
	}

}
