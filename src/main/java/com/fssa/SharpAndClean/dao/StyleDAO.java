package com.fssa.SharpAndClean.dao;

import java.sql.*;

import com.fssa.SharpAndClean.module.Style;

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
	public boolean addStyle(Style style) throws SQLException {
		// get the connection with variable passing method.
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
}
