package SharpAndClean.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import SharpAndClean.module.*;
import SharpAndClean.service.UserService;
import SharpAndClean.service.exception.ServiceException;

public class TestLoginFeature {

	@Test

	public void loginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("aravindth@gmail.com", "Akkam4321@");
		try {
			assertTrue(userService.loginUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test

	public void loginFailed() {
		UserService userService = new UserService();
		User user2 = new User("kavi@gmail.com", "akk432@");
		try {
			assertFalse(userService.loginUser(user2));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
