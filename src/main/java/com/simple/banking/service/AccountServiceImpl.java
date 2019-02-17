package com.simple.banking.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.simple.banking.entities.Account;
import com.simple.banking.entities.Movement;
import com.simple.banking.exception.AccountNotFoundException;
import com.simple.banking.repositories.AccountRepository;
import com.simple.banking.service.commands.BankingCommand;
import com.simple.banking.service.commands.MovementDepositCommand;
import com.simple.banking.service.commands.MovementWithdrawCommand;
import com.simple.banking.service.commands.UpdateAccountCommand;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	private MovementServiceImpl movementServiceImpl;
	
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountServiceImpl() {
	}
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public AccountServiceImpl(AccountRepository accountRepository, MovementServiceImpl movementServiceImpl) {
		this.accountRepository = accountRepository;
		this.movementServiceImpl = movementServiceImpl;
	}	
	/**
	 * Loads the account with the username as a parameter
	 * @param username
	 * @return
	 * @throws AccountNotFoundException
	 */
    public Account loadAccountByUsername(String username) throws AccountNotFoundException {
    	//TODO refactor to a Command
    	logger.debug("loadAccountByUsername with username "+username);
    	Account account = this.accountRepository.findByUsername(username);
        if (account == null) {
            throw new AccountNotFoundException(username);
        }
        return account;
    }
    
    /**
     * Updates the total ammout of the actual account.
     * @param accountId
     */
    public void updateAccount(Long accountId) {
    	Optional<Account> optionalAccount = this.accountRepository.findById(accountId);
    	this.updateAccount(optionalAccount.get());
    }
    /**
     * Updates the total ammout of the actual account.
     * @param account
     */
    public void updateAccount(Account account) {
    	
    	BankingCommand updateAccount = new UpdateAccountCommand(account);
    	Account actualAccount = (Account)updateAccount.execute();
    	this.accountRepository.save(actualAccount);
    }
    
	public Movement deposit(String username, String ammount) {
		logger.debug("Deposit an ammount "+ammount+". For the user "+username);
		
		MovementDepositCommand movementDepositCommand = new MovementDepositCommand(username,ammount);
		
		Movement depositMovement = (Movement)movementDepositCommand.execute();
		
		Account actualAccount = this.loadAccountByUsername(username);
		
		depositMovement.setAccount(actualAccount);
		
		Movement savedMovement = movementServiceImpl.saveMovement(depositMovement);
		
		actualAccount.getMovements().add(savedMovement);
		
		this.updateAccount(actualAccount);
		
		return savedMovement;
	}
	
	public Movement withdraw(String username, String ammount) {
		logger.debug("Deposit an ammount "+ammount+". For the user "+username);
		MovementWithdrawCommand movementWithdrawCommand = new MovementWithdrawCommand(username,ammount);
		
		Movement witdhdrawMovement = (Movement)movementWithdrawCommand.execute();
		
		Account actualAccount = this.loadAccountByUsername(username);
		
		witdhdrawMovement.setAccount(actualAccount);
		
		Movement savedMovement = movementServiceImpl.saveMovement(witdhdrawMovement);
		
		actualAccount.getMovements().add(savedMovement);
		
		this.updateAccount(actualAccount);
		
		return savedMovement;
	}
}
