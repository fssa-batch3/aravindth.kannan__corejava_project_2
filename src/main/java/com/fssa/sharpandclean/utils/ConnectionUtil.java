package com.fssa.sharpandclean.utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    // Call the database connection
    public static Connection getConnection() {

        // Database URL and credentials
        final String dbUrl;
        final String dbUser;
        final String dbPassword;
        
      dbUrl = System.getenv("DB_URL");
      dbUser = System.getenv("DB_USER");
      dbPassword = System.getenv("DB_PASSWORD");

      
//      dbUrl = System.getenv("jdbc:mysql://localhost:3306/sharp_and_clean");
//      dbUser = System.getenv("root");
//      dbPassword = System.getenv("123456");

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			
			throw new RuntimeException("Unable to Connect to Database",e);
		} catch (ClassNotFoundException e) {
			
			throw new RuntimeException("Database Driver class Not found",e);
		}
        
        
    }

}