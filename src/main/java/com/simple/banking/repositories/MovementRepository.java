package com.simple.banking.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simple.banking.entities.Movement;


public interface MovementRepository extends CrudRepository<Movement, Long>{
}
