package com.fssa.sharpandclean.service;
import java.util.Base64;

import com.fssa.sharpandclean.dao.UserDAO;
import com.fssa.sharpandclean.dao.exception.DAOException;
import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.service.exception.ServiceException;
import com.fssa.sharpandclean.utils.PasswordUtil;
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
			
		      byte[] salt = PasswordUtil.generateSalt();
	          byte[] derivedKey = PasswordUtil.deriveKey(user.getPassword(), salt);
	          user.setSalt(Base64.getEncoder().encodeToString(salt));
	          user.setPassword(Base64.getEncoder().encodeToString(derivedKey));
	            
			 return userDAO.register(user);
			 
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	public boolean loginUser(User user) throws ServiceException {
		try {
			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();

			if (!userDAO.isEmailExists(user.getEmail())) 
				throw new ServiceException("Before logging in, you have to register");
		

//			if (userDAO.login(user)) {
//				System.out.println(user.getEmail() + " Successfully logged in");
//				return true;
//			} else {
//				return false;
//			}
			
			return userDAO.login(user);
		} catch (ServiceException | InvalidUserException | DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} 
	}

	public boolean updateUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			if (user == null) {
				throw new InvalidUserException("User is empty");
			}

			UserValidator.validateUser(user);
			return userDAO.updateUser(user);
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException("User update details is not valid, so update user failed");
		}
	}



	// Method to view profile details for user

	public User getUser(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		
		User loggedUser = null;
		try {
			UserValidator.validateEmail(email);
			loggedUser = userDAO.getUserByEmail(email);
			
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
		return loggedUser;
	}
}