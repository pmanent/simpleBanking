package com.simple.banking.service.commands;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.simple.banking.entities.Account;
import com.simple.banking.entities.Movement;
import com.simple.banking.exception.SimpleBankingException;

/**
 * Class responsible to execute the unit test with the mockito Framework for the UpdateAccountCommand.
 * @author peremanent
 */
public class UpdateAccountCommandTests {
	
	private Account account;
	
	private Account accountWithoutMovements;
	
	private Account accountNullMovements;
	
	private Movement movement;
	
	public UpdateAccountCommandTests() {
	}
	
	@Before
    public void setupMock() {
		
		this.account = mock(Account.class);
		this.movement = mock(Movement.class);
		
		List<Movement> movements = new ArrayList<Movement>();
		movements.add(this.movement);
		when(this.movement.getTotal()).thenReturn(500L);
		when(this.account.getMovements()).thenReturn(movements);
		
		this.accountWithoutMovements = mock(Account.class);
		when(this.accountWithoutMovements.getMovements()).thenReturn(new ArrayList<Movement>());
		
		this.accountNullMovements = new Account();
		
		
		
    }
	/**
	 * Succesfull test of the Update Command.
	 */
	@Test
	public void updateAccountCommandOKTest() {
		BankingCommand updateAccount = new UpdateAccountCommand(this.account); 
		Account updatedAccount = (Account)updateAccount.execute();	
		Assert.assertNotNull("The account must exist", updatedAccount);
	}
	
	
	@Test
	public void updateAccountCommandWithoutMovementsTest() {
		BankingCommand updateAccount = new UpdateAccountCommand(this.accountWithoutMovements); 
		Account updatedAccount = (Account)updateAccount.execute();	
		Assert.assertNotNull("The account must exist", updatedAccount);
	}
	/**
	 * 
	 */
	@Test
	public void updateAccountCommandNullMovementsTest() {
		BankingCommand updateAccount = new UpdateAccountCommand(this.accountNullMovements); 
		Account updatedAccount = (Account)updateAccount.execute();	
		Assert.assertNotNull("The account must exist", updatedAccount);
	}
	/**
	 * Fail test. Expect to throw a SimpleBankingException because the account is null.
	 */
	@Test
	public void updateAccountCommandNullAccountTest() {
		BankingCommand updateAccount = new UpdateAccountCommand(null); 
		SimpleBankingException actualException=null;
		try {
			updateAccount.execute();
		} catch (SimpleBankingException e) {
			actualException =e;
		}	
		Assert.assertNotNull("The actualException must exist", actualException);
	}
}

