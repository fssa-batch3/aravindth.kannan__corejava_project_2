package com.fssa.sharpandclean.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.service.exception.ServiceException;

public class TestGetUserByEmail {

	@Test
	public void getUserSuccess() {
		UserService userSerive = new UserService();
		String useremail = "aravindth@gmail.com";
		try {
			User getUser = userSerive.getUser(useremail);
			assertTrue(getUser != null);
			System.out.println(getUser.toString());
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void getUserFailed() {
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
