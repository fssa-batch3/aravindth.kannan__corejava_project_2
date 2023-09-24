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
import com.fssa.sharpandclean.model.SalonBook;
import com.fssa.sharpandclean.utils.ConnectionUtil;

public class SalonDAO {

	public boolean createSalon(Salon salon) throws SalonDAOException {
		// get connection with variable passing method.

		String query = "INSERT INTO salon (name, email, phone, profile_url, experience, address, about, area, style_image_1, style_image_2, style_image_3) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pmt = con.prepareStatement(query)) {
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
		} catch (SQLException e) {
			throw new SalonDAOException(e);
		}
	}

	// Method to check if a salon with the given email exists in the database
	public boolean isSalonEmailExists(String salonEmail) throws SalonDAOException {
		String query = "SELECT * FROM salon WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, salonEmail);
			ResultSet rs = pmt.executeQuery();
			return rs.next(); // If a row is found, the email exists
		} catch (SQLException e) {
			throw new SalonDAOException(e);
		}
	}

	// Method to List all salon for user view.

	public List<Salon> listAllSalon() throws SalonDAOException {
		List<Salon> salons = new ArrayList<>();

		try (PreparedStatement stmt = ConnectionUtil.getConnection().prepareStatement("SELECT * FROM salon");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				if (rs.getInt("salon_is_deleted") == 0) {
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
					salons.add(new Salon(salonId, salonName, salonEmail, salonProfile, shopPhone, shopAddress,
							salonAbout, salonExperience, salonArea, haircut1, haircut2, haircut3));
				}
			}
			return salons;
		} catch (SQLException e) {
			throw new SalonDAOException("Error in getAll barbers");
		}
	}

	// method to get salon by salon Id.

	public Salon getSalonById(int salonId) throws SalonDAOException {
		String query = "SELECT * FROM salon WHERE salon_id=?";
		Salon salon = new Salon();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setInt(1, salonId);
			ResultSet rs = pmt.executeQuery();

			if (rs.next()) {

				// created a sslon object with get data.
				salon.setSalonId(rs.getInt("salon_id"));
				salon.setSalonName(rs.getString("name"));
				salon.setSalonEmail(rs.getString("email"));
				salon.setSalonURL(rs.getString("profile_url"));
				salon.setSalonPhone(rs.getString("phone"));
				salon.setSalonAddress(rs.getString("address"));
				salon.setSalonAbout(rs.getString("about"));
				salon.setSalonExperience(rs.getString("experience"));
				salon.setSalonArea(rs.getString("area"));
				salon.setSalonSample1(rs.getString("style_image_1"));
				salon.setSalonSample2(rs.getString("style_image_2"));
				salon.setSalonSample3(rs.getString("style_image_3"));
			}

		} catch (SQLException e) {
			throw new SalonDAOException("Error fetching salon by salonid" + e.getMessage());
		}

		return salon;

	}

	// method to book a salon with SalonBook model.

	public boolean bookSalon(SalonBook salonBook) throws SalonDAOException {
		// get connection with variable passing method.

		String query = "INSERT INTO booksalon (book_user_name, book_user_phone, "
				+ "service, date, time, user_email, salon_name, salon_email, "
				+ "salon_phone, salon_profile, salon_experience,"
				+ "salon_address,salon_about,salon_area,book_otp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pmt = con.prepareStatement(query)) {
			// set the barberId during registration
			pmt.setString(1, salonBook.getBookUserName());
			pmt.setString(2, salonBook.getBookUserPhone());
			pmt.setString(3, salonBook.getBookService());
			pmt.setDate(4, java.sql.Date.valueOf(salonBook.getBookDate()));
			pmt.setString(5, salonBook.getBookTime());
			pmt.setString(6, salonBook.getBooUserEmail());
			pmt.setString(7, salonBook.getSalonName());
			pmt.setString(8, salonBook.getSalonEmail());
			pmt.setString(9, salonBook.getSalonPhone());
			pmt.setString(10, salonBook.getSalonProfile());
			pmt.setString(11, salonBook.getSalonEx());
			pmt.setString(12, salonBook.getSalonAddress());
			pmt.setString(13, salonBook.getSalonAbout());
			pmt.setString(14, salonBook.getSalonArea());
			pmt.setString(15, salonBook.getSalonOTP());
			int rows = pmt.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new SalonDAOException(e);
		}
	}

	// method to get salonBook by email defind by user or salon email.
	public List<SalonBook> bookSalonListForUser(String userEmail) throws SalonDAOException {
		List<SalonBook> salonBooks = new ArrayList<>();
		String query = "SELECT * FROM booksalon WHERE user_email=?";
		try (Connection con = ConnectionUtil.getConnection();
			PreparedStatement pmt = con.prepareStatement(query)) {
			pmt.setString(1, userEmail);
			ResultSet rs = pmt.executeQuery();
				while (rs.next()) {
					SalonBook salonBook = new SalonBook();
					if (rs.getInt("book_user_is_deleted") == 0) {
						salonBook.setBookId(rs.getInt("book_salon_id"));
						salonBook.setBooUserEmail(rs.getString("user_email"));
						salonBook.setSalonName(rs.getString("salon_name"));
						salonBook.setSalonProfile(rs.getString("salon_profile"));
						salonBook.setSalonPhone(rs.getString("salon_phone"));
						salonBook.setSalonAddress(rs.getString("salon_address"));
						salonBook.setSalonAbout(rs.getString("salon_about"));
						salonBook.setSalonEx(rs.getString("salon_experience"));
						salonBook.setSalonArea(rs.getString("salon_area"));
						salonBook.setBookService(rs.getString("service"));
						salonBook.setBookDate(rs.getDate("date").toLocalDate());
						salonBook.setBookTime(rs.getString("time"));
						salonBook.setSalonOTP(rs.getString("book_otp"));
						salonBooks.add(salonBook);
					}
				}
				return salonBooks;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalonDAOException("Error in getAll bookings for user view.");
			}
		}
	

	// method to get salonBook by email defind by user or salon email.
	public List<SalonBook> bookSalonListForSalon(String salonEmail) throws SalonDAOException {
		List<SalonBook> salonBooks = new ArrayList<>();
		String query = "SELECT * FROM booksalon WHERE salon_email=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pmt = con.prepareStatement(query)) {
			pmt.setString(1, salonEmail);
			ResultSet rs = pmt.executeQuery();
			while (rs.next()) {
				SalonBook salonBook = new SalonBook();
				if (rs.getInt("book_salon_is_deleted") == 0) {
					salonBook.setBookId(rs.getInt("book_salon_id"));
					salonBook.setBookUserName(rs.getString("book_user_name"));
					salonBook.setBookUserPhone(rs.getString("book_user_phone"));
					salonBook.setBookService(rs.getString("service"));
					salonBook.setBookDate(rs.getDate("date").toLocalDate());
					salonBook.setBookTime(rs.getString("time"));
					salonBook.setSalonEmail(rs.getString("salon_email"));
					salonBook.setSalonOTP(rs.getString("book_otp"));
					salonBooks.add(salonBook);
				}
			}
			return salonBooks;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalonDAOException("Error in getAll bookings by salon email");
		}

	}
	
	
	// Method to check if a salon is already booked or not by email and date and time schedule in the database
		public  boolean isSalonAlreadyBooked(SalonBook salonBook) throws SalonDAOException {
			String query = "SELECT * FROM booksalon WHERE salon_email = ? AND date=? AND time=?";
			try (Connection connection = ConnectionUtil.getConnection();
					PreparedStatement pmt = connection.prepareStatement(query)) {
				pmt.setString(1, salonBook.getSalonEmail());
				pmt.setDate(2, java.sql.Date.valueOf(salonBook.getBookDate()));
				pmt.setString(3, salonBook.getBookTime());
				ResultSet rs = pmt.executeQuery();
				return rs.next(); // If a row is found, the email exists
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SalonDAOException("Error in salon is already booked DAO method");
			}
		}

}
