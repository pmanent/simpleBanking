package com.simple.banking.service.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simple.banking.exception.SimpleBankingException;
import com.simple.banking.service.rules.BankingRule;

/**
 * Abstract class for the command.
 * The purpouse of this class, is to encapsulate generic methods for the commands, 
 * such as Validation Rules.
 * @author peremanent
 *
 */
public abstract class BankingCommandImpl implements BankingCommand {

	/**
	 * Logger for the actual Class.
	 */
	private static final Logger logger = LoggerFactory.getLogger(BankingCommandImpl.class);
	/**
	 * Rules that validates the actual command can be executed.
	 * If the list is empty, does not really matters. The method has to executed normally.
	 */
	private List<BankingRule> rules = new ArrayList<BankingRule>();
	
	/**
	 * Method used to add as many rules needed to validate the process.
	 * @param rule
	 */
	public void addRule(BankingRule rule) {
		logger.debug("addRule rule "+rule);
		rules.add(rule);
	}
	
	/**
	 * Method that validates all the rules.
	 * 
	 * @throws SimpleBankingException
	 */
	public void validate() throws SimpleBankingException{
		logger.debug("Starting the Command Validation Process ");
		rules.stream().forEach((rule)->{
			logger.debug("Validating rule "+rule);
			rule.validate();
		});
	}

}
