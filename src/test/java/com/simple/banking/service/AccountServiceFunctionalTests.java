package com.simple.banking.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.simple.banking.entities.Account;
import com.simple.banking.exception.AccountNotFoundException;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountServiceFunctionalTests {

	private static final String USERNAME = "admin";
	
	@Autowired
	private AccountServiceImpl accountService;
	
	public AccountServiceFunctionalTests() {
	}
	
	@Test
	public void loadAccountByUsername() {
		Account account = this.accountService.loadAccountByUsername(USERNAME);
		
		Assert.assertNotNull("The account must exist", account);
	}
	
	/**
	 * Fail test that the service does not find the actual user;
	 */
	@Test
	public void loadUserByUsernameEmptyValueTest() {
		AccountNotFoundException actualException = null;
		
		try {
			this.accountService.loadAccountByUsername("");
		} catch (AccountNotFoundException e) {
			actualException=e;
		}
		
		Assert.assertNotNull("The actualException must exist", actualException);
	}
	
	/**
	 * Fail test that the service does not find the actual user.
	 */
	@Test
	public void loadUserByUsernameNullValueTest() {
		AccountNotFoundException actualException = null;
		
		try {
			this.accountService.loadAccountByUsername(null);
		} catch (AccountNotFoundException e) {
			actualException=e;
		}
		
		Assert.assertNotNull("The actualException must exist", actualException);
	}
	
	

}
