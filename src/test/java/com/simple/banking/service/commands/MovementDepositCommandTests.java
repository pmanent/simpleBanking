package com.simple.banking.service.commands;

import org.junit.Assert;
import org.junit.Test;

import com.simple.banking.entities.Movement;
import com.simple.banking.exception.MandatoryException;
import com.simple.banking.exception.SimpleBankingException;

/**
 *  Test class of the MovementDepositCommand.java.
 * @author peremanent
 *
 */
public class MovementDepositCommandTests {
	
	@Test
	public void generateMovementTest() {
		String ammount = "250";
		MovementDepositCommand command = new MovementDepositCommand("username",ammount);
		Movement movement = (Movement)command.execute();
		Assert.assertNotNull("The movement should not be null",movement);
		Assert.assertEquals("The description should be Deposit","Deposit",movement.getDescription() );
		Assert.assertEquals("The Total should be 250",Long.valueOf(ammount),movement.getTotal());
	}
	
	@Test
	public void generateMovementWithoutAmountTest() {
		String ammount = "";
		SimpleBankingException actualException=null;
		try {
			MovementDepositCommand command = new MovementDepositCommand("username",ammount);
			command.execute();
		} catch (SimpleBankingException e) {
			actualException = e;
		}
		Assert.assertNotNull("The exception should not be null",actualException);
		Assert.assertTrue("The exception must an instance of MandatoryException",actualException instanceof MandatoryException);
	}
	
	@Test
	public void generateMovementWithNullAmountTest() {
		String ammount = null;
		SimpleBankingException actualException=null;
		try {
			MovementDepositCommand command = new MovementDepositCommand("username",ammount);
			command.execute();
		} catch (SimpleBankingException e) {
			actualException = e;
		}
		Assert.assertNotNull("The exception should not be null",actualException);
		Assert.assertTrue("The exception must an instance of MandatoryException",actualException instanceof MandatoryException);
	}
	
	@Test
	public void generateMovementWithoutUsernameTest() {
		String ammount = "250";
		String username = "";
		SimpleBankingException actualException=null;
		try {
			MovementDepositCommand command = new MovementDepositCommand(username,ammount);
			command.execute();
		} catch (SimpleBankingException e) {
			actualException = e;
		}
		Assert.assertNotNull("The exception should not be null",actualException);
		Assert.assertTrue("The exception must an instance of MandatoryException",actualException instanceof MandatoryException);
	}
	
	@Test
	public void generateMovementWithNullUsernameTest() {
		String ammount = "250";
		String username = null;
		SimpleBankingException actualException=null;
		try {
			MovementDepositCommand command = new MovementDepositCommand(username,ammount);
			command.execute();
		} catch (SimpleBankingException e) {
			actualException = e;
		}
		Assert.assertNotNull("The exception should not be null",actualException);
		Assert.assertTrue("The exception must an instance of MandatoryException",actualException instanceof MandatoryException);
	}

}
