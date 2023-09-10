package com.fssa.sharpandclean.service;

import java.util.List;


import com.fssa.sharpandclean.dao.BarberDAO;
import com.fssa.sharpandclean.dao.exception.BarberDAOException;
import com.fssa.sharpandclean.model.Barber;
import com.fssa.sharpandclean.service.exception.ServiceException;
import com.fssa.sharpandclean.validation.BarberValidator;
import com.fssa.sharpandclean.validation.exception.InvalidBarberException;
 
public class BarberService {

	// register barber method.
	public boolean registerBarber(Barber barber) throws  ServiceException {
		BarberDAO barberDAO = new BarberDAO();
		try { 
			if(barber == null) {
				throw  new InvalidBarberException("Barber is null");
			}
			
			if(barberDAO.isEmailExists(barber.getBarberEmail())) {
				throw new ServiceException("Barber with this email is aleady exists");
			}
			
			BarberValidator.validateBarber(barber);
			return barberDAO.createBarber(barber);
		}catch(InvalidBarberException | BarberDAOException e) {
			throw new ServiceException("Register details is not valid so registration failed.");
		}
		
	}
	
	// Method to Login a barber.
	public boolean loginBarber(Barber barber, String barberEmail) throws ServiceException {
		try {
			BarberValidator.validateBarberEmail(barberEmail);
			BarberValidator.validateBarberPassword(barber.getBarberPassword());

			BarberDAO barberDAO = new BarberDAO();

			if (!barberDAO.isEmailExists(barberEmail)) {
				throw new ServiceException("Before logging in, you have to register");
			}

			if (barberDAO.login(barber, barberEmail)) {
				
				return true;
			} else {
				return false;
			}
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(e.getLocalizedMessage());
		}
	}
	
//	get all barbers for user view.
	public List<Barber> getAllBarber() throws ServiceException{
		
		BarberDAO barberDAO = new BarberDAO();
		try {
			if(barberDAO.listAllBarber() != null) {
				return barberDAO.listAllBarber();
			}
		}catch(BarberDAOException e) {
			throw new ServiceException("Invalid query for get All Barbers.");
		}
		return null;
		
	}
	
	// method for update barber.
		public boolean updateBarber(Barber barber)throws ServiceException {
			
			BarberDAO barberDAO = new BarberDAO();
			
			try {
				if(barber == null) {
					throw new InvalidBarberException("Barber is null");
				}
				
				BarberValidator.validateBarber(barber);
				return barberDAO.updateBarber(barber);
			} catch(InvalidBarberException | BarberDAOException e) {
				throw new ServiceException ("Update Barber details is not valid, so update barber failed.");
			}
			
			
		}
		
		
		// method to delete a barber.
		
		public boolean deleteBarber(String barberEmail) throws ServiceException {
			BarberDAO  barberDAO = new BarberDAO();
			try {
				if(barberEmail == null) {
					throw new InvalidBarberException("Barber email is null.");
				}
				if(barberDAO.isEmailExists(barberEmail)) {
					BarberValidator.validateBarberEmail(barberEmail);
					return barberDAO.deleteBarber(barberEmail);
				}
			}catch(InvalidBarberException | BarberDAOException e) {
				throw new ServiceException(e);
			}
			return false;
			
		}
	
	
	
	
}
