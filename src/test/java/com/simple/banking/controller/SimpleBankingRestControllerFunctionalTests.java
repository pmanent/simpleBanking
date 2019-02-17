package com.simple.banking.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.simple.banking.entities.Account;
import com.simple.banking.entities.Movement;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SimpleBankingRestControllerFunctionalTests {
	private static final String USERNAME = "pmanent";
	private static final String AMMOUNT = "250";
	
	@Autowired
	private SimpleBankingRestController simpleBankingRestController;

	public void beforeLoad() {
		this.simpleBankingRestController = new SimpleBankingRestController();
	}
	
	public SimpleBankingRestControllerFunctionalTests() {
	}
	
	@Test
	public void loadAccountStatementTest() {
		Account actualAccount = this.simpleBankingRestController.loadAccountStatement(USERNAME);
		Assert.assertNotNull("Account is not loaded.",actualAccount);
	}
	
	@Test
	public void addDepositTest() {
		
		Map<String,String> allRequestParams = new HashMap<String,String>();
		allRequestParams.put("username", USERNAME);
		allRequestParams.put("ammount", AMMOUNT);
		
		Movement depositMovement = this.simpleBankingRestController.deposit(allRequestParams);
		Assert.assertNotNull("Deposit is not loaded.",depositMovement);
	}
	
	@Test
	public void addWithdrawTest() {
		
		Map<String,String> allRequestParams = new HashMap<String,String>();
		allRequestParams.put("username", USERNAME);
		allRequestParams.put("ammount", "-"+AMMOUNT);
		
		Movement withdrawMovement = this.simpleBankingRestController.withdraw(allRequestParams);
		Assert.assertNotNull("withdrawMovement is not loaded.",withdrawMovement);
	}

}
