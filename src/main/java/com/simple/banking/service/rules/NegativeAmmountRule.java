/**
 * 
 */
package com.simple.banking.service.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simple.banking.exception.NegativeAmmountException;
import com.simple.banking.exception.SimpleBankingException;

/**
 * @author peremanent
 *
 */
public class NegativeAmmountRule implements BankingRule {
	/**
	 * Logger for the actual Class.
	 */
	private static final Logger logger = LoggerFactory.getLogger(NegativeAmmountRule.class);
	/**
	 * Actual ammount.
	 */
	private String ammount;
	/**
	 * Constructor with the actual Ammount to validate.
	 */
	public NegativeAmmountRule(String ammount) {
		this.ammount = ammount;
	}

	/* (non-Javadoc)
	 * @see com.simple.banking.service.rules.BankingRule#validate()
	 */
	@Override
	public void validate() throws SimpleBankingException {
		logger.debug("Validation of NegativeAmmountRule with ammount "+ammount);
		if(this.ammount == null ||  "".equals(this.ammount)) {
			throw new NegativeAmmountException();
		} else {
			try {
				Long actualAmmount = Long.valueOf(this.ammount);
				if(actualAmmount >= 0) {
					throw new NegativeAmmountException();
				}
			} catch (NumberFormatException e) {
				throw new NegativeAmmountException();
			}
			
		}
	}

}
