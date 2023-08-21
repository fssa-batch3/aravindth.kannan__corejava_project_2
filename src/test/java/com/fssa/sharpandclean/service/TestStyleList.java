package com.fssa.sharpandclean.service;
import static org.junit.Assert.fail;
//import static org.junit.jupiter.api.Assertions.assertFalse;



import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.dao.StyleDAO;
import com.fssa.sharpandclean.dao.exception.StyleDAOException;
import com.fssa.sharpandclean.module.Style;
import com.fssa.sharpandclean.service.StyleService;
import com.fssa.sharpandclean.service.exception.StyleException;


public class TestStyleList {
	@Test
	public void testListStyleNotEmptyTrue() throws StyleDAOException {
	    StyleDAO styleDAO = new StyleDAO();
try {
    List<Style> styles = styleDAO.getAllStyle();
	Assertions.assertNotNull(styles, "List of style is null.");
	Assertions.assertTrue(!styles.isEmpty(), "List of style is empty.");
}catch(StyleDAOException e) {
	e.printStackTrace();
	fail("Exception occurred while fetching styles from the service.");
}

	}


	@Test
	public void testListStyles() throws StyleException {
		StyleService styleService = new StyleService();

		try {
			List<Style> styles = styleService.getAllStyle();
			Assertions.assertNotNull(styles, "List of style is null.");
			Assertions.assertFalse(styles.isEmpty(), "List of style is not empty.");
		} catch (StyleException e) {
			e.printStackTrace();
			fail("Exception occurred while fetching styles from the service.");
		}
	}
}











	




