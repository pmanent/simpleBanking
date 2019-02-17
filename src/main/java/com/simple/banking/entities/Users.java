package com.simple.banking.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Users {
	/**
	 * Username of the actual user.
	 */
	@Id
	private String username;
	/**
	 * Password of the actual user.
	 */
	private String password;
	
	public Users() {
		
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
    
}
