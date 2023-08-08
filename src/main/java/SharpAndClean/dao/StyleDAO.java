package SharpAndClean.dao;

import java.sql.*;

import SharpAndClean.module.Style;

public class StyleDAO {
	// set all connection data in a variables.
	String url = "jdbc:mysql://localhost:3306/sharp_and_clean";
	String userName = "root";
	String passWord = "123456";

	
	// Add new Hair service in barber or shop profile page
	public boolean addStyle(Style style) throws SQLException {
		// get the connection with variable passing method.
		Connection con = DriverManager.getConnection(url,userName,passWord);
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
