package com.fssa.sharpandclean.service;

import java.util.List;

import com.fssa.sharpandclean.dao.SalonDAO;
import com.fssa.sharpandclean.dao.exception.SalonDAOException;
import com.fssa.sharpandclean.model.Salon;
import com.fssa.sharpandclean.model.SalonBook;
import com.fssa.sharpandclean.service.exception.ServiceException;
import com.fssa.sharpandclean.validation.BookSalonValidator;
import com.fssa.sharpandclean.validation.SalonValidator;
import com.fssa.sharpandclean.validation.exception.InvalidSalonBookException;
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
	
	// method to get salon by salon Id
	
	public Salon getSalonBySalonId(int salonId ) throws ServiceException {
     try {
		    SalonDAO salonDAO = new SalonDAO();
		 // Retrieve the salon by salonId from the SalonDAO
		    return salonDAO.getSalonById(salonId);
		}catch(SalonDAOException e) {
			throw new ServiceException(e);
		}	
    }
	
	
	// method for booking salon.
	
	public boolean bookingSalon(SalonBook salonBook) throws ServiceException {
		try {
			SalonDAO salonDAO = new SalonDAO();
			if(salonBook == null) {
	    		throw new InvalidSalonBookException("salonbook object is null");
	    	}
			if(salonDAO.isSalonAlreadyBooked(salonBook)) {
				throw new InvalidSalonBookException("This appointment is already booked");
			}
			BookSalonValidator.validateSalonBook(salonBook); // Implement SalonValidator as needed to validate salon details.
	        return salonDAO.bookSalon(salonBook);
		}catch(SalonDAOException | InvalidSalonBookException e) {
			e.printStackTrace();
			throw new ServiceException("Error in booking salon method");
		}	
	
	}
	
//	get all salons for user view.
	public List<SalonBook> getAllSalonBookingForUser(String userEmail) throws ServiceException{
		
		SalonDAO salonDAO = new SalonDAO();
		try {
			
			if(salonDAO.bookSalonListForUser(userEmail) != null) {
				return salonDAO.bookSalonListForUser(userEmail);
			}
		}catch(SalonDAOException e) {
			e.printStackTrace();
			throw new ServiceException("Invalid query for get All booking salons.");
		}
		return null;
		
	}
	
	
      //	get all salons for salon view.
	public List<SalonBook> getAllSalonBookingForSalon(String salonEmail) throws ServiceException{
		SalonDAO salonDAO = new SalonDAO();
		try {
			
			if(salonDAO.bookSalonListForSalon(salonEmail) != null) {
				return salonDAO.bookSalonListForSalon(salonEmail);
			}
		}catch(SalonDAOException e) {
			e.printStackTrace();
			throw new ServiceException("Invalid query for get All booking salons.");
		}
		return null;
		
	}
	
}


