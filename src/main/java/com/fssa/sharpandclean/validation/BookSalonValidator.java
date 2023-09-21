package com.fssa.sharpandclean.validation;

import java.util.regex.Pattern;

import com.fssa.sharpandclean.model.SalonBook;
import com.fssa.sharpandclean.validation.exception.InvalidSalonBookException;

public class BookSalonValidator {
	
	public static boolean validateSalonBook(SalonBook salonBook) throws InvalidSalonBookException {
		validateSalonBookNotNull(salonBook);
		isValidService(salonBook.getBookService());
		isValidDate(salonBook.getBookDate());
		validateUserPhoneNumber(salonBook.getBookUserPhone());
		isValidTime(salonBook.getBookTime());
		validateUserName(salonBook.getBookUserName());
        validateName(salonBook.getSalonName());
        validateSalonExperience(salonBook.getSalonEx());
        validatePhoneNumber(salonBook.getSalonPhone());
        validateAddress(salonBook.getSalonAddress());
        validateEmail(salonBook.getSalonEmail());
        validateAbout(salonBook.getSalonAbout());
        validateArea(salonBook.getSalonArea());
        validateImageURL(salonBook.getSalonProfile());
		
		return true;
		
	}
	
	public static boolean isValidService(String time)throws InvalidSalonBookException {
		 if(time == null) {
			 throw new InvalidSalonBookException("The Service is null");
		 }
      
		return true;
  }
	public static boolean isValidTime(String time)throws InvalidSalonBookException {
		 if(time == null) {
			 throw new InvalidSalonBookException("The Time is null");
		 }
       
		return true;
   }
	public static boolean isValidDate(String date)throws InvalidSalonBookException {
		 if(date == null) {
			 throw new InvalidSalonBookException("The date is null");
		 }
        
		return true;
    }
	
	 public static boolean validateSalonExperience(String salonExperience) throws InvalidSalonBookException {
			
			if (salonExperience != null && salonExperience.trim().length() >= 10
					&& salonExperience.trim().length() <= 200) {
				return true;
			} else {
				throw new InvalidSalonBookException("The shop experience  is not valid.");
			}
			
		}
	  
	  public static boolean validateImageURL(String ImageUrl) throws InvalidSalonBookException {
			
			if (ImageUrl == null || !Pattern.matches("^(https?|ftp)://.*$", ImageUrl)) {
				throw new InvalidSalonBookException("The salon profile url is not valid");
			}
				return true;
		}

	    
	    public static boolean validateSalonBookNotNull(SalonBook salonbook) throws InvalidSalonBookException {
	        if (salonbook == null) {
	        	throw new InvalidSalonBookException("SalonBook is null");
	        }
	        return true;
	    }
	    
	    
	    public static void validateSalonID(int architectID) throws InvalidSalonBookException {
	        if (architectID < 0) {
	            throw new InvalidSalonBookException("Salon ID is invalid: Negative value");
	        }
	    }

        public static void validateUserName(String name) throws InvalidSalonBookException {
	    		
	    	
	        if (name == null || "".equals(name.trim())  ||!Pattern.matches("^[A-Za-z]\\w{2,29}$", name)) {
	            throw new InvalidSalonBookException("Salon user name is not valid");
	        }
	    }
	    
	    public static void validateName(String name) throws InvalidSalonBookException {
	    		
	    	
	        if (name == null || "".equals(name.trim())  ||!Pattern.matches("^[A-Za-z]\\w{2,29}$", name)) {
	            throw new InvalidSalonBookException("Salon name is not valid");
	        }
	    }

	    public static void validateUserPhoneNumber(String phoneNumber) throws InvalidSalonBookException {
	        if (phoneNumber == null || !Pattern.matches("^(\\+?91)?[6-9]\\d{9}$", phoneNumber)) {
	            throw new InvalidSalonBookException("salon Phone number is not valid");
	        }
	    }
	   
	    public static void validatePhoneNumber(String phoneNumber) throws InvalidSalonBookException {
	        if (phoneNumber == null || !Pattern.matches("^(\\+?91)?[6-9]\\d{9}$", phoneNumber)) {
	            throw new InvalidSalonBookException("salon Phone number is not valid");
	        }
	    }

	    
	    public static void validateAddress(String address) throws InvalidSalonBookException {
	        if (address == null || address.trim().isEmpty()) {
	            throw new InvalidSalonBookException("Salon address is null or empty");
	        }
	    }
	    
	    
	    public static void validateAbout(String about) throws InvalidSalonBookException {
	        if (about == null || about.trim().isEmpty()) {
	            throw new InvalidSalonBookException("About salon is null or empty");
	        }
	    }
	    
	    public static void validateArea(String area) throws InvalidSalonBookException {
	        if (area == null || area.trim().isEmpty()) {
	            throw new InvalidSalonBookException("About salon is null or empty");
	        }
	    }

	   
	    public static void validateEmail(String email) throws InvalidSalonBookException {
	        if (email == null || !Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
	            throw new InvalidSalonBookException("Email address is not valid");
	        }
	    }


}
