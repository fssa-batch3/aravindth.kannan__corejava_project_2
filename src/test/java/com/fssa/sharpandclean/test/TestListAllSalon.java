package com.fssa.sharpandclean.test;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.fssa.sharpandclean.model.Salon;
import com.fssa.sharpandclean.service.SalonService;
import com.fssa.sharpandclean.service.exception.ServiceException;

public class TestListAllSalon {

	
	@Test
	 void testListAllSalon() throws ServiceException {
		SalonService salonService = new SalonService();
		try {
			List<Salon> salonList = salonService.getAllSalon();
			for(Salon singleSalon : salonList) {
				System.out.println(singleSalon.toString());
			}
			assertNotNull(salonList); 
		}catch(ServiceException e) {
			System.out.println( e.getMessage()); 
			fail();
		}
		
		
	}
}
