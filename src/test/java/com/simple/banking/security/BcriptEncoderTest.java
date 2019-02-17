package com.simple.banking.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcriptEncoderTest {
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public BcriptEncoderTest() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}
	@Test
	public void testEncode() {
		String password = bCryptPasswordEncoder.encode("welcome1");
		password = bCryptPasswordEncoder.encode("welcome1");
	}

}
