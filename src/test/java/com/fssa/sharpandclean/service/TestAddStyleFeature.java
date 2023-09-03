package com.fssa.sharpandclean.service;

import static org.junit.Assert.assertTrue;



import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

import com.fssa.sharpandclean.model.*;
import com.fssa.sharpandclean.service.exception.StyleException;

public class TestAddStyleFeature {

	public static void main(String [] args) {
	}
	
		@Test
		// test successfully add style
		public void  testAddStyleSuccess() {
			StyleService styleService = new StyleService();
			Style styles = new Style("Shorthaircut","aravindth@gmail.com","Haircut","Its trending now in youngstars","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(styleService.addStyle(styles));
		}catch(StyleException e) {
			e.printStackTrace();
		}
		
		}
		
		 @Test
		 // test style email id is empty
		    public void testStyleEmailEmpty() {
			 StyleService styleService = new StyleService();
			 Style styles = new Style("Firehaircut", "", "Haircut", "Its trending now in youngstars", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(styleService.addStyle(styles));
		            fail();
		        } catch (StyleException e) {
		            e.printStackTrace();
		        }
		    }
		
		 @Test
		 // test invalid style type
		    public void testStyleTypeInvalid() {
			 StyleService styleService = new StyleService();
			 Style styles = new Style("Firehaircut", "aravindth@gmail.com", "saloontype", "Its trending now in youngstars", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(styleService.addStyle(styles));
		            fail();
		        } catch (StyleException e) {
		            e.printStackTrace();
		        }
		    }
		 
		 @Test
		 // test empty style name
		    public void testNullStyleName() {
			 StyleService styleService = new StyleService();
			 Style styles = new Style("", "aravindth@gmail.com", "Haircut", "Its trending now in youngstars", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(styleService.addStyle(styles));
		            fail("Expected ServiceException for null Style name, but none was thrown.");
		        } catch (StyleException e) {
		            e.printStackTrace();
		        }
		    }
		 
		 @Test
		 // test invalid style URL
		    public void testInvalidStyleURL() {
			 StyleService styleService = new StyleService();
				 Style styles = new Style("longhaircut", "aravindth@gmail.com", "Hair coloring", "Its trending now in youngstars", "encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(styleService.addStyle(styles));
		            fail();
		        } catch (StyleException e) {
		            e.printStackTrace();
		        }
		    }
}
