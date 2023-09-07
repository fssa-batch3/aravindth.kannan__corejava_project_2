package com.fssa.sharpandclean.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.service.exception.ServiceException;

 class TestDeleteBarber {
	@Test 
	 void testDeleteUserSuccess() {
		BarberService barberService = new BarberService();
		// Assuming a user with the email "kavi@gmail.com" exists in the database
		String barberEmail = "kavi@gmail.com";
		try { 
			
			boolean isDeleted = barberService.deleteBarber(barberEmail);
			assertTrue(isDeleted, "Barber deletion passed.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		
		}
	}

  @Test
	 void testDeleteNonExistingBarber() {
		BarberService barberService = new BarberService();
		// Assuming a user with the email "nonexisting@example.com" does not exist in
		// the database
		String barberEmail = "magesh@gmail.com";
		try {
			
			boolean isDeleted = barberService.deleteBarber(barberEmail);
			assertFalse(isDeleted,"User with non-existing email should not be deleted, but method succeeded.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

	@Test
	 void testDeleteBarberWithInvalidBarberEmail() {
		BarberService barberService = new BarberService();
		String barberEmail = "magesh@.com";
		try {
			boolean isDeleted = barberService.deleteBarber(barberEmail);
			assertFalse(isDeleted, "User should not be deleted.");
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
		}
	}

}
