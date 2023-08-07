package SharpAndClean.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;
import SharpAndClean.module.HairService;
import SharpAndClean.validation.exception.InvalidHairServiceException;
public class HairserviceValidator {

	public static boolean validateHairService(HairService hairservice) throws InvalidHairServiceException {
		if(hairservice != null && validateHairServiceName(hairservice.getHaircutName()) && validateHairServiceEmail(hairservice.getHaircutEmail()) 
				  && validateHairServiceURL(hairservice.getHaircutUrl()) && validateHairServiceAbout(hairservice.getHaircutAbout()) && validateHairServiceType(hairservice.getHaircutType())) {
			return true;
		}else {
			throw new InvalidHairServiceException("Hair service details not valid");
		}
		
		
	}
	
	 public static boolean validateHairServiceName(String haircutName) {
	        boolean match = false;
	        if (haircutName == null)
	            return false;
	        String regex = "^[A-Za-z]\\w{2,29}$";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(haircutName);
	        match = m.matches();
	        if (match) {
	            System.out.println("The user name is valid.");
	        } else {
	            System.out.println("The user name is not valid");
	        }
	        return match;
	    }
	 
	 public static boolean validateHairServiceEmail(String haircutEmail) {
	        boolean isMatch = false;
	        if (haircutEmail == null)
	            return false;
	        String regex = "^.*@.*\\..*$";
	        isMatch = Pattern.matches(regex, haircutEmail);
	        if (isMatch) {
	            System.out.println("The email address is: Valid");
	        } else {
	            System.out.println("The email address is: Invalid");
	        }
	        return isMatch;
	    }
	 
	 public static boolean validateHairServiceURL(String haircutUrl) {
		 try {
			 new URL(haircutUrl).toURI();
		 }
		 catch(Exception e) {
			 System.out.println(e);
			 return false;
		 }
		 
		 return true;
		 
	 }
	 
	 public static boolean validateHairServiceAbout(String haircutAbout) {
		
		 if(haircutAbout == null) {
			 return false;
		 }else {
			 return true; 
		 } 
	 }
	 
	 public static boolean validateHairServiceType(String haircutType) {
			
		 if(haircutType == null) {
			 return false;
		 }else {
			 return true; 
		 } 
	 }
}
