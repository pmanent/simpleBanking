package com.simple.banking.service.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simple.banking.exception.MandatoryException;
import com.simple.banking.exception.SimpleBankingException;

public class MandatoryRule implements BankingRule{
	/**
	 * Logger for the actual Class.
	 */
	private static final Logger logger = LoggerFactory.getLogger(MandatoryRule.class);
	/**
	 * paramanName.
	 */
	private String paramanName;
	
	/**
	 * paramValue.
	 */
	private Object paramValue;
	
	public MandatoryRule(String paramanName, Object paramValue) {
		this.paramanName = paramanName;
		this.paramValue = paramValue;
	}

	@Override
	public void validate() throws SimpleBankingException {
		logger.debug("Validation of NegativeAmmountRule with paramValue "+this.paramValue+" and value "+this.paramValue);
		if(this.paramValue == null || "".equals(this.paramValue.toString())) {
			throw new MandatoryException(this.paramanName);
		}
	}

}
