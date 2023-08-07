package SharpAndClean.dao;

import java.sql.*;

import SharpAndClean.module.HairService;

public class HairServiceDAO {
	// set all connection data in a variables.
	String url = "jdbc:mysql://localhost:3306/sharp_and_clean";
	String userName = "root";
	String passWord = "123456";

	
	// Add new Hair service in barber or shop profile page
	public boolean addHairService(HairService hairservice) throws SQLException {
		// get the connection with variable passing method.
		Connection con = DriverManager.getConnection(url,userName,passWord);
		String query = "ISERT INTO HAIRSERVICE (haircut_email,haircut_name,haircut_type,haircut_about,haircut_url)";
		PreparedStatement pmt = con.prepareStatement(query);
		pmt.setString(1, hairservice.getHaircutEmail());
		pmt.setString(2, hairservice.getHaircutName());
		pmt.setString(3, hairservice.getHaircutType());
		pmt.setString(4, hairservice.getHaircutAbout());
		pmt.setString(5, hairservice.getHaircutUrl());
		
		int rows = pmt.executeUpdate();
		
		// Return successful or not
		pmt.close();
		con.close();
		
		return rows == 1;
		
		
	}
}
