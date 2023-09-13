package com.fssa.sharpandclean.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.service.UserService;
import com.fssa.sharpandclean.service.exception.ServiceException;
 class TestUpdateFeature {

	@Test
	 void testUpdateSuccess() {
		UserService userService = new UserService();
		User user1 = new User( "kavi@gmail.com", "Kannan", "Aravindth@123", "9888844056", "user");
		try {
			assertTrue(userService.updateUser(user1));
		} catch (ServiceException e) { 
			System.out.println( e.getMessage()); 
		}
	}

	@Test
	 void testUpdateEmailNotFound() {
		UserService userService = new UserService();
		User user1 = new User( "aravindth12@gmail.com", "AravindthKavi", "Aravindth@123", "8072444056", "user");
		try {
			// Assuming the user with email "aravindth12@gmail.com" does not exist in the system
			boolean isDeleted = userService.updateUser(user1);
			assertFalse(isDeleted,"Expected ServiceException for email not found, but none was thrown.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

	@Test
	 void testUpdateInvalidEmailFormat() {
		UserService userService = new UserService();
		User user1 = new User( "aravindth12@.com", "AravindthKavi", "Aravindth@123", "8072444056", "user");
		try {
			// Assuming "invalid_email_format" is not a valid email format
			boolean isDeleted = userService.updateUser(user1);
			assertFalse(isDeleted,"Expected ServiceException for invalid email format, but none was thrown.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

	@Test
	 void testUpdateMissingRequiredField() {
		UserService userService = new UserService();
		// Leaving the name field empty
		User user1 = new User( "aravindth12@gmail.com", "", "Aravindth@123", "8072444056", "user");
		try {
			userService.updateUser(user1);
			fail("Expected ServiceException for missing required field, but none was thrown.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}
}
