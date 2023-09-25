package com.fssa.sharpandclean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fssa.sharpandclean.dao.exception.BarberDAOException;
import com.fssa.sharpandclean.dao.exception.SalonDAOException;
import com.fssa.sharpandclean.model.Barber;
import com.fssa.sharpandclean.model.Salon;
import com.fssa.sharpandclean.utils.ConnectionUtil;

public class BarberDAO {

	public boolean createBarber(Barber barber) throws BarberDAOException {
		//get connection with variable passing method.
		
		String query = "INSERT INTO barber (barber_name, barber_email, barber_password, barber_profile_URL, barber_phonenumber, barber_address, barber_about, barber_experience,sample_1,sample_2,sample_3) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement pmt = con.prepareStatement(query)){
			// set the barberId during registration
			pmt.setString(1, barber.getBarberName());
			pmt.setString(2, barber.getBarberEmail());
			pmt.setString(3, barber.getBarberPassword());
			pmt.setString(4, barber.getBarberProfile());
			pmt.setString(5, barber.getBarberPhone());
			pmt.setString(6, barber.getBarberAddress()); 
			pmt.setString(7, barber.getBarberAbout());
			pmt.setString(8, barber.getBarberExperience());
			pmt.setString(9, barber.getSample_1());
			pmt.setString(10, barber.getSample_2());
			pmt.setString(11, barber.getSample_3());
			int rows = pmt.executeUpdate();
			return rows ==1;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new BarberDAOException("Error in barber DAO query");
		}
			
		}
	
	// method to get salon by salon email.
		public Barber getBarberByEmail(String barberEmail) throws BarberDAOException {
			String query = "SELECT * FROM barber WHERE barber_email=?";
			Barber barber = new Barber();

			try (Connection connection = ConnectionUtil.getConnection();
					PreparedStatement pmt = connection.prepareStatement(query)) {
				pmt.setString(1, barberEmail);
				ResultSet rs = pmt.executeQuery();

				if (rs.next()) {
					if (rs.getInt("barber_is_deleted") == 0) {

					// created a sslon object with get data.
					barber.setBarberId(rs.getInt("barber_id"));
					barber.setBarberName(rs.getString("barber_name"));
					barber.setBarberEmail(rs.getString("barber_email"));
					barber.setBarberProfile(rs.getString("barber_profile_URL"));
					barber.setBarberPhone(rs.getString("barber_phonenumber"));
					barber.setBarberAddress(rs.getString("barber_address"));
					barber.setBarberAbout(rs.getString("barber_about"));
					barber.setBarberExperience(rs.getString("barber_experience"));
					barber.setSample_1(rs.getString("sample_1"));
					barber.setSample_2(rs.getString("sample_2"));
					barber.setSample_3(rs.getString("sample_3"));
					}
				}

			} catch (SQLException e) {
				throw new BarberDAOException("Error fetching barber by barber email" + e.getMessage());
			}
			return barber;
		}
	
	
	 // Method to check if a user with the given email exists in the database
    public boolean isEmailExists(String barberEmail) throws BarberDAOException {
        String query = "SELECT * FROM barber WHERE barber_email = ?";
        try (Connection connection =  ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, barberEmail);
            ResultSet rs = pmt.executeQuery();
            return rs.next(); // If a row is found, the email exists
        }catch(SQLException e) {
        	throw new BarberDAOException(e);
        }
    }
    
    // method to login barber.
    public boolean login(Barber barber) throws BarberDAOException {
		
    	String query = "SELECT * FROM  barber WHERE barber_email = ? AND barber_password = ?";
    	try(Connection connection   = ConnectionUtil.getConnection();
    		PreparedStatement pmt = connection.prepareStatement(query)){
    			pmt.setString(1, barber.getBarberEmail());
    			pmt.setString(2, barber.getBarberPassword());
    			try(ResultSet rs = pmt.executeQuery()){
    				return rs.next();
    			}
    		}catch(SQLException e) {
    			throw new BarberDAOException(e);
    		}
    	
	}
    
//     Method to List all barber for user view.
    
    public List<Barber> listAllBarber() throws BarberDAOException{
    	List<Barber> barbers = new ArrayList<>();
    	
    	try(PreparedStatement stmt = ConnectionUtil.getConnection().prepareStatement("SELECT * FROM barber");
    			ResultSet rs = stmt.executeQuery()){
    		while(rs.next()) {
    			if(rs.getInt("barber_is_deleted") == 0) {
    				int barberId = rs.getInt("barber_id");
    				String barberName = rs.getString("barber_name");
    				String barberEmail = rs.getString("barber_email");
    				String barberPassword = rs.getString("barber_password");
    				String barberProfile = rs.getString("barber_profile_URL");
    				String barberPhone = rs.getString("barber_phonenumber");
    				String barberAddress = rs.getString("barber_address");
    				String barberAbout = rs.getString("barber_about");
    				String barberExperience = rs.getString("barber_experience");
    				String barber_sample_1 = rs.getString("sample_1");
    				String barber_sample_2 = rs.getString("sample_2");
    				String barber_sample_3 = rs.getString("sample_3");
    				
    				barbers.add(new Barber(barberId, barberName, barberEmail, barberPassword, barberProfile, barberPhone, barberAddress, barberAbout, barberExperience,barber_sample_1,barber_sample_2,barber_sample_3));
    			}
    		}
    		return barbers;
    	}catch(SQLException e) {
    		throw new BarberDAOException("Error in getAll barbers");
    	}
    }
     
    // Method for update barber's profile.
    
    public boolean updateBarber(Barber barber) throws BarberDAOException {
    	
    	String query = "UPDATE barber SET barber_name=?, barber_password=?, barber_profile_URL=?, barber_phonenumber=?, barber_address=?, barber_about=?, barber_experience=?,sample_1 = ?,sample_2 = ?,sample_3 = ?  WHERE barber_email=?";
   try(Connection con = ConnectionUtil.getConnection();
		   PreparedStatement pmt = con.prepareStatement(query)){
	   pmt.setString(1, barber.getBarberName());
	   pmt.setString(2, barber.getBarberPassword());
	   pmt.setString(3, barber.getBarberProfile());
	   pmt.setString(4, barber.getBarberPhone());
	   pmt.setString(5, barber.getBarberAddress());
	   pmt.setString(6, barber.getBarberAbout());
	   pmt.setString(7, barber.getBarberExperience());
	   pmt.setString(8, barber.getSample_1());
	   pmt.setString(9, barber.getSample_2());
	   pmt.setString(10, barber.getSample_3());
	   pmt.setString(11, barber.getBarberEmail());
	   int rows = pmt.executeUpdate();
	   return rows == 1;
	   
   }catch(SQLException e) {
	   throw new BarberDAOException(e);
   }

    }
    
    // method for delete barber.
    
    public boolean deleteBarber(String barberEmail) throws BarberDAOException {
		Connection con = ConnectionUtil.getConnection();
		String query = "UPDATE barber SET barber_is_deleted = ? WHERE barber_email = ?";
		try(PreparedStatement pmt = con.prepareStatement(query)){
			pmt.setInt(1, 1);
			pmt.setString(2, barberEmail);
			int rows = pmt.executeUpdate();
			return rows == 1;
		}catch(SQLException e) {
			throw new BarberDAOException(e);
		}
		
    }
}
