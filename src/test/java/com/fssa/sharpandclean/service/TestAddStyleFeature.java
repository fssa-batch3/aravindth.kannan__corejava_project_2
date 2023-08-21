package com.fssa.sharpandclean.service;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

import com.fssa.sharpandclean.module.*;
import com.fssa.sharpandclean.service.StyleService;
import com.fssa.sharpandclean.service.exception.StyleException;

public class TestAddStyleFeature {

	public static void main(String [] args) {
	}
	
		@Test
		// test successfully add style
		public void  testAddStyleSuccess() {
			StyleService hairStyle = new StyleService();
			Style hairstyle = new Style("Shorthaircut","aravindth@gmail.com","Haircut","Its trending now in youngstars","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(hairStyle.addedStyle(hairstyle));
		}catch(StyleException e) {
			e.printStackTrace();
		}
		
		}
		
		 @Test
		 // test style email id is empty
		    public void testStyleEmailEmpty() {
			 StyleService hairStyle = new StyleService();
			 Style hairstyle = new Style("Firehaircut", "", "Haircut", "Its trending now in youngstars", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(hairStyle.addedStyle(hairstyle));
		            fail();
		        } catch (StyleException e) {
		            e.printStackTrace();
		        }
		    }
		
		 @Test
		 // test invalid style type
		    public void testStyleTypeInvalid() {
			 StyleService hairStyle = new StyleService();
			 Style hairstyle = new Style("Firehaircut", "aravindth@gmail.com", "saloontype", "Its trending now in youngstars", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(hairStyle.addedStyle(hairstyle));
		            fail();
		        } catch (StyleException e) {
		            e.printStackTrace();
		        }
		    }
		 
		 @Test
		 // test empty style name
		    public void testNullStyleName() {
			 StyleService hairStyle = new StyleService();
			 Style hairstyle = new Style("", "aravindth@gmail.com", "Haircut", "Its trending now in youngstars", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(hairStyle.addedStyle(hairstyle));
		            fail("Expected ServiceException for null Style name, but none was thrown.");
		        } catch (StyleException e) {
		            e.printStackTrace();
		        }
		    }
		 
		 @Test
		 // test invalid style URL
		    public void testInvalidStyleURL() {
			 StyleService hairStyle = new StyleService();
				 Style hairstyle = new Style("longhaircut", "aravindth@gmail.com", "Hair coloring", "Its trending now in youngstars", "encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(hairStyle.addedStyle(hairstyle));
		            fail();
		        } catch (StyleException e) {
		            e.printStackTrace();
		        }
		    }
}
