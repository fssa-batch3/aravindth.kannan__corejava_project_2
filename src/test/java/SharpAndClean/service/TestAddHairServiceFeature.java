package SharpAndClean.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import SharpAndClean.module.*;
import SharpAndClean.service.exception.HairService_Exception;

public class TestAddHairServiceFeature {

	public static void main(String [] args) {
	}
	
		@Test
		public void  testAddHairserviceSuccess() {
			HairService_service hair_service = new HairService_service();
			HairService hairservice1 = new HairService("Shorthaircut","aravindth@gmail.com","Haircut","It's trending now in youngstars","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(hair_service.addedHairService(hairservice1));
		}catch(HairService_Exception e) {
			e.printStackTrace();
		}
		}
		
}
