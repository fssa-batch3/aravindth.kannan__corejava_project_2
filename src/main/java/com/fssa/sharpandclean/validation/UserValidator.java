package com.fssa.sharpandclean.validation;


import java.util.regex.Matcher;


import java.util.regex.Pattern;

import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.validation.exception.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {
		
		
		validateName(user.getUsername());
		validatePassword(user.getPassword());
	    validateEmail(user.getEmail());
	    validatePhoneNumber(user.getPhonenumber());
			return true;
		} 
	
	

	// check the username valid or not.
	public static boolean validateName(String name) throws InvalidUserException {
		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		boolean isMatch = matcher.matches();
		if (isMatch) {
			return isMatch;
		} else {
			throw new InvalidUserException("The user name not valid");
		}

		
	}

	// check the password valid or not.

	public static boolean validatePassword(String password) throws InvalidUserException {
		if (password == null)
			return false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		boolean isMatch = Pattern.matches(patternString, password);

		if (isMatch) {
			return isMatch;
		} else {
			throw new InvalidUserException("The user password is not valid");
		}

		
	}
 
	// check the email valid or not.

	public static boolean validateEmail(String email) throws InvalidUserException {
		if (email == null)
			return false;

		String emailRegEx = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		boolean isMatch = Pattern.compile(emailRegEx).matcher(email).matches();
		
		if (isMatch) {
			return isMatch;
		} else {
			throw new InvalidUserException("The email address is: Invalid");
		}
		
	}

	// check the phone number valid or not.

	public static boolean validatePhoneNumber(String phoneNumber) throws InvalidUserException {
		if (phoneNumber == null)
			return false;

		String regex = "^\\+?\\d{1,4}-?\\d{5,14}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			return isMatch;
		} else {
			throw new InvalidUserException("The phone number is: Invalid");
		}

		
	}
	
	// check the delete user valid or not.


	public static boolean validateDeleteUser(User user) throws InvalidUserException {
		if (user != null  && validateEmail(user.getEmail())) {
			
			return true;
		} else {
			throw new InvalidUserException("Invalid user details for deletion");
		}
	}
}