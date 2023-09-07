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
	
	 public static boolean validateStyleName(String haircutName) throws InvalidStyleException {
	        boolean match = false;
	        if (haircutName == null)
	            return false;
	        String regex = "^[a-zA-Z]+( [a-zA-Z]+){0,3}$";
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
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(haircutEmail);
	        isMatch = m.matches();
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

	public static boolean isValidStyleId(int styleId) {
		boolean match = false;
		String styleID = Integer.toString(styleId);
		String regex = "\\d+";
		match = Pattern.matches(regex, styleID);
		return match;
	}

}
