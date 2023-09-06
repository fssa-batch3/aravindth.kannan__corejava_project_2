package com.fssa.sharpandclean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.sharpandclean.dao.exception.DAOException;
import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.utils.ConnectionUtil;

public class UserDAO {
	
	
 
	// Add new user to DB - Register
	 public boolean register(User user) throws DAOException {
	        Connection connection =  ConnectionUtil.getConnection();
	        String query = "INSERT INTO user (email, userName, password, phoneNumber, type) VALUES ( ?, ?, ?, ?, ?)";
	        
	        try (PreparedStatement pmt = connection.prepareStatement(query)) {
	            // Set the userId during registration
	            pmt.setString(1, user.getEmail());
	            pmt.setString(2, user.getUsername());
	            pmt.setString(3, user.getPassword());
	            pmt.setString(4, user.getPhonenumber());
	            pmt.setString(5, user.getType());
	            int rows = pmt.executeUpdate();
	            return rows == 1;
	        }catch(SQLException e) {
	        	throw new DAOException(e);
	        }
	    }
	
	 // Method to check if a user with the given email exists in the database
    public boolean isEmailExists(String email) throws DAOException {
        String query = "SELECT * FROM user WHERE email = ?";
        try (Connection connection =  ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, email);
            ResultSet rs = pmt.executeQuery();
            return rs.next(); // If a row is found, the email exists
        }catch(SQLException e) {
        	throw new DAOException(e);
        }
    }

    
 // Method to authenticate the user with the provided email and password
    public boolean login(User user, String email) throws DAOException {
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        try (Connection connection =  ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, email); // Use provided email for the query
            pmt.setString(2, user.getPassword());
            try (ResultSet rs = pmt.executeQuery()) {
                return rs.next(); // If a row is found, authentication is successful
            }catch(SQLException e) {
            	throw new DAOException(e);
            }
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
    }
 

 // Update user information based on email
    public boolean updateUser(User user) throws DAOException {
        Connection connection =  ConnectionUtil.getConnection();
        String query = "UPDATE user SET username=?, phonenumber=? WHERE email=?";
        try (PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, user.getUsername());
            pmt.setString(2, user.getPhonenumber());
            pmt.setString(3, user.getEmail());
            int rows = pmt.executeUpdate();
            return rows == 1;
        }catch(SQLException e) {
        	throw new DAOException(e);
        }
    }
    
    

 

	// Delete user based on email
    public boolean deleteUser(String email) throws DAOException {
        Connection connection =  ConnectionUtil.getConnection();
        
        String query = "UPDATE user SET is_deleted = ? WHERE email = ?";
        
        try (PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setInt(1, 1); // Set isDeleted to true to mark the user as deleted
            pmt.setString(2, email);
            int rows = pmt.executeUpdate();
            return rows == 1;
        }catch(SQLException e) {
        	throw new DAOException(e);
        }
    }




	




	


}