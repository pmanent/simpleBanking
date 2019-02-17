package com.simple.banking.service.rules;

import org.junit.Assert;
import org.junit.Test;

import com.simple.banking.exception.PositiveAmmountException;

public class PositiveAmmountRuleTests {

	public PositiveAmmountRuleTests() {
		
	}
	@Test
	public void positiveAmmountRuleOKTest() {
		String ammount="250";
		PositiveAmmountRule rule = new PositiveAmmountRule(ammount);
		PositiveAmmountException actualException = null;
		try {
			rule.validate();
		} catch (PositiveAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNull("The excetion must be null",actualException);
		
	}
	@Test
	public void positiveAmmountRuleWithNegativeNumberTest() {
		String ammount="-250";
		PositiveAmmountRule rule = new PositiveAmmountRule(ammount);
		PositiveAmmountException actualException = null;
		try {
			rule.validate();
		} catch (PositiveAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNotNull("The excetion must NOT be null",actualException);
		
	}
	
	@Test
	public void positiveAmmountRuleWithNoNumberTest() {
		String ammount="Character";
		PositiveAmmountRule rule = new PositiveAmmountRule(ammount);
		PositiveAmmountException actualException = null;
		try {
			rule.validate();
		} catch (PositiveAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNotNull("The excetion must NOT be null",actualException);
		
	}
	
	@Test
	public void positiveAmmountRuleWithoutAmmountTest() {
		String ammount="";
		PositiveAmmountRule rule = new PositiveAmmountRule(ammount);
		PositiveAmmountException actualException = null;
		try {
			rule.validate();
		} catch (PositiveAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNotNull("The excetion must NOT be null",actualException);
		
	}
	
	@Test
	public void positiveAmmountRuleWithNullAmmountTest() {
		String ammount = null;
		PositiveAmmountRule rule = new PositiveAmmountRule(ammount);
		PositiveAmmountException actualException = null;
		try {
			rule.validate();
		} catch (PositiveAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNotNull("The excetion must NOT be null",actualException);
		
	}
}
