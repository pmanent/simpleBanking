package com.simple.banking.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.banking.entities.Movement;
import com.simple.banking.repositories.MovementRepository;

@Service
public class MovementServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(MovementServiceImpl.class);
	
	@Autowired
	private MovementRepository movementRepository;
	
	public MovementServiceImpl(MovementRepository movementRepository) {
		this.movementRepository = movementRepository;
	}
	public Movement saveMovement(Movement movement) {
		logger.debug("Saving movement type description "+movement.getDescription());
		return movementRepository.save(movement);
	}

}
