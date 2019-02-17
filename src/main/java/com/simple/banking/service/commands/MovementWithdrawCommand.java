package com.simple.banking.service.commands;

import com.simple.banking.entities.Movement;
import com.simple.banking.exception.SimpleBankingException;
import com.simple.banking.service.rules.MandatoryRule;
import com.simple.banking.service.rules.NegativeAmmountRule;

public class MovementWithdrawCommand extends BankingCommandImpl {
	/**
	 * username of the Account's user.
	 */
	private String username;
	/**
	 * Total ammount to deposit.
	 */
	private String ammount;
	
	/**
	 * DepositCommand constructor.
	 */
	public MovementWithdrawCommand(String username, String ammount) {
		this.username = username;
		this.ammount = ammount;
		this.addRule(new MandatoryRule("username",this.username));
		this.addRule(new MandatoryRule("ammount",this.ammount));
		this.addRule(new NegativeAmmountRule(this.ammount));
	}

	@Override
	public Object execute() throws SimpleBankingException {
		super.validate();
		Movement movement = new Movement();
		movement.setTotal(Long.valueOf(this.ammount));
		movement.setDescription("Withdraw");
		return movement;
	}

}
