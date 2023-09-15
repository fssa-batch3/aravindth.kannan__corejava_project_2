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

public class SalonDAO {
	
	public boolean createSalon(Salon salon) throws SalonDAOException {
		//get connection with variable passing method.
				
				String query = "INSERT INTO salon (name, email, phone, profile_url, experience, address, about, area, style_image_1, style_image_2, style_image_3) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				
				try(Connection con = ConnectionUtil.getConnection();
					PreparedStatement pmt = con.prepareStatement(query)	){
					// set the barberId during registration
					pmt.setString(1, salon.getSalonName());
					pmt.setString(2, salon.getSalonEmail());
					pmt.setString(3, salon.getSalonPhone());
					pmt.setString(4, salon.getSalonURL());
					pmt.setString(5, salon.getSalonExperience());
					pmt.setString(6, salon.getSalonAddress()); 
					pmt.setString(7, salon.getSalonAbout());
					pmt.setString(8, salon.getSalonArea());
					pmt.setString(9, salon.getSalonSample1());
					pmt.setString(10, salon.getSalonSample2());
					pmt.setString(11, salon.getSalonSample3());
					int rows = pmt.executeUpdate();
					return rows == 1;
				}
				catch(SQLException e) {
					throw new SalonDAOException(e);
				}
	}
	
	 // Method to check if a salon with the given email exists in the database
    public boolean isSalonEmailExists(String salonEmail) throws SalonDAOException {
        String query = "SELECT * FROM salon WHERE email = ?";
        try (Connection connection =  ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, salonEmail);
            ResultSet rs = pmt.executeQuery();
            return rs.next(); // If a row is found, the email exists
        }catch(SQLException e) {
        	throw new SalonDAOException(e);
        }
    }//     Method to List all salon for user view.
    
    public List<Salon> listAllSalon() throws SalonDAOException{
    	List<Salon> salons = new ArrayList<>();
    	
    	try(PreparedStatement stmt = ConnectionUtil.getConnection().prepareStatement("SELECT * FROM salon");
    			ResultSet rs = stmt.executeQuery()){
    		while(rs.next()) {
    			if(rs.getInt("salon_is_deleted") == 0) {
    				int salonId = rs.getInt("salon_id");
    				String salonName = rs.getString("name");
    				String salonEmail = rs.getString("email");
    				String salonProfile = rs.getString("profile_url");
    				String shopPhone = rs.getString("phone");
    				String shopAddress = rs.getString("address");
    				String salonAbout = rs.getString("about");
    				String salonExperience = rs.getString("experience");
    				String salonArea = rs.getString("area");
    				String haircut1 = rs.getString("style_image_1");
      				String haircut2 = rs.getString("style_image_2");
    				String haircut3 = rs.getString("style_image_3");
    				salons.add(new Salon(salonId, salonName, salonEmail, salonProfile, shopPhone, shopAddress, salonAbout, salonExperience, salonArea,haircut1,haircut2,haircut3));
    			}
    		}
    		return salons;
    	}catch(SQLException e) {
    		throw new SalonDAOException("Error in getAll barbers");
    	}
    }
    
    
    
}
