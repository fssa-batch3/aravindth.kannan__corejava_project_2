package com.fssa.sharpandclean.validation;

import java.util.regex.Pattern;

import com.fssa.sharpandclean.model.Barber;

import com.fssa.sharpandclean.validation.exception.InvalidBarberException;

import java.util.regex.Matcher;

public class BarberValidator {

	// full barber details is valid or not method.
	public static boolean validateBarber(Barber barber) throws InvalidBarberException {
		if (barber != null && validateBarberName(barber.getBarberName()) && validateBarberEmail(barber.getBarberEmail())
				&& validateBarberImageURL(barber.getBarberProfile()) && validateBarberAddress(barber.getBarberAddress())
				&& validateBarberAbout(barber.getBarberAbout())
				&& validateBarberPassword(barber.getBarberPassword())
				&& validateBarberExperience(barber.getBarberExperience())
				&& validateBarberPhoneNumber(barber.getBarberPhone())) {
			return true;
		}else {
			throw new InvalidBarberException("Barber details is not valid");
		}
		
	}

	// check barber name is valid or not.
	public static boolean validateBarberName(String barberName) {
		// check barber name is null
		if (barberName == null)
			return false;
		// check barber name in this regex.
		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(barberName);
		boolean isMatch = matcher.matches();
		if (isMatch) {
			System.out.println("The Barber name is valid");
		} else {
			System.out.println("The Barber name is not valid");
		}
		return isMatch;
	}
	
	// check barber password is valid or not.
	
	public static boolean validateBarberPassword(String barberPassword) {
		if (barberPassword == null)
			return false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		boolean isMatch = Pattern.matches(patternString, barberPassword);

		if (isMatch) {
			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return isMatch;
	}

	// check barber email is valid or not.
	public static boolean validateBarberEmail(String barberEmail) {
		if (barberEmail == null)
			return false;

		String emailRegEx = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		boolean isMatch = Pattern.compile(emailRegEx).matcher(barberEmail).matches();
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;
	}

	// check barber image URL is valid or not.
	public static boolean validateBarberImageURL(String BarberImageUrl) throws InvalidBarberException {
		boolean match = false;
		if (BarberImageUrl == null)
			return false;

		String regex = "^(https?|ftp)://.*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(BarberImageUrl);
		match = m.matches();
		if (match) {
			System.out.println("The barber image URL is valid.");
		} else {
			throw new InvalidBarberException("The barber image URL is not valid.");
		}

		return match;
	}

	// check barber Address is valid or not.
	public static boolean validateBarberAddress(String barberAddress) throws InvalidBarberException {
		boolean match = false;

		int lengthOfWords = 15;

		if (barberAddress != null && barberAddress.trim().length() >= lengthOfWords
				&& barberAddress.trim().length() <= 300) {
			match = true;
			System.out.println("The Barber address  is valid.");
		} else {
			throw new InvalidBarberException("The Barber address  is not valid.");
		}
		return match;
	}

	// check barber about is valid or not.
	public static boolean validateBarberAbout(String barberAbout) throws InvalidBarberException {
		boolean match = false;

		int lengthOfWords = 30;

		if (barberAbout != null && barberAbout.trim().length() >= lengthOfWords && barberAbout.trim().length() <= 500) {
			match = true;
			System.out.println("The Barber about  is valid.");
		} else {
			throw new InvalidBarberException("The Barber about  is not valid.");
		}
		return match;
	}

	// check barber experience is valid or not.
	public static boolean validateBarberExperience(String barberExperience) throws InvalidBarberException {
		boolean match = false;

		int lengthOfWords = 10;

		if (barberExperience != null && barberExperience.trim().length() >= lengthOfWords
				&& barberExperience.trim().length() <= 200) {
			match = true;
			System.out.println("The Barber experience  is valid.");
		} else {
			throw new InvalidBarberException("The Barber experience  is not valid.");
		}
		return match;
	}
	// check barber phone number is valid or not.

	public static boolean validateBarberPhoneNumber(String barberPhone) {
		if (barberPhone == null)
			return false;

		String regex = "^\\+?\\d{1,4}-?\\d{5,14}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(barberPhone);
		boolean isMatch = matcher.matches();

		if (isMatch) {
			System.out.println("The phone number is: Valid");
		} else {
			System.out.println("The phone number is: Invalid");
		}

		return isMatch;
	}

	// check barber delete data is valid or not.
 
	public static boolean validateDeleteBarber(Barber barber) throws InvalidBarberException {
		if (barber != null && validateBarberEmail(barber.getBarberEmail())) {
			System.out.println("Barber deletion details are valid.");
			return true;
		} else {
			throw new InvalidBarberException("Invalid Barber details for deletion");
		}
	}
	
	// check barber is is not valid.
	public static boolean isValidBarberId(int barberId) {
		boolean match = false;
		String styleID = Integer.toString(barberId);
		String regex = "\\d+";
		match = Pattern.matches(regex, styleID);
		return match;
	}

}
