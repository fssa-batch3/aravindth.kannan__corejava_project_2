package com.fssa.sharpandclean.service;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.service.exception.ServiceException;

 class TestGetUserByEmail {

	@Test
	 void getUserSuccess() {
		UserService userSerive = new UserService();
		String useremail = "aravindth@gmail.com";
		try {
			User getUser = userSerive.getUser(useremail);
			assertTrue(getUser != null);
			System.out.println(getUser.toString());
		} catch (ServiceException e) {
		e.getMessage();

		}
	}

	@Test
	 void getUserFailed() {
		UserService userSerive = new UserService();
		String useremail = "aravin@gmail.com";
		try {
			User getUser = userSerive.getUser(useremail);
			assertFalse(getUser != null);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
	}

}
