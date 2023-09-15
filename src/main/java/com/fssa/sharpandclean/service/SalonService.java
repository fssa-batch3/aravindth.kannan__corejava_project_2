package com.fssa.sharpandclean.service;
import java.util.List;

import com.fssa.sharpandclean.dao.BarberDAO;
import com.fssa.sharpandclean.dao.SalonDAO;
import com.fssa.sharpandclean.dao.exception.BarberDAOException;
import com.fssa.sharpandclean.dao.exception.SalonDAOException;
import com.fssa.sharpandclean.model.Barber;
import com.fssa.sharpandclean.model.Salon;
import com.fssa.sharpandclean.service.exception.ServiceException;
import com.fssa.sharpandclean.validation.SalonValidator;
import com.fssa.sharpandclean.validation.exception.InvalidSalonException;

public class SalonService {
	
	// Register salon method.
	public boolean registerSalon(Salon salon) throws ServiceException {
	    SalonDAO salonDAO = new SalonDAO();
	    
	    try {
	    	if(salon == null) {
	    		throw new InvalidSalonException("salon object is null");
	    	}
	    	if(salonDAO.isSalonEmailExists(salon.getSalonEmail())) {
				throw new ServiceException("Salon with this email is aleady exists");
			}
	        SalonValidator.validateSalon(salon); // Implement SalonValidator as needed to validate salon details.
	        return salonDAO.createSalon(salon);
	    } catch (InvalidSalonException | SalonDAOException e) {
	    	System.out.println(e.getMessage());
	        throw new ServiceException("Registration details are not valid, so registration failed.");
	    }
	}
	
//	get all salons for user view.
	public List<Salon> getAllSalon() throws ServiceException{
		
		SalonDAO salonDAO = new SalonDAO();
		try {
			if(salonDAO.listAllSalon() != null) {
				return salonDAO.listAllSalon();
			}
		}catch(SalonDAOException e) {
			throw new ServiceException("Invalid query for get All salons.");
		}
		return null;
		
	}

}
