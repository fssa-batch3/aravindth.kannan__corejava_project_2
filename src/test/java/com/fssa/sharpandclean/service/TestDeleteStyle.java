package com.fssa.sharpandclean.service;

import org.junit.Test;

import com.fssa.sharpandclean.service.exception.StyleException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class TestDeleteStyle {

		@Test
		public void testDeleteDesignSuccess() throws StyleException {
			StyleService styleService = new StyleService();
			// Assume you have a valid styleId for an existing design
			int styleId = 199;

			assertTrue(styleService.deleteStyle(styleId));
			System.out.println("Style deleted successfully");
		}

		@Test
		public void testDeleteNonExistingStyle() throws StyleException {
			StyleService styleService = new StyleService();
			// Assume you have a styleId that does not exist in the database
			int nonExistingStyleId = 1000;

			assertFalse(styleService.deleteStyle(nonExistingStyleId));
			System.out.println("Style not found, delete failed");
		}

		@Test
		public void testDeleteStyleWithInvalidId() throws StyleException {
			StyleService styleService = new StyleService();
			// Assume you have an invalid designId, e.g. negative value
			int invalidStyleId = -1;

			assertFalse(styleService.deleteStyle(invalidStyleId));
			System.out.println("Invalid Style ID, delete failed");
		}

		@Test
		public void testDeleteStyleWithNullId() throws StyleException {
			StyleService styleService = new StyleService();
			int nullStyleId = 0; // Assuming 0 is considered a null design ID

			assertFalse(styleService.deleteStyle(nullStyleId));
			System.out.println("Null Style ID, delete failed");
		}

	}

