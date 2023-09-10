package com.fssa.sharpandclean.validation;

import java.util.regex.Matcher;


import java.util.regex.Pattern;

import com.fssa.sharpandclean.model.Style;
import com.fssa.sharpandclean.validation.exception.InvalidStyleException;
public class StyleValidator {

	// validate full attributes of single style.
	public static boolean validateStyle(Style style) throws InvalidStyleException {
		if(style != null && validateStyleName(style.getHaircutName()) && validateStyleEmail(style.getHaircutEmail())
				  && validateStyleImageURL(style.getHaircutUrl()) && validateStyleDetail(style.getHaircutAbout()) && validateStyleType(style.getHaircutType())) {
			return true;
			
		}else {
			throw new InvalidStyleException("Hair Style details not valid");
		}	
	}
	
	// check the style name is valid or not.
	 public static boolean validateStyleName(String haircutName) throws InvalidStyleException {
	        boolean match = false;
	        if (haircutName == null)
	            return false;
	        String regex = "^[a-zA-Z]+( [a-zA-Z]+){0,3}$";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(haircutName);
	        match = m.matches();
	        if (match) {
	        	return match;
	        } else {
	            throw new InvalidStyleException("The hair Style name is not valid");
	        }
	        
	    }
	// check the style email is valid or not.
	 public static boolean validateStyleEmail(String haircutEmail)throws InvalidStyleException {
		 
	        boolean isMatch = false; 
	        if (haircutEmail == null)
	            return false;
	        
	        String emailRegEx = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
			 isMatch = Pattern.compile(emailRegEx).matcher(haircutEmail).matches();
	        if (isMatch) {
	        	return isMatch;
	        } else {
	        	
	        	throw new InvalidStyleException("The hair Style email address is: Invalid");
	        }
	        
	    }
	 
	// check the style URL is valid or not.
      public static boolean validateStyleImageURL(String haircutimageUrl) throws InvalidStyleException {
		boolean match = false;
		if (haircutimageUrl == null)
            return false;

		String regex = "^(https?|ftp)://.*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(haircutimageUrl);
		match = m.matches();
		if (match) {
			return match;
		} else {
			throw new InvalidStyleException("The Style image URL is not valid.");
		}

		
	}
      
   // check the style detail is valid or not.
      public static boolean validateStyleDetail(String styleDetail) throws InvalidStyleException {
  		boolean match = false;

  		int lengthOfWords = 20;

  		if (styleDetail != null && styleDetail.trim().length() >= lengthOfWords
  				&& styleDetail.trim().length() <= 400) {
  			match = true;
  			return match;
  		} else {
  			throw new InvalidStyleException("The hair Style detail is not valid.");
  		}
  		
  	}
      
   // check the style type is valid or not.
	 public static boolean validateStyleType(String haircutType) throws InvalidStyleException {
		 boolean match = false;
		 if(haircutType == null) {
			 match = false;
			 throw new InvalidStyleException("The hairservice type is null");
		 }else if(haircutType.equals("Hair straightening") || haircutType.equals("Haircut") || haircutType.equals("Hair coloring") || haircutType.equals("Facials") || haircutType.equals("Shaves") || haircutType.equals("Beard trim")) {
			 match = true; 
			 return match;
		 } else {
			 
			 throw new InvalidStyleException("The hair Style type is not valid.");
		 }
		
	 }
	 
	// check the style id is valid or not.
	public static boolean isValidStyleId(int styleId) {
		boolean match = false;
		String styleID = Integer.toString(styleId);
		String regex = "\\d+";
		match = Pattern.matches(regex, styleID);
		return match;
	}

}
