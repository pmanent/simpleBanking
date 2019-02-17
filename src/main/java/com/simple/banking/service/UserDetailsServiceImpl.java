package com.simple.banking.service;

import static java.util.Collections.emptyList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simple.banking.entities.Users;
import com.simple.banking.repositories.UserRepository;

/**
 * Class responsible to comunicate with the user repository. 
 * @author peremanent
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private UserRepository userRepository;
	/**
	 * Constructor of the User Details Service.
	 * @param userRepository
	 */
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	logger.debug("loadUserByUsername with username "+username);
    	Users applicationUser = this.userRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
