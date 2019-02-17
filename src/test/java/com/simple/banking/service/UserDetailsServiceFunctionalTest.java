package com.simple.banking.service;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserDetailsServiceFunctionalTest {
	
	private static final String USERNAME = "admin";
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	
	
	/**
	 * Succesfull test that loads the username
	 */
	@Test
	public void loadUserByUsernameOKTest() {
		UserDetails actualUser = this.userDetailsServiceImpl.loadUserByUsername(USERNAME);
		
		Assert.assertNotNull("The user must exist", actualUser);
	}
	/**
	 * Fail test that the service does not find the actual user;
	 */
	@Test
	public void loadUserByUsernameEmptyValueTest() {
		UsernameNotFoundException actualException = null;
		
		try {
			this.userDetailsServiceImpl.loadUserByUsername("");
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
			this.userDetailsServiceImpl.loadUserByUsername(null);
		} catch (UsernameNotFoundException e) {
			actualException=e;
		}
		
		Assert.assertNotNull("The actualException must exist", actualException);
	}

}
