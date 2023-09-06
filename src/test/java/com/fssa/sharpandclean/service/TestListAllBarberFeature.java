package com.fssa.sharpandclean.service;


import static org.junit.Assert.fail;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.fssa.sharpandclean.model.Barber;
import com.fssa.sharpandclean.service.exception.ServiceException;

public class TestListAllBarberFeature {

	@Test
	public void testListAllBarber() throws ServiceException {
		BarberService barberService = new BarberService();
		try {
			List<Barber> barberList = barberService.getAllBarber();
			for(Barber singleBarber : barberList) {
				System.out.println(singleBarber.toString());
			}
			assertNotNull(barberList); 
		}catch(ServiceException e) {
			System.out.println( e.getMessage()); 
			fail();
		}
		
		
	}
}
