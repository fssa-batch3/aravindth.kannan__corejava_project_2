package com.fssa.sharpandclean.service;

import org.junit.Test;

import com.fssa.sharpandclean.service.exception.ServiceException;
import com.fssa.sharpandclean.service.exception.StyleException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;


 class TestDeleteStyle { 

		@Test
		 void testDeleteDesignSuccess()  {
			StyleService styleService = new StyleService();
			// Assume you have a valid styleId for an existing design
			int styleId = 3;
			try {
				assertTrue(styleService.deleteStyle(styleId));
			}catch( ServiceException e) {
				e.getMessage(); 
				fail();
			}
         
			
		}

		@Test
		 void testDeleteNonExistingStyle() throws ServiceException {
			StyleService styleService = new StyleService();
			
			// Assume you have a styleId that does not exist in the database
			int nonExistingStyleId = 1000;
			try {
				assertFalse(styleService.deleteStyle(nonExistingStyleId));
			}catch(ServiceException e) {
				e.getMessage(); 
				fail();
			}
			
			
		}

		@Test
		 void testDeleteStyleWithInvalidId() throws ServiceException {
			StyleService styleService = new StyleService();
			// Assume you have an invalid designId, e.g. negative value
			int invalidStyleId = -1;
			try {
				assertFalse(styleService.deleteStyle(invalidStyleId));

			}catch(ServiceException e) {
				e.getMessage();
				fail();
			}
			
		}

		@Test
		 void testDeleteStyleWithNullId() throws ServiceException {
			StyleService styleService = new StyleService();
			int nullStyleId = 0; // Assuming 0 is considered a null design ID
			try {
				
				assertFalse(styleService.deleteStyle(nullStyleId));
			}catch(ServiceException e) {
				e.getMessage();
				fail();
			}
		}

	}

