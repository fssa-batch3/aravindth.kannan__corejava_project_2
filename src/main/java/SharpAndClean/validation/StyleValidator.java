package SharpAndClean.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.net.URL;
import SharpAndClean.module.Style;
import SharpAndClean.validation.exception.InvalidStyleException;
public class StyleValidator {

	public static boolean validateHairService(Style hairservice) throws InvalidStyleException {
		if(hairservice != null && validateHairServiceName(hairservice.getHaircutName()) && validateHairServiceEmail(hairservice.getHaircutEmail()) 
				  && validateHairServiceURL(hairservice.getHaircutUrl()) && validateHairServiceAbout(hairservice.getHaircutAbout()) && validateHairServiceType(hairservice.getHaircutType())) {
			return true;
		}else {
			throw new InvalidStyleException("Hair service details not valid");
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
	            System.out.println("The hair service name is valid.");
	        } else {
	            System.out.println("The hair service name is not valid");
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
		 if(haircutUrl == null) {
			 return false;
		 }else {
			 return true; 
		 } 
		 
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
