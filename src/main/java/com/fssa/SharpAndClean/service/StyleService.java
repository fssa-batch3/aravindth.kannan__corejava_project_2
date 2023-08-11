package com.fssa.SharpAndClean.service;

import java.sql.SQLException;

import com.fssa.SharpAndClean.dao.*;
import com.fssa.SharpAndClean.module.*;
import com.fssa.SharpAndClean.service.exception.StyleException;
import com.fssa.SharpAndClean.validation.StyleValidator;
import com.fssa.SharpAndClean.validation.exception.InvalidStyleException;
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
