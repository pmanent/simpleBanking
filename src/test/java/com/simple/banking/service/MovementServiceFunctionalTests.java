package com.simple.banking.service;

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
public class MovementServiceFunctionalTests {
	private static final String USERNAME = "admin";
	@Autowired
	private MovementServiceImpl movementService;
	@Autowired
	private AccountServiceImpl accountService;
	
	public MovementServiceFunctionalTests() {
	}
	
	@Test
	public void movementSaveTest() {
		Account account = this.accountService.loadAccountByUsername(USERNAME);
		Movement movement = new Movement();
		movement.setId(10000L);
		movement.setAccount(account);
		movement.setDescription("Deposit");
		movement.setTotal(500L);
		
		Movement savedMovement = this.movementService.saveMovement(movement);
		
		Assert.assertNotNull("The savedMovement must exist", savedMovement);
		
	}
	
	@Test
	public void movementSaveAndUpdateTest() {
		Account account = this.accountService.loadAccountByUsername(USERNAME);
		Movement movement = new Movement();
		movement.setId(10001L);
		movement.setAccount(account);
		movement.setDescription("Deposit");
		movement.setTotal(500L);
		
		this.movementService.saveMovement(movement);
		
		this.accountService.updateAccount(account.getId());
		
		account = this.accountService.loadAccountByUsername(USERNAME);
		Long expected = 1000L;
		Assert.assertEquals("The account must have 1000", expected , account.getAmmount());
		
	}
}
