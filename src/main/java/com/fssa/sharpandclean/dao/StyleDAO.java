package com.fssa.sharpandclean.dao;
import java.sql.*;
import java.util.List;
import com.fssa.sharpandclean.dao.exception.StyleDAOException;
import com.fssa.sharpandclean.model.Style;
import com.fssa.sharpandclean.utils.ConnectionUtil;
import java.util.ArrayList;

public class StyleDAO {
	
	// Add new Hair service in barber profile page
	public boolean addStyle(Style style) throws StyleDAOException {
		// get the connection with variable passing method.
		String query = "INSERT INTO hairstyle (haircut_email,haircut_name,haircut_type,haircut_about,haircut_url) VALUES (?,?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection();
			PreparedStatement pmt = con.prepareStatement(query)){	
			pmt.setString(1, style.getHaircutEmail());
			pmt.setString(2, style.getHaircutName());
			pmt.setString(3, style.getHaircutType());
			pmt.setString(4, style.getHaircutAbout());
			pmt.setString(5, style.getHaircutUrl());
			int rows = pmt.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new StyleDAOException(e);
		}
	}

	// List All hair style for user from all barber and barberShop uploaded by them.

	public List<Style> getAllStyle() throws StyleDAOException {
		List<Style> style1 = new ArrayList<>();
		try (PreparedStatement stmt = ConnectionUtil.getConnection().prepareStatement("SELECT * FROM hairstyle");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				if (rs.getInt("is_deleted") == 0) {
					int haircutId = rs.getInt("haircut_id");
					String haircutName = rs.getString("haircut_name");
					String haircutEmail = rs.getString("haircut_email");
					String haircutType = rs.getString("haircut_type");
					String haircutAbout = rs.getString("haircut_about");
					String haircutUrl = rs.getString("haircut_url");
					style1.add(new Style(haircutId, haircutName, haircutEmail, haircutType, haircutAbout, haircutUrl));
				}
			}
			return style1;
		} catch (SQLException e) {
			throw new StyleDAOException("Error in getAllStyle");
		}
	}

	// Delete style based on style ID
	public boolean deleteStyle(int haircutId) throws StyleDAOException {
		String query = "UPDATE hairstyle SET is_deleted = ? WHERE haircut_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setInt(1, 1); // Set is_deleted to 1 to mark the style as deleted
			pmt.setInt(2, haircutId);
			int rows = pmt.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new StyleDAOException(e);
		}
	}

	// Update style based on style email by barber
	public boolean updateStyle(Style style) throws StyleDAOException {
		String query = "UPDATE hairstyle SET haircut_name = ?, haircut_type = ?, haircut_about = ?, haircut_url = ?, haircut_email = ?  WHERE haircut_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
				
			pmt.setString(1, style.getHaircutName());
			pmt.setString(2, style.getHaircutType());
			pmt.setString(3, style.getHaircutAbout());
			pmt.setString(4, style.getHaircutUrl());
			pmt.setString(5, style.getHaircutEmail());
			pmt.setInt(6, style.getHaircutId());
			int rows = pmt.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new StyleDAOException("Error in Update Style");
		}
	}

	// Method to check if a user with the given style id exists in the database
	public boolean isStyleExists(int styleId) throws StyleDAOException {

		String query = "SELECT * FROM hairstyle WHERE haircut_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setInt(1, styleId);
			ResultSet rs = pmt.executeQuery();
			return rs.next(); // If a row is found, the styleId exists
		} catch (SQLException e) {
			throw new StyleDAOException("Error in Style exists");
		}
	}

}
