package com.fssa.sharpandclean.service;



import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.service.UserService;
import com.fssa.sharpandclean.service.exception.ServiceException;

public class TestRegisterFeature {

    @Test
    public void testRegistrationSuccess() {
        UserService userService = new UserService();
        User user1 = new User(4, "kanna594@gmail.com", "Kannan", "Kannan@1467", "9878543123", "user");
        try {
            assertTrue(userService.registerUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegistrationEmailEmpty() {
        UserService userService = new UserService();
        User user1 = new User(2, "", "Aravindth", "Aravindth@123", "9876543123", "user");
        try {
           assertTrue(userService.registerUser(user1));
            fail();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegistrationPhoneNumberInvalid() {
        UserService userService = new UserService();
        User user1 = new User(3, "kavi@gmail.com", "Kavi", "Kavi@123", "987654h123", "user");
        try {
            userService.registerUser(user1);
            fail();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegistrationEmptyPassword() {
        UserService userService = new UserService();
        User user = new User(4, "muneesh@example.com", "muneesh", "", "8565473543", "user");
        try {
            userService.registerUser(user);
            fail("Expected ServiceException for empty password, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegistrationNullPassword() {
        UserService userService = new UserService();
        User user = new User(5, "JohnDoe", null, "john@example.com", "8565473543", "user");
        try {
            userService.registerUser(user);
            fail("Expected ServiceException for null password, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegistrationEmptyUsername() {
        UserService userService = new UserService();
        User user = new User(6, "", "P@ssw0rd", "john@example.com", "8565473543", "user");
        try {
            userService.registerUser(user);
            fail("Expected ServiceException for empty username, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegistrationNullUser() {
        UserService userService = new UserService();
        try {
            userService.registerUser(null);
            fail("Expected ServiceException for null user, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
