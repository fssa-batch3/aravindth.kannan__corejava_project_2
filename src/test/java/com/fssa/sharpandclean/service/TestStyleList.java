package com.fssa.sharpandclean.service;

import static org.junit.Assert.fail;

//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.Style;
import com.fssa.sharpandclean.service.exception.ServiceException;

 class TestStyleList {
	@Test
	 void testListStyles() throws  ServiceException {
		StyleService style = new StyleService();
		try {
			List<Style> styles = style.getAllStyles();
			for (Style singleStyle : styles) {
				System.out.println(singleStyle.toString());
			}
			assertNotNull(styles); 
		} catch (ServiceException e) {
			System.out.println( e.getMessage()); 
			fail();
		}

	}
}


