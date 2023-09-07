package com.fssa.sharpandclean.validation;


import java.util.regex.Matcher;


import java.util.regex.Pattern;

import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.validation.exception.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {
		if (user != null && validateName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail()) && validatePhoneNumber(user.getPhonenumber())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}
	

	// check the username valid or not.
	public static boolean validateName(String name) {
		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		boolean isMatch = matcher.matches();
		if (isMatch) {
			System.out.println("The user name is valid.");
		} else {
			System.out.println("The user name is not valid");
		}

		return isMatch;
	}

	// check the password valid or not.

	public static boolean validatePassword(String password) {
		if (password == null)
			return false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		boolean isMatch = Pattern.matches(patternString, password);

		if (isMatch) {
			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return isMatch;
	}

	// check the email valid or not.

	public static boolean validateEmail(String email) {
		if (email == null)
			return false;

		String regex = "^.*@.*\\..*$";
		boolean isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;
	}

	// check the phone number valid or not.

	public static boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null)
			return false;

		String regex = "^\\+?\\d{1,4}-?\\d{5,14}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			System.out.println("The phone number is: Valid");
		} else {
			System.out.println("The phone number is: Invalid");
		}

		return isMatch;
	}
	
	// check the delete user valid or not.


	public static boolean validateDeleteUser(User user) throws InvalidUserException {
		if (user != null  && validateEmail(user.getEmail())) {
			System.out.println("User deletion details are valid.");
			return true;
		} else {
			throw new InvalidUserException("Invalid user details for deletion");
		}
	}
}