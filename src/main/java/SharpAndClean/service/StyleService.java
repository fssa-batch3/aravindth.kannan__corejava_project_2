package SharpAndClean.service;

import java.sql.SQLException;

import SharpAndClean.dao.*;
import SharpAndClean.module.*;
import SharpAndClean.service.exception.StyleException;
import SharpAndClean.validation.StyleValidator;
import SharpAndClean.validation.exception.InvalidStyleException;
public class StyleService {

	public boolean addedStyle(Style style) throws StyleException {
		StyleDAO hairStyle = new StyleDAO();
		
		try {
			StyleValidator.validateHairService(style);
			
			return hairStyle.addStyle(style);
		}catch (InvalidStyleException | SQLException e) {
			throw new StyleException(e);
		}
		
		
	}
}
