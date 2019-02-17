/**
 * 
 */
package com.simple.banking.service.commands;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simple.banking.entities.Account;
import com.simple.banking.entities.Movement;
import com.simple.banking.exception.AccountNotFoundException;
import com.simple.banking.exception.SimpleBankingException;

/**
 * This command will update the account in the class parameter.
 * At the end of the process, the account ammount is setted to the new value.
 * @author peremanent
 *
 */
public class UpdateAccountCommand  extends BankingCommandImpl {
	
	/**
	 * Logger for the actual Class.
	 */
	private static final Logger logger = LoggerFactory.getLogger(UpdateAccountCommand.class);
	/**
	 * The account that has to be updated
	 */
	private Account actualAccount;
	/**
	 * Actual Account to update the current ammount.
	 */
	public UpdateAccountCommand(Account actualAccount) {
		this.actualAccount = actualAccount;
	}

	/* (non-Javadoc)
	 * @see com.simple.banking.command.BankingCommand#execute()
	 */
	@Override
	public Object execute() throws SimpleBankingException {
		logger.debug("UpdateAccountCommand : Start to execute the command.");
		if (actualAccount == null) {
			logger.debug("UpdateAccountCommand : The account is not found. An exception has to be thrown");
            throw new AccountNotFoundException("");
        }
    	List<Movement> movements = actualAccount.getMovements();
    	Long ammount = 0L;
    	if(movements != null && movements.size()>0) {
    		logger.debug("UpdateAccountCommand : Iteration of all the movements of the account to update the ammount");
    		for(Movement actualMovement: movements) {
    			logger.debug("UpdateAccountCommand : Movement Total : "+actualMovement.getTotal());
    			Long actualMovementTotal = actualMovement.getTotal();
    			ammount = ammount +actualMovementTotal;
    			logger.debug("UpdateAccountCommand : Current calculated ammount : "+ammount);
    		}
    		
    	} else {
    		logger.debug("UpdateAccountCommand :The account has no movements");
    		ammount = actualAccount.getAmmount();
    	}
    	//Save the account
    	actualAccount.setAmmount(ammount);
		return actualAccount;
	}

}
