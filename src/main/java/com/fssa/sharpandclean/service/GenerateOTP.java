package com.fssa.sharpandclean.service;

import java.util.Random;

public class GenerateOTP {
	
	public String generateOTP() {
        String digits = "1234567890";
        StringBuilder OTP = new StringBuilder();

        Random random = new Random();
        for   (int i = 0; i < 5; i++) {
            int index = random.nextInt(digits.length());
            OTP.append(digits.charAt(index));
        }

        return OTP.toString();
    }

}
