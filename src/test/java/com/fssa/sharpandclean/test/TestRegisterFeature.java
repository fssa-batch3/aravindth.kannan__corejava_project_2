package com.fssa.sharpandclean.test;



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.service.UserService;
import com.fssa.sharpandclean.service.exception.ServiceException;

 class TestRegisterFeature {
 
    @Test
     void testRegistrationSuccess() {
        UserService userService = new UserService();
        User user1 = new User( "navee@gmail.com", "Naveena", "Akkam432@", "9878543123");
        try {
            assertTrue(userService.registerUser(user1));
        } catch (ServiceException e) {
        	System.out.println( e.getMessage()); 
        	fail();

        }
    }

    @Test
     void testRegistrationEmailEmpty() {
        UserService userService = new UserService();
        User user1 = new User( "", "Aravindth", "Aravindth@123", "9876543123");
        try {
           assertTrue(userService.registerUser(user1));
            fail();
        } catch (ServiceException e) {
        	System.out.println( e.getMessage()); 
        }
    }

    @Test
     void testRegistrationPhoneNumberInvalid() {
        UserService userService = new UserService();
        User user1 = new User( "kavi@gmail.com", "Kavi", "Kavi@123", "987654h123");
        try {
            userService.registerUser(user1);
            fail();
        } catch (ServiceException e) {
        	System.out.println( e.getMessage()); 
        }
    }

    @Test
     void testRegistrationEmptyPassword() {
        UserService userService = new UserService();
        User user = new User( "muneesh@example.com", "muneesh", "", "8565473543");
        try {
            userService.registerUser(user);
            fail("Expected ServiceException for empty password, but none was thrown.");
        } catch (ServiceException e) {
        	System.out.println( e.getMessage()); 
        }
    }

    @Test
     void testRegistrationNullPassword() {
        UserService userService = new UserService();
        User user = new User( "JohnDoe", null, "john@example.com", "8565473543");
        try {
            userService.registerUser(user);
            fail("Expected ServiceException for null password, but none was thrown.");
        } catch (ServiceException e) {
        	System.out.println( e.getMessage()); 
        }
    }

    @Test
     void testRegistrationEmptyUsername() {
        UserService userService = new UserService();
        User user = new User( "", "P@ssw0rd", "john@example.com", "8565473543");
        try {
            userService.registerUser(user);
            fail("Expected ServiceException for empty username, but none was thrown.");
        } catch (ServiceException e) {
        	System.out.println( e.getMessage()); 
        }
    }

    @Test
     void testRegistrationNullUser() {
        UserService userService = new UserService();
        try {
            userService.registerUser(null);
            fail("Expected ServiceException for null user, but none was thrown.");
        } catch (ServiceException e) {
        	System.out.println( e.getMessage()); 
        }
    }
}
