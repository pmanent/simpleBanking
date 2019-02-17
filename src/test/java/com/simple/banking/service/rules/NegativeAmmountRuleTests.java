package com.simple.banking.service.rules;

import org.junit.Assert;
import org.junit.Test;

import com.simple.banking.exception.NegativeAmmountException;

public class NegativeAmmountRuleTests {
	
	private static final String AMMOUNT = "-250";
	
	public NegativeAmmountRuleTests() {
	}
	
	@Test
	public void negativeAmmountRuleOKTest() {
		
		NegativeAmmountRule rule = new NegativeAmmountRule(AMMOUNT);
		NegativeAmmountException actualException = null;
		try {
			rule.validate();
		} catch (NegativeAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNull("The excetion must be null",actualException);
	}
	
	@Test
	public void negativeAmmountRuleWithPositiveAmmountTest() {
		
		NegativeAmmountRule rule = new NegativeAmmountRule("250");
		NegativeAmmountException actualException = null;
		try {
			rule.validate();
		} catch (NegativeAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNotNull("The excetion must be NOT null",actualException);
	}
	
	@Test
	public void negativeAmmountRuleWithZeroAmmountTest() {
		
		NegativeAmmountRule rule = new NegativeAmmountRule("0");
		NegativeAmmountException actualException = null;
		try {
			rule.validate();
		} catch (NegativeAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNotNull("The excetion must be NOT null",actualException);
	}
	
	@Test
	public void negativeAmmountRuleWithoutAmmountTest() {
		
		NegativeAmmountRule rule = new NegativeAmmountRule("");
		NegativeAmmountException actualException = null;
		try {
			rule.validate();
		} catch (NegativeAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNotNull("The excetion must be NOT null",actualException);
	}

	@Test
	public void negativeAmmountRuleWithNullAmmountTest() {
		
		NegativeAmmountRule rule = new NegativeAmmountRule(null);
		NegativeAmmountException actualException = null;
		try {
			rule.validate();
		} catch (NegativeAmmountException e) {
			actualException = e;
		}
		
		Assert.assertNotNull("The excetion must be NOT null",actualException);
	}

}
