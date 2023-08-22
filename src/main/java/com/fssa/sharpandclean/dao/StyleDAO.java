package com.fssa.sharpandclean.dao;

import java.sql.*;
import java.util.List;

import com.fssa.sharpandclean.dao.exception.StyleDAOException;
import com.fssa.sharpandclean.model.Style;

import java.util.ArrayList;

import io.github.cdimascio.dotenv.Dotenv;

public class StyleDAO { 
	// connect to database
		public Connection getConnection() throws SQLException {
			String DB_URL;
			String DB_USER;
			String DB_PASSWORD;

				if (System.getenv("CI") != null) {
					DB_URL = System.getenv("DB_URL");
					DB_USER = System.getenv("DB_USER");
					DB_PASSWORD = System.getenv("DB_PASSWORD");
				} else {
					Dotenv env = Dotenv.load();
					DB_URL = env.get("DB_URL");
					DB_USER = env.get("DB_USER");
					DB_PASSWORD = env.get("DB_PASSWORD");
				}
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}

	
	// Add new Hair service in barber or shop profile page
	public boolean addStyle(Style style) throws  StyleDAOException {
		// get the connection with variable passing method.
		
		try {
			Connection con = getConnection();
			String query = "INSERT INTO hairstyle (haircut_email,haircut_name,haircut_type,haircut_about,haircut_url) VALUES (?,?,?,?,?)";
			PreparedStatement pmt = con.prepareStatement(query);
			pmt.setString(1, style.getHaircutEmail());
			pmt.setString(2, style.getHaircutName());
			pmt.setString(3, style.getHaircutType());
			pmt.setString(4, style.getHaircutAbout());
			pmt.setString(5, style.getHaircutUrl());
			
			int rows = pmt.executeUpdate();
			
			// Return successful or not
			pmt.close();
			con.close();
			
			return rows == 1;	
		}
		catch(SQLException e) {
			throw new StyleDAOException("Error in add Style");
		}
		
	}
	
   // List All hair style for user from all barber and barberShop uploaded by them.	
	
	public List<Style> getAllStyle() throws StyleDAOException {
		List<Style> style1 = new ArrayList<>();

		try (PreparedStatement stmt = getConnection().prepareStatement(
				"SELECT haircut_id, haircut_email,haircut_name, haircut_type,haircut_about,haircut_url FROM hairstyle");
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int haircutId = rs.getInt("haircut_id");
				String haircutName = rs.getString("haircut_name");
				String haircutEmail = rs.getString("haircut_email");
				String haircutType = rs.getString("haircut_type");
				String haircutAbout = rs.getString("haircut_about");
				String haircutUrl = rs.getString("haircut_url");
				style1.add(new Style(haircutId, haircutName, haircutEmail, haircutType, haircutAbout, haircutUrl));

			}

			return style1;

		} catch (SQLException e) {
			throw new StyleDAOException("Error in getAllStyle");
		}

	}


	// Delete style based on style ID
		public boolean deleteStyle( int haircutId) throws  StyleDAOException {

			String query = "UPDATE hairstyle SET isDeleted = ? WHERE haircut_id = ?";

			try (Connection connection = getConnection(); 
				PreparedStatement pmt = connection.prepareStatement(query)) {
				pmt.setBoolean(1, true); // Set isDeleted to true to mark the design as deleted
				pmt.setInt(2, haircutId);
				int rows = pmt.executeUpdate();
				return rows == 1;
			}catch(SQLException e) {
				throw new StyleDAOException("Error in Delete Style");
			}
		}
		
     //	Update style based on style email by barber
		public boolean updateStyle(Style style) throws   StyleDAOException {
			String query = "UPDATE hairstyle SET haircut_name = ?, haircut_type = ?, haircut_about = ?, haircut_url = ?, haircut_email = ?  WHERE haircut_id = ?";
			try(Connection connection = getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)){
				pmt.setString(1, style.getHaircutName());
				pmt.setString(2, style.getHaircutType());
				pmt.setString(3, style.getHaircutAbout());
				pmt.setString(4, style.getHaircutUrl());
				pmt.setString(5, style.getHaircutEmail());
				pmt.setInt(6, style.getHaircutId());
				int rows = pmt.executeUpdate();
				
				pmt.close();
				return rows == 1;
			}catch(SQLException e) {
				throw new StyleDAOException("Error in Update Style");
			}
		}

		 // Method to check if a user with the given style id exists in the database
		public boolean isStyleExists(int styleId) throws SQLException {
			// TODO Auto-generated method stub
			
		        String query = "SELECT * FROM hairstyle WHERE haircut_id = ?";
		        try (Connection connection = getConnection();
		             PreparedStatement pmt = connection.prepareStatement(query)) {
		            pmt.setInt(1, styleId);
		            ResultSet rs = pmt.executeQuery();
		            return rs.next(); // If a row is found, the styleId exists
		        }
		    }
			
		}

