package com.simple.banking.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import com.simple.banking.entities.Account;
import com.simple.banking.entities.Movement;
import com.simple.banking.repositories.AccountRepository;
import com.simple.banking.repositories.MovementRepository;

public class AccountServiceDepositTests {
	
	private static final String USERNAME = "admin";
	private static final String AMMOUNT = "250";
	
	private AccountServiceImpl accountService;
	
	private AccountRepository accountRepository;
	
	private MovementServiceImpl movementServiceImpl;
	
	private MovementRepository movementRepository;
	
	public AccountServiceDepositTests() {
	}
	
	@Before
    public void setupMock() {
		Account actualAccount= new Account();
		actualAccount.setMovements(new ArrayList<Movement>());
		
		this.accountRepository = mock(AccountRepository.class);
		when(this.accountRepository.findByUsername(USERNAME)).thenReturn(actualAccount);
		
		Movement movement = new Movement();
		movement.setAccount(actualAccount);
		movement.setDescription("Deposit");
		movement.setTotal(250L);
		
		this.movementRepository=mock(MovementRepository.class);
		when(this.movementRepository.save(ArgumentMatchers.any(Movement.class))).thenReturn(movement);
		this.movementServiceImpl = new MovementServiceImpl(this.movementRepository);
		
		this.accountService = new AccountServiceImpl(this.accountRepository, this.movementServiceImpl);
    }
	
	@Test
	public void depositOKTest() {
		String username = USERNAME;
		String ammount = AMMOUNT;
		Movement generatedMovement = this.accountService.deposit(username, ammount);
		Assert.assertNotNull("The deposit is not generated",generatedMovement);
	}
	
	
}
