package SharpAndClean.TestUser;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import SharpAndClean.module.*;
import SharpAndClean.service.StyleService;
import SharpAndClean.service.exception.StyleException;

public class TestAddStyleFeature {

	public static void main(String [] args) {
	}
	
		@Test
		public void  testAddStyleSuccess() {
			StyleService hairStyle = new StyleService();
			Style hairstyle = new Style("Shorthaircut","aravindth@gmail.com","Haircut","It's trending now in youngstars","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(hairStyle.addedStyle(hairstyle));
		}catch(StyleException e) {
			e.printStackTrace();
		}
		}
		
}
