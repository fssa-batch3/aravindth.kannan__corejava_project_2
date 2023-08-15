package SharpAndClean.TestUser;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.fssa.SharpAndClean.service.StyleService;
import com.fssa.SharpAndClean.service.exception.StyleException;


public class TestDeleteStyle {

		@Test
		public void testDeleteDesignSuccess() throws StyleException {
			StyleService styleService = new StyleService();
			// Assume you have a valid styleId for an existing design
			int designIdToDelete = 199;

			assertTrue(styleService.deleteStyle(designIdToDelete));
			System.out.println("Design deleted successfully");
		}

		@Test
		public void testDeleteNonExistingStyle() throws StyleException {
			StyleService styleService = new StyleService();
			// Assume you have a styleId that does not exist in the database
			int nonExistingDesignId = 1000;

			assertFalse(styleService.deleteStyle(nonExistingDesignId));
			System.out.println("Design not found, delete failed");
		}

		@Test
		public void testDeleteStyleWithInvalidId() throws StyleException {
			StyleService designService = new StyleService();
			// Assume you have an invalid designId, e.g. negative value
			int invalidDesignId = -1;

			assertFalse(designService.deleteStyle(invalidDesignId));
			System.out.println("Invalid design ID, delete failed");
		}

		@Test
		public void testDeleteStyleWithNullId() throws StyleException {
			StyleService designService = new StyleService();
			int nullDesignId = 0; // Assuming 0 is considered a null design ID

			assertFalse(designService.deleteStyle(nullDesignId));
			System.out.println("Null design ID, delete failed");
		}

	}

