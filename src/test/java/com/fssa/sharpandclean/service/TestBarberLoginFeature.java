package com.fssa.sharpandclean.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.Barber;
import com.fssa.sharpandclean.service.exception.ServiceException;

 class TestBarberLoginFeature {

	@Test
	 void barberLoginSuccess() {
		BarberService userService = new BarberService();
		String email = "kavi@gmail.com";
		String password = "Kavi@123";
		Barber barber1 = new Barber(email, password);
		try {
			assertTrue(userService.loginBarber(barber1, email));
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}
	
	@Test
	 void loginFailed() {
		BarberService barberService = new BarberService();
		String email = "ahkj@gmail.com";
		String password = "Password@796";
		Barber user2 = new Barber(email, password);
		try {
			barberService.loginBarber(user2, email);
			fail("Failed to Login.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}
	
	@Test
	 void testLoginEmailCheck() {
		BarberService barberService = new BarberService();
		String email = "invalidemail"; // Invalid email format
		String password = "Aravindth@123";
		Barber user1 = new Barber(email, password);
		try {
			barberService.loginBarber(user1, email); // Expecting login failure
			fail("Login with invalid email format should fail.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}
	
	@Test
	 void testLoginNullUser() {
		BarberService barberService = new BarberService();
		try {
			barberService.loginBarber(null, "aravindth12@gmail.com"); // Expecting login failure
			fail();
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}
}
