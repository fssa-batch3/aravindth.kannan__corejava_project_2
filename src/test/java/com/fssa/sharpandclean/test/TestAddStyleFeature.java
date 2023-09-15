package com.fssa.sharpandclean.test;

import static org.junit.Assert.assertTrue;


import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.*;
import com.fssa.sharpandclean.service.StyleService;
import com.fssa.sharpandclean.service.exception.StyleException;

class TestAddStyleFeature {

	

	@Test
	// test successfully add style
	void testAddStyleSuccess() {
		StyleService styleService = new StyleService();
		Style styles = new Style("Shorthaircut", "aravindth@gmail.com", "Haircut", "Its trending now in youngstars",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(styleService.addStyle(styles));
		} catch (StyleException e) {
			System.out.println(e.getMessage()); 
		}

	}

	@Test
	// test style email id is empty
	void testStyleEmailEmpty() {
		StyleService styleService = new StyleService();
		Style styles = new Style("Firehaircut", "", "Haircut", "Its trending now in youngstars",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(styleService.addStyle(styles));
			fail();
		} catch (StyleException e) {
			e.getMessage();
		}
	}

	@Test
	// test invalid style type
	void testStyleTypeInvalid() {
		StyleService styleService = new StyleService();
		Style styles = new Style("Firehaircut", "aravindth@gmail.com", "saloontype", "Its trending now in youngstars",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(styleService.addStyle(styles));
			fail();
		} catch (StyleException e) {
			e.getMessage();
		}
	}

	@Test
	// test empty style name
	void testNullStyleName() {
		StyleService styleService = new StyleService();
		Style styles = new Style("", "aravindth@gmail.com", "Haircut", "Its trending now in youngstars",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(styleService.addStyle(styles));
			fail("Expected ServiceException for null Style name, but none was thrown.");
		} catch (StyleException e) {
			e.getMessage();
		}
	}

	@Test
	// test invalid style URL
	void testInvalidStyleURL() {
		StyleService styleService = new StyleService();
		Style styles = new Style("longhaircut", "aravindth@gmail.com", "Hair coloring",
				"Its trending now in youngstars",
				"encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgw256XHMSlaLXXtTDJxi96fwZP3EZmoE5Fg&usqp=CAU");
		try {
			assertTrue(styleService.addStyle(styles));
			fail();
		} catch (StyleException e) {
			e.getMessage();
		}
	}
}
