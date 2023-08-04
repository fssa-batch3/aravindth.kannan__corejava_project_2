package SharpAndClean.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SharpAndClean.dao.exception.DAOException;
import SharpAndClean.module.User;

public class UserDAO {

	// connect to database
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sharp_and_clean", "root", "123456");
	}

// Get user from DB
	public boolean login(User user) throws SQLException {

		Connection connection = getConnection();
		String query = "SELECT * FROM USER WHERE email = ? AND PASSWORD = ?";
		PreparedStatement pmt = connection.prepareStatement(query);
		pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getPassword());

		ResultSet rs = pmt.executeQuery();
//		if (rs.next()) {
//			String userEmail = rs.getString("EMAIL");
//			String userPass = rs.getString("PASSWORD");

		return rs.next();
	}
	// Add new task to DB

	// Add new user to DB - Register
	public boolean register(User user) throws SQLException {
		Connection connection = getConnection();
		String query = "INSERT INTO USER (email ,username,password,phonenumber,type) VALUES (?,?,?,?,?)";
		PreparedStatement pmt = connection.prepareStatement(query);
		pmt.setString(1, user.getEmail());
		pmt.setString(2, user.getUsername());
		pmt.setString(3, user.getPassword());
		pmt.setString(4, user.getPhonenumber());
		pmt.setString(5, user.getType());
		int rows = pmt.executeUpdate();

		// Return successful or not

		pmt.close();
		connection.close();

		return rows == 1;

	}
}
