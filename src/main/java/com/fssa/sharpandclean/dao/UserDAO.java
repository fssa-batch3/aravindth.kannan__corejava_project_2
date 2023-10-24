package com.fssa.sharpandclean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.sharpandclean.dao.exception.DAOException;
import com.fssa.sharpandclean.model.User;
import com.fssa.sharpandclean.utils.ConnectionUtil;
import com.fssa.sharpandclean.utils.PasswordUtil;

public class UserDAO {

	// Add new user to DB - Register
	public boolean register(User user) throws DAOException {
		String query = "INSERT INTO user (email, username, password, phonenumber,salt) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			// Set the userId during registration
			pmt.setString(1, user.getEmail());
			pmt.setString(2, user.getUsername());
			pmt.setString(3, user.getPassword());
			pmt.setString(4, user.getPhonenumber());
			pmt.setString(5, user.getSalt());
			
			int rows = pmt.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException("registeration is not sucess" + e.getMessage());
		}
	}
	
	

	// Method to check if a user with the given email exists in the database
	public boolean isEmailExists(String email) throws DAOException {
		String query = "SELECT * FROM user WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, email);
			ResultSet rs = pmt.executeQuery();
			return rs.next(); // If a row is found, the email exists
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	
	//  login method
	public boolean login(User user) throws DAOException {
		String query = "SELECT * FROM user WHERE email = ? AND is_deleted = 0";

		    try (Connection connection = ConnectionUtil.getConnection();
		         PreparedStatement pstmt = connection.prepareStatement(query)) {
		    	pstmt.setString(1, user.getEmail()); // Use provided email for the query
//		    	pstmt.setString(2, user.getPassword());
		     
		        try (ResultSet rs = pstmt.executeQuery()) {
		        	if(rs.next()) {
		        		String password = rs.getString("password");
		        		String salt = rs.getString("salt");
		        		if(PasswordUtil.verifyPassword(user.getPassword(), salt, password)) {
		        			return true;
		        		}else {
		        	        throw new DAOException("Incorrect Email or Password");
		        		}
		        	}
		        	
		            return false;
		        }
		    } catch (Exception e) {
		    	
		        throw new DAOException("Error while authenticating the user: " + e.getMessage());
		    }
		}

	// method to view user details in profile page
	public User getUserByEmail(String email) throws DAOException {

		final String query = "SELECT * FROM user WHERE email = ?";
		User user = null;
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setString(1, email);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String name = rs.getString("username");
					String password = rs.getString("password");
					String phonenumber = rs.getString("phonenumber");
					user = new User(name, password, phonenumber);
				}
			}

		} catch (SQLException e) {
			throw new DAOException("User doesn't have this email.");
		}
		return user;
	}

	// Update user information based on email
	public boolean updateUser(User user) throws DAOException {
		Connection connection = ConnectionUtil.getConnection();
		String query = "UPDATE user SET username=?,password=?, phonenumber=? WHERE email=?";
		try (PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, user.getUsername());
			pmt.setString(2, user.getPassword());
			pmt.setString(3, user.getPhonenumber());
			pmt.setString(4, user.getEmail());
			int rows = pmt.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}