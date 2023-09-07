package com.fssa.sharpandclean.service;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.service.UserService;
import com.fssa.sharpandclean.service.exception.ServiceException;

public class TestLoginFeature {

	@Test
	 void loginSuccess() {
		UserService userService = new UserService();
		String email = "aravindth12@gmail.com";
		String password = "Aravindth@123";
		User user1 = new User(email, password);
		try {
			assertTrue(userService.loginUser(user1));
			System.out.println("Successfully Logged in.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

	@Test
	 void loginFailed() {
		UserService userService = new UserService();
		String email = "ahkj@gmail.com";
		String password = "Password@796";
		User user2 = new User(email, password);
		try {
			userService.loginUser(user2);
			fail("Failed to Login.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

	

	@Test
	 void testLoginEmailCheck() {
		UserService userService = new UserService();
		String email = "invalidemail"; // Invalid email format
		String password = "Aravindth@123";
		User user1 = new User(email, password);
		try {
			userService.loginUser(user1); // Expecting login failure
			fail("Login with invalid email format should fail.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

	@Test
	 void testLoginNullUser() {
		UserService userService = new UserService();
		try {
			userService.loginUser(null); // Expecting login failure
			fail();
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}
}