package com.fssa.sharpandclean.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.fssa.sharpandclean.model.SalonBook;
import com.fssa.sharpandclean.service.SalonService;
import com.fssa.sharpandclean.service.exception.ServiceException;
public class TestGetBookingSalonForUserFeature {
	 @Test
	 void testListAllSalonBookingForUser()  throws ServiceException {
		 SalonService salonService  = new SalonService();
		 try {
			 List<SalonBook> salonBookingList = salonService.getAllSalonBookingForUser("aravindth@gmail.com");
			 for(SalonBook singleSalonBook : salonBookingList) {
				 System.out.println(singleSalonBook.toString());
			 }
			 assertNotNull(salonBookingList);
		 }catch(ServiceException e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 @Test
	 void testListAllSalonBookingForSalon()  throws ServiceException {
		 SalonService salonService  = new SalonService();
		 try {
			 List<SalonBook> salonBookingList = salonService.getAllSalonBookingForSalon("meena12@gmail.com");
			 for(SalonBook singleSalonBook : salonBookingList) {
				 System.out.println(singleSalonBook.toString());
			 }
			 assertNotNull(salonBookingList);
		 }catch(ServiceException e) {
			 System.out.println(e.getMessage());
		 }
	 }
}
