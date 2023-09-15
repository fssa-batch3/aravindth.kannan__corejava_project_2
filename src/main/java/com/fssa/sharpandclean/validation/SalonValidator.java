package com.fssa.sharpandclean.validation;

import java.util.regex.Pattern;

import com.fssa.sharpandclean.model.Salon;
import com.fssa.sharpandclean.validation.exception.InvalidSalonException;

public class SalonValidator {

	  public static boolean validateSalon(Salon salon) throws InvalidSalonException {
	    	validateSalonNotNull(salon);
//	        validateSalonID(salon.getSalonId());
	        validateName(salon.getSalonName());
	        validateSalonExperience(salon.getSalonExperience());
	        validatePhoneNumber(salon.getSalonPhone());
	        validateAddress(salon.getSalonAddress());
	        validateEmail(salon.getSalonEmail());
	        validateAbout(salon.getSalonAbout());
	        validateArea(salon.getSalonArea());
	        validateImageURL(salon.getSalonURL(),"Profile photo URL is null or not valid");
	        validateImageURL(salon.getSalonSample1(), "sample image 1 photo URL is null or not valid");
	        validateImageURL(salon.getSalonSample2(), "sample image 2 photo URL is null or not valid");
	        validateImageURL(salon.getSalonSample3(), "sample image 3 photo URL is null or not valid");
	        return true;
	    }
	  
	  
	  public static boolean validateSalonExperience(String salonExperience) throws InvalidSalonException {
			
			if (salonExperience != null && salonExperience.trim().length() >= 10
					&& salonExperience.trim().length() <= 200) {
				return true;
			} else {
				throw new InvalidSalonException("The shop experience  is not valid.");
			}
			
		}
	  
	  public static boolean validateImageURL(String ImageUrl, String error) throws InvalidSalonException {
			
			if (ImageUrl == null || !Pattern.matches("^(https?|ftp)://.*$", ImageUrl)) {
				throw new InvalidSalonException(error);
			}
				return true;
		}

	    
	    public static boolean validateSalonNotNull(Salon salon) throws InvalidSalonException {
	        if (salon == null) {
	        	throw new InvalidSalonException("Salon is null");
	        }
	        return true;
	    }
	    
	    
	    public static void validateSalonID(int architectID) throws InvalidSalonException {
	        if (architectID < 0) {
	            throw new InvalidSalonException("Salon ID is invalid: Negative value");
	        }
	    }

	    
	    public static void validateName(String name) throws InvalidSalonException {
	    		
	    	System.out.println(name);
	    	
	        if (name == null || "".equals(name.trim())  ||!Pattern.matches("^[A-Za-z]\\w{2,29}$", name)) {
	            throw new InvalidSalonException("Salon name is not valid");
	        }
	    }

	    
	   
	    public static void validatePhoneNumber(String phoneNumber) throws InvalidSalonException {
	        if (phoneNumber == null || !Pattern.matches("^(\\+?91)?[6-9]\\d{9}$", phoneNumber)) {
	            throw new InvalidSalonException("salon Phone number is not valid");
	        }
	    }

	    
	    public static void validateAddress(String address) throws InvalidSalonException {
	        if (address == null || address.trim().isEmpty()) {
	            throw new InvalidSalonException("Salon address is null or empty");
	        }
	    }
	    
	    
	    public static void validateAbout(String about) throws InvalidSalonException {
	        if (about == null || about.trim().isEmpty()) {
	            throw new InvalidSalonException("About salon is null or empty");
	        }
	    }
	    
	    public static void validateArea(String area) throws InvalidSalonException {
	        if (area == null || area.trim().isEmpty()) {
	            throw new InvalidSalonException("About salon is null or empty");
	        }
	    }

	   
	    public static void validateEmail(String email) throws InvalidSalonException {
	        if (email == null || !Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
	            throw new InvalidSalonException("Email address is not valid");
	        }
	    }

	   
	 

	 

}
