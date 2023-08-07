package SharpAndClean.service;

import SharpAndClean.module.*;
import SharpAndClean.service.exception.ServiceException;

import java.sql.SQLException;

import SharpAndClean.dao.*;
import SharpAndClean.validation.*;
import SharpAndClean.validation.exception.InvalidUserException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUser(user);

			return userDAO.register(user);
		} catch (InvalidUserException | SQLException e) {
			throw new ServiceException(e);
		}

	}

	public boolean loginUser(User user) throws ServiceException {

		try {
			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.login(user)) {
				System.out.println(user.getEmail() + " Successfully logged in");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ServiceException(e.getLocalizedMessage());
		}

	}

	public static void main(String[] args) throws ServiceException {
		UserService reg = new UserService();

		User user2 = new User("aravindth@gmail.com", "Akkam4321@");

		reg.loginUser(user2);
	}

}