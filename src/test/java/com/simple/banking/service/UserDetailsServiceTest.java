package com.simple.banking.service;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.simple.banking.entities.Users;
import com.simple.banking.repositories.UserRepository;

/**
 *  Class responsible to execute the unit test with the mockito Framework.
 *  
 *  @author peremanent
 *
 */
public class UserDetailsServiceTest {
	
	private static final String USERNAME = "admin";

	private UserDetailsServiceImpl userDetailsService;
		
	private UserRepository userRepository;
	
	
	@Before
    public void setupMock() {
		Users actualUser = new Users();
		actualUser.setPassword("dummy");
		actualUser.setUsername(USERNAME);
		
		this.userRepository = mock(UserRepository.class);
		when(this.userRepository.findByUsername(USERNAME)).thenReturn(actualUser);
		
		this.userDetailsService = new UserDetailsServiceImpl(userRepository);
    }
	/**
	 * Succesfull test that loads the username
	 */
	@Test
	public void loadUserByUsernameOKTest() {
		UserDetails actualUser = this.userDetailsService.loadUserByUsername(USERNAME);
		
		Assert.assertNotNull("The user must exist", actualUser);
	}
	/**
	 * Fail test that the service does not find the actual user;
	 */
	@Test
	public void loadUserByUsernameEmptyValueTest() {
		UsernameNotFoundException actualException = null;
		
		try {
			this.userDetailsService.loadUserByUsername("");
		} catch (UsernameNotFoundException e) {
			actualException=e;
		}
		
		Assert.assertNotNull("The actualException must exist", actualException);
	}
	
	/**
	 * Fail test that the service does not find the actual user.
	 */
	@Test
	public void loadUserByUsernameNullValueTest() {
		UsernameNotFoundException actualException = null;
		
		try {
			this.userDetailsService.loadUserByUsername(null);
		} catch (UsernameNotFoundException e) {
			actualException=e;
		}
		
		Assert.assertNotNull("The actualException must exist", actualException);
	}

}
