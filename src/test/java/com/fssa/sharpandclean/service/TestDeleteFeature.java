package com.fssa.sharpandclean.service;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.fssa.sharpandclean.service.exception.ServiceException;

public class TestDeleteFeature {

	@Test 
	 void testDeleteUserSuccess() {
		UserService userService = new UserService();
		// Assuming a user with the email "kavi@gmail.com" exists in the database
		String userEmail = "chandru@gmail.com";
		try { 
			
			boolean isDeleted = userService.deleteUser(userEmail);
			assertTrue(isDeleted, "User deletion passed.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		
		}
	}

	@Test
	 void testDeleteNonExistingUser() {
		UserService userService = new UserService();
		// Assuming a user with the email "nonexisting@example.com" does not exist in
		// the database
		String userEmail = "magesh@gmail.com";
		try {
			
			boolean isDeleted = userService.deleteUser(userEmail);
			assertFalse(isDeleted,"User with non-existing email should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

	@Test
	 void testDeleteUserWithInvalidUserId() {
		UserService userService = new UserService();
		String userEmail = "magesh@.com";
		try {
			boolean isDeleted = userService.deleteUser(userEmail);
			assertFalse(isDeleted, "User should not be deleted.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

}
