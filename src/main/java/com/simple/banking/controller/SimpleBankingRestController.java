package com.simple.banking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.banking.entities.Account;
import com.simple.banking.entities.Movement;
import com.simple.banking.service.AccountServiceImpl;

/**
 * Main class that holds all the API REST methods
 * @author peremanent
 *
 */
@RestController
public class SimpleBankingRestController {
	@Autowired
	private AccountServiceImpl accountService;

	public SimpleBankingRestController() {
	}

	@RequestMapping(value = "/statement", method = RequestMethod.GET, produces = "application/json")
	public Account loadAccountStatement(@RequestParam() String username) {
		return this.accountService.loadAccountByUsername(username);
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST, produces = "application/json")
	public Movement deposit(@RequestBody Map<String,String> allRequestParams) {
		return this.accountService.deposit(allRequestParams.get("username"), allRequestParams.get("ammount"));
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST, produces = "application/json")
	public Movement withdraw(@RequestBody Map<String,String> allRequestParams) {
		return this.accountService.withdraw(allRequestParams.get("username"), allRequestParams.get("ammount"));
	}
}
