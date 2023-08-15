package SharpAndClean.TestUser;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.SharpAndClean.dao.StyleDAO;
import com.fssa.SharpAndClean.dao.exception.StyleDAOException;
import com.fssa.SharpAndClean.module.Style;
import com.fssa.SharpAndClean.service.StyleService;
import com.fssa.SharpAndClean.service.exception.StyleException;


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
	public void testListArchitects() throws StyleException {
		StyleService styleService = new StyleService();

		try {
			List<Style> styles = styleService.getAllStyle();
			Assertions.assertNotNull(styles, "List of style is null.");
			Assertions.assertFalse(styles.isEmpty(), "List of architects is not empty.");
		} catch (StyleException e) {
			e.printStackTrace();
			fail("Exception occurred while fetching styles from the service.");
		}
	}
}











	




