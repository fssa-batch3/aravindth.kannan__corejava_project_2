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
	
//	 get all  styles for user view.
	public List<Style> getAllStyles() throws ServiceException {
		StyleDAO styleDAO = new StyleDAO();
		try {
			if(styleDAO.getAllStyle() != null) {
				return styleDAO.getAllStyle();
			}
		} catch (StyleDAOException e) {
			throw new ServiceException("invalid query for get All Styles.");
		}
		return null;
	}
	
      //	 get all  styles for salon view.
	public List<Style> getStylesByEmail(String styleEmail) throws ServiceException {
		StyleDAO styleDAO = new StyleDAO();
		try {
			if(styleDAO.getStyleEmail(styleEmail) != null) {
				return styleDAO.getStyleEmail(styleEmail);
			}
		} catch (StyleDAOException e) {
			throw new ServiceException("invalid query for get  Styles by email");
		}
		return null;
	}
	
	
        //	 get all  styles for style update.
	public Style getStylesById(int styleId) throws ServiceException {
		StyleDAO styleDAO = new StyleDAO();
		try {
			if(styleDAO.getStyleById(styleId) != null) {
				return styleDAO.getStyleById(styleId);
			}
		} catch (StyleDAOException e) {
			throw new ServiceException("invalid query for get  Styles by style Id");
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
			throw new ServiceException("Delete Style details is not valid.");
		}
	}
	
   // Update Style by barber using Style id
	
	public boolean updateStyle(Style style) throws ServiceException  {
		StyleDAO styleDAO = new StyleDAO();
		try {
			if(style == null) {
				throw new InvalidStyleException("Style is null");
			}
			if(!styleDAO.isStyleExists(style.getHaircutId())) {
				throw new ServiceException("Style with this style id does not exists");
			}
			StyleValidator.validateStyle(style);
			return styleDAO.updateStyle(style);
			
		}catch(InvalidStyleException  | StyleDAOException e) {
			e.printStackTrace();
			throw new ServiceException("Update style details i not valid.");
		} 		
	}
}
