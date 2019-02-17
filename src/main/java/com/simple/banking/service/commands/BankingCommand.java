/**
 * 
 */
package com.simple.banking.service.commands;

import com.simple.banking.exception.SimpleBankingException;

/**
 * Interface of the Command Pattern
 * @author peremanent
 *
 */
public interface BankingCommand {
	/**
	 * Main method to executed a command.
	 * @return
	 * @throws SimpleBankingException
	 */
	public Object execute() throws SimpleBankingException;

}
