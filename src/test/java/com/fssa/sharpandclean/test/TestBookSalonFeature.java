package com.fssa.sharpandclean.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.SalonBook;
import com.fssa.sharpandclean.service.SalonService;

public class TestBookSalonFeature {
	
	@Test
	 void salonBookSuccess() {
		SalonService salonService = new SalonService();
		SalonBook salonBook = new SalonBook("Aravindth",
				"9856875687","Haircut",LocalDate.of(2023, 9, 22),"08:00Am - 09:00Am","aravindth@gmail.com",
				"mahaan","meena12@gmail.com","9723135476","https://losbarberosclassicbarbershop.com/wp-content/uploads/2019/06/Profile-_0000_Yamil.jpg",
				"We have 12 years experience","3/25, East Street, velachery, Chennai - 08","Everyday is great hair day with me around. I am a barber. I shape people's hair for a living. I spend time with my clients and I can make them laugh.",
				"Velachery");
		assertDoesNotThrow(() -> assertTrue(salonService.bookingSalon(salonBook)));
	}
}
