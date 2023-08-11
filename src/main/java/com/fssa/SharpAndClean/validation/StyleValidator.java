package com.fssa.SharpAndClean.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.SharpAndClean.module.Style;
import com.fssa.SharpAndClean.validation.exception.InvalidStyleException;
public class StyleValidator {

	public static boolean validateHairService(Style hairservice) throws InvalidStyleException {
		if(hairservice != null && validateStyleName(hairservice.getHaircutName()) && validateStyleEmail(hairservice.getHaircutEmail()) 
				  && validateStyleImageURL(hairservice.getHaircutUrl()) && validateStyleDetail(hairservice.getHaircutAbout()) && validateStyleType(hairservice.getHaircutType())) {
			return true;
		}else {
			throw new InvalidStyleException("Hair Style details not valid");
		}
		
		
	}
	
	 public static boolean validateStyleName(String haircutName) throws InvalidStyleException {
	        boolean match = false;
	        if (haircutName == null)
	            return false;
	        String regex = "^[A-Za-z]\\w{2,29}$";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(haircutName);
	        match = m.matches();
	        if (match) {
	            System.out.println("The hair Style name is valid.");
	        } else {
	            throw new InvalidStyleException("The hair Style name is not valid");
	        }
	        return match;
	    }
	 
	 public static boolean validateStyleEmail(String haircutEmail)throws InvalidStyleException {
	        boolean isMatch = false;
	        if (haircutEmail == null)
	            return false;
	        String regex = "^.*@.*\\..*$";
	        isMatch = Pattern.matches(regex, haircutEmail);
	        if (isMatch) {
	            System.out.println("The hair Style email address is: Valid");
	        } else {
	        	
	        	throw new InvalidStyleException("The hair Style email address is: Invalid");
	        }
	        return isMatch;
	    }
	 


      public static boolean validateStyleImageURL(String haircutimageUrl) throws InvalidStyleException {
		boolean match = false;
		if (haircutimageUrl == null)
            return false;

		String regex = "^(https?|ftp)://.*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(haircutimageUrl);
		match = m.matches();
		if (match) {
			System.out.println("The Style image URL is valid.");
		} else {
			throw new InvalidStyleException("The Style image URL is not valid.");
		}

		return match;
	}
	 
      public static boolean validateStyleDetail(String styleDetail) throws InvalidStyleException {
  		boolean match = false;

  		int lengthOfWords = 20;

  		if (styleDetail != null && styleDetail.trim().length() >= lengthOfWords
  				&& styleDetail.trim().length() <= 400) {
  			match = true;
  			System.out.println("The hair Style detail is valid.");
  		} else {
  			throw new InvalidStyleException("The hair Style detail is not valid.");
  		}
  		return match;
  	}
	 
	 public static boolean validateStyleType(String haircutType) throws InvalidStyleException {
		 boolean match = false;
		 if(haircutType == null) {
			 match = false;
			 System.out.println("The hair Style type is emty");
		 }else if(haircutType.equals("Hair straightening") | haircutType.equals("Haircut") | haircutType.equals("Hair coloring") | haircutType.equals("Facials") | haircutType.equals("Shaves") | haircutType.equals("Beard trim")) {
			 System.out.println("The hair Style type is valid");
			 match = true; 
		 } else {
			 
			 throw new InvalidStyleException("The hair Style type is not valid.");
		 }
		return match;
	 }
}
