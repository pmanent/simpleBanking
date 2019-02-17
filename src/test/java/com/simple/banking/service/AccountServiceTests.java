package com.simple.banking.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.simple.banking.entities.Account;
import com.simple.banking.exception.AccountNotFoundException;
import com.simple.banking.repositories.AccountRepository;


public class AccountServiceTests {

	private static final String USERNAME = "admin";
	
	private AccountServiceImpl accountService;
	
	private AccountRepository accountRepository;
	
	@Before
    public void setupMock() {
		Account actualAccount= new Account();
		
		this.accountRepository = mock(AccountRepository.class);
		when(this.accountRepository.findByUsername(USERNAME)).thenReturn(actualAccount);
		
		this.accountService = new AccountServiceImpl(accountRepository);
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
