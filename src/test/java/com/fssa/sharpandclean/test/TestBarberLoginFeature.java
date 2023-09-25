package com.fssa.sharpandclean.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.Barber;
import com.fssa.sharpandclean.service.BarberService;
import com.fssa.sharpandclean.service.exception.ServiceException;

 class TestBarberLoginFeature {

	@Test
	 void barberLoginSuccess() throws ServiceException {
		BarberService userService = new BarberService();
		String email = "kavi@gmail.com";
		String password = "Kavi@123";
		Barber barber1 = new Barber(email, password);
		
			assertTrue(userService.loginBarber(barber1));
		
	}
	
	@Test
	 void loginFailed() {
		BarberService barberService = new BarberService();
		String email = "ahkj@gmail.com";
		String password = "Password@796";
		Barber user2 = new Barber(email, password);
		try {
			barberService.loginBarber(user2);
			fail("Failed to Login.");
		} catch (ServiceException e) {
			e.getMessage(); 		}
	}
	
	@Test
	 void testLoginEmailCheck() {
		BarberService barberService = new BarberService();
		String email = "invalidemail"; // Invalid email format
		String password = "Aravindth@123";
		Barber user1 = new Barber(email, password);
		try {
			barberService.loginBarber(user1); // Expecting login failure
			fail("Login with invalid email format should fail.");
		} catch (ServiceException e) {
			e.getMessage(); 		}
	}
	
	
}
