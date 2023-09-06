package com.fssa.sharpandclean.service;



import com.fssa.sharpandclean.dao.UserDAO;
import com.fssa.sharpandclean.dao.exception.DAOException;
import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.service.exception.ServiceException;
import com.fssa.sharpandclean.validation.UserValidator;
import com.fssa.sharpandclean.validation.exception.InvalidUserException;



public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			if (user == null) {
				throw new InvalidUserException("User is null");
			}

			if (userDAO.isEmailExists(user.getEmail())) {
				throw new ServiceException("User with this email already exists");
			}

			UserValidator.validateUser(user);
			return userDAO.register(user);
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	public boolean loginUser(User user, String email) throws ServiceException {
		try {
			UserValidator.validateEmail(email);
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();

			if (!userDAO.isEmailExists(email)) {
				throw new ServiceException("Before logging in, you have to register");
			}

			if (userDAO.login(user, email)) {
				System.out.println(email + " Successfully logged in");
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

	public boolean updateUser(User user, String email) throws ServiceException  {
		UserDAO userDAO = new UserDAO();
		
		try {
			if (user == null) {
				throw new InvalidUserException("User is null");
			}

			UserValidator.validateUser(user);
			return userDAO.updateUser(user);
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	 public boolean deleteUser(String email) throws ServiceException {
	        UserDAO userDAO = new UserDAO();
	        try {
	            if (email == null) {
	                throw new InvalidUserException("User is null");
	            }

	            if (userDAO.isEmailExists(email)) {
	            	UserValidator.validateEmail(email);
		            return userDAO.deleteUser(email); 
	            }

	            
	        } catch (InvalidUserException | DAOException e) {
	            throw new ServiceException(e);
	        }
			return false;
	    }
}