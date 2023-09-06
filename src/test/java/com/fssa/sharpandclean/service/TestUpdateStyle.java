package com.fssa.sharpandclean.service;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

import com.fssa.sharpandclean.model.Style;
import com.fssa.sharpandclean.service.exception.ServiceException;
import com.fssa.sharpandclean.service.exception.StyleException;

public class TestUpdateStyle {

	public static void main(String [] args) {
	}
		@Test
		// test successfully update style
		public void testUpdateSuccess() throws ServiceException {
			StyleService styleService = new StyleService();
			Style styles = new Style(2,"Shorthaircut","kavi@gmail.com","Haircut","Its trending now in youngstars","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
			try {
				assertTrue(styleService.updateStyle(styles, 1));
			}catch(ServiceException e) {
				System.out.println( e.getMessage()); 
			}
		}
		
		
		 
		
		 @Test
		 // test invalid style type
		    public void testStyleTypeInvalid() throws ServiceException {
			 StyleService styleService = new StyleService();
			 Style styles = new Style(3,"Firehaircut", "aravindth@gmail.com", "saloontype", "Its trending now in youngstars", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(styleService.addStyle(styles));
		            fail();
		        } catch (StyleException e) {
		        	System.out.println( e.getMessage()); 
		        }
		    }
		 
		 @Test
		 // test empty style name
		    public void testNullStyleName() throws ServiceException {
			 StyleService styleService = new StyleService();
			 Style styles = new Style(2,"", "aravindth@gmail.com", "Haircut", "Its trending now in youngstars", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(styleService.addStyle(styles));
		            fail("Expected ServiceException for null Style name, but none was thrown.");
		        } catch (StyleException e) {
		        	System.out.println( e.getMessage()); 
		        }
		    }
		 
		 @Test
		 // test invalid style URL
		    public void testInvalidStyleURL() throws ServiceException {
			 StyleService styleService = new StyleService();
				 Style styles = new Style(1,"longhaircut", "aravindth@gmail.com", "Hair coloring", "Its trending now in youngstars", "encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		        try {
		        	assertTrue(styleService.addStyle(styles));
		            fail();
		        } catch (StyleException e) {
		        	System.out.println( e.getMessage()); 
		        }
		    }
	}

