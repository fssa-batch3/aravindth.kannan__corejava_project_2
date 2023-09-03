package com.fssa.sharpandclean.service;


import java.util.List;

import com.fssa.sharpandclean.dao.StyleDAO;
import com.fssa.sharpandclean.dao.exception.StyleDAOException;
import com.fssa.sharpandclean.model.Style;
import com.fssa.sharpandclean.service.exception.ServiceException;
import com.fssa.sharpandclean.service.exception.StyleException;
import com.fssa.sharpandclean.validation.StyleValidator;
import com.fssa.sharpandclean.validation.exception.InvalidStyleException;
public class StyleService {

	public boolean addStyle(Style style) throws  StyleException {
		StyleDAO hairStyle = new StyleDAO();
		
		try {
			StyleValidator.validateStyle(style);
			
			return hairStyle.addStyle(style);
		}catch (InvalidStyleException | StyleDAOException e) {
			throw new StyleException(e);
		}
		
		
	}
	
//	public List<Style> getAllStyle() throws ServiceException {
//		StyleDAO styleDAO = new StyleDAO();
//		try {
//			Style style = null;
//			StyleValidator.validateStyle(style);
//			return styleDAO.getAllStyle();
//		} catch (StyleDAOException | InvalidStyleException e) {
//			throw new ServiceException(e.getMessage());
//		}
//
//	}

	public List<Style> getAllStyles() throws ServiceException {
		// TODO Auto-generated method stub
		StyleDAO styleDAO = new StyleDAO();
		try {
			if(styleDAO.getAllStyle() != null) {
				return styleDAO.getAllStyle();
			}
		} catch (StyleDAOException e) {
			throw new ServiceException(e);
		}
		return null;
	}
	
	
   // delete Style
	public boolean deleteStyle(int designId) throws ServiceException {
		StyleDAO designDAO = new StyleDAO();

		try {
			StyleValidator.isValidStyleId(designId);
			return designDAO.deleteStyle(designId);
		} catch ( StyleDAOException e) {
			throw new ServiceException(e);
		}
	}
	
   // Update Style by barber using Style id
	
	public boolean updateStyle(Style style, int styleId) throws ServiceException  {
		StyleDAO styleDAO = new StyleDAO();
		try {
			if(style == null) {
				throw new InvalidStyleException("Style is null");
			}
			if(!styleDAO.isStyleExists(styleId)) {
				throw new ServiceException("Style with this style id does not exists");
			}
			StyleValidator.validateStyle(style);
			return styleDAO.updateStyle(style);
			
		}catch(InvalidStyleException  | StyleDAOException e) {
			throw new ServiceException(e);
		} 		
	}
}
