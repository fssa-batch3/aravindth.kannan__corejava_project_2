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
		User user1 = new User("navee@gmail.com", "Navee@123");
		try {
			assertTrue(userService.loginUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test

	public void loginFailed() {
		UserService userService = new UserService();
		User user2 = new User("alsa@gmail.com", "Password@796");
		try {
			assertFalse(userService.loginUser(user2));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
