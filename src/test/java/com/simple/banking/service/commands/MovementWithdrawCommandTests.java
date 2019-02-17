/**
 * 
 */
package com.simple.banking.service.commands;

import org.junit.Assert;
import org.junit.Test;

import com.simple.banking.entities.Movement;
import com.simple.banking.exception.MandatoryException;
import com.simple.banking.exception.NegativeAmmountException;

/**
 * @author peremanent
 *
 */
public class MovementWithdrawCommandTests {

	
	/**
	 * Actual constructor of the Tests.
	 */
	public MovementWithdrawCommandTests() {
	}
	@Test
	public void generateMovementWithdrawTest() {
		String ammount = "-250";
		BankingCommand command = new MovementWithdrawCommand("username",ammount);
		Movement movement = (Movement)command.execute();
		Assert.assertNotNull("The movement should not be null",movement);
		Assert.assertEquals("The description should be Withdraw","Withdraw",movement.getDescription() );
		Assert.assertEquals("The Total should be 250",Long.valueOf(ammount),movement.getTotal());
	}
	
	@Test
	public void generateMovementWithdrawWithPositiveAmmountTest() {
		String ammount = "250";
		NegativeAmmountException actualException = null;
		BankingCommand command = new MovementWithdrawCommand("username",ammount);
		try {
			command.execute();
		} catch (NegativeAmmountException e) {
			actualException = e;
		}
		Assert.assertNotNull("The actualException should Not be null",actualException);
	}
	
	@Test
	public void generateMovementWithdrawWithZeroAmmountTest() {
		String ammount = "0";
		NegativeAmmountException actualException = null;
		BankingCommand command = new MovementWithdrawCommand("username",ammount);
		try {
			command.execute();
		} catch (NegativeAmmountException e) {
			actualException = e;
		}
		Assert.assertNotNull("The actualException should Not be null",actualException);
	}
	
	@Test
	public void generateMovementWithdrawWithoutAmmountTest() {
		String ammount = "";
		MandatoryException actualException = null;
		BankingCommand command = new MovementWithdrawCommand("username",ammount);
		try {
			command.execute();
		} catch (MandatoryException e) {
			actualException = e;
		}
		Assert.assertNotNull("The actualException should Not be null",actualException);
	}
	
	@Test
	public void generateMovementWithdrawWithNullAmmountTest() {
		String ammount = null;
		MandatoryException actualException = null;
		BankingCommand command = new MovementWithdrawCommand("username",ammount);
		try {
			command.execute();
		} catch (MandatoryException e) {
			actualException = e;
		}
		Assert.assertNotNull("The actualException should Not be null",actualException);
	}
	
	@Test
	public void generateMovementWithdrawWithNotNumberAmmountTest() {
		String ammount = "ABC";
		NegativeAmmountException actualException = null;
		BankingCommand command = new MovementWithdrawCommand("username",ammount);
		try {
			command.execute();
		} catch (NegativeAmmountException e) {
			actualException = e;
		}
		Assert.assertNotNull("The actualException should Not be null",actualException);
	}
}
