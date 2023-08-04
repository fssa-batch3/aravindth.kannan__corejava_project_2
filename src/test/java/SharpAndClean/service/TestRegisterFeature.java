package SharpAndClean.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import SharpAndClean.module.User;
import SharpAndClean.service.UserService;
import SharpAndClean.service.exception.ServiceException;

public class TestRegisterFeature {

//	public static void main(String[] args) {
//
//		User user1 = new User("navee@gmail.com", "Naveena", "Navee@123");
//		UserService userService = new UserService();
//
//		try {
//			userService.registerUser(user1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("navee@gmail.com", "Naveena", "Navee@123","9876543123","user");
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void testRegistrationFail() {
//
//		UserService userService = new UserService();
//		User user1 = new User("", "Babu", "Babu@123","9876543123","user");
//		try {
//			userService.registerUser(user1);
//			fail();
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testUserNull() {
//		UserService userService = new UserService();
//		User user1 = null;
//		try {
//			assertFalse(userService.registerUser(user1));
//		} catch (ServiceException e) {
//			e.printStackTrace();
//
//		}
//	}
//	
}
