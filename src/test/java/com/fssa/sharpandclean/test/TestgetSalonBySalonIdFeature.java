package com.fssa.sharpandclean.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import com.fssa.sharpandclean.model.Salon;
import com.fssa.sharpandclean.service.SalonService;
import com.fssa.sharpandclean.service.exception.ServiceException;

public class TestgetSalonBySalonIdFeature {
	
	@Test
	 void getSalonSuccess() {
		SalonService salonService = new SalonService();
		int salonID = 13;
		try {
			Salon getSalon = salonService.getSalonBySalonId(salonID);
			assertTrue(getSalon != null);
			System.out.println(getSalon.toString());
		} catch (ServiceException e) {
		e.getMessage();

		}
	}

	@Test
	 void getSalonFailed() {
		SalonService salonService = new SalonService();
		int salonID = 1;
		try {
			Salon getUser = salonService.getSalonBySalonId(salonID);
			assertFalse(getUser == null);
			System.out.println("Doesn't salon have this salon ID.");

		} catch (ServiceException e) {
         System.out.println(e.getMessage());
		}
	}
}
