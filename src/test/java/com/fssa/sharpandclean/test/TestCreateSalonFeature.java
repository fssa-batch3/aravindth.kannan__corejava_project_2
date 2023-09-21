package com.fssa.sharpandclean.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.sharpandclean.model.Salon;
import com.fssa.sharpandclean.service.SalonService;
import com.fssa.sharpandclean.service.exception.ServiceException;

class TestCreateSalonFeature {
	
	// test salon details are valid.
	@Test
	 void registerSalon() {
		SalonService salonService = new SalonService();
		Salon salon = new Salon("HavenHaircut", "meena12@gmail.com", "9856874325",
				"3/25, East Street, velachery, Chennai - 08",
				"Everyday is great hair day with me around. I am a barber. I shape people's hair for a living. I spend time with my clients and I can make them laugh.",
				"https://losbarberosclassicbarbershop.com/wp-content/uploads/2019/06/Profile-_0000_Yamil.jpg",
				"Velachery", "We have 10 years work experience in this barber career",
				"https://i.pinimg.com/originals/05/90/aa/0590aa50b82ee7e5d90ea3702f18e3f9.jpg",
				"https://haircutinspiration.com/wp-content/uploads/2023/03/dyed-hair-colorful-mens-hairstyles-1.jpg",
				"https://content.latest-hairstyles.com/wp-content/uploads/platinum-fire-mens-hair-color-800x1000.jpg");

		assertDoesNotThrow(() -> assertTrue(salonService.registerSalon(salon)));
	}
	
	// test salon name is null
	@Test
	 void registerSalonNameNull() {
		SalonService salonService = new SalonService();
		Salon salon = new Salon("", "meena12@gmail.com", "9856874325",
				"3/25, East Street, velachery, Chennai - 08",
				"Everyday is great hair day with me around. I am a barber. I shape people's hair for a living. I spend time with my clients and I can make them laugh.",
				"https://losbarberosclassicbarbershop.com/wp-content/uploads/2019/06/Profile-_0000_Yamil.jpg",
				"Velachery", "We have 10 years work experience in this barber career",
				"https://i.pinimg.com/originals/05/90/aa/0590aa50b82ee7e5d90ea3702f18e3f9.jpg",
				"https://haircutinspiration.com/wp-content/uploads/2023/03/dyed-hair-colorful-mens-hairstyles-1.jpg",
				"https://content.latest-hairstyles.com/wp-content/uploads/platinum-fire-mens-hair-color-800x1000.jpg");

		assertThrows(ServiceException.class, () -> salonService.registerSalon(salon));

	}
	
	// test salon name email is null 
	@Test
	 void registerSalonEmailNull() {
		SalonService salonService = new SalonService();
		Salon salon = new Salon("Mahaan", "", "9856874325",
				"3/25, East Street, velachery, Chennai - 08",
				"Everyday is great hair day with me around. I am a barber. I shape people's hair for a living. I spend time with my clients and I can make them laugh.",
				"https://losbarberosclassicbarbershop.com/wp-content/uploads/2019/06/Profile-_0000_Yamil.jpg",
				"Velachery", "We have 10 years work experience in this barber career",
				"https://i.pinimg.com/originals/05/90/aa/0590aa50b82ee7e5d90ea3702f18e3f9.jpg",
				"https://haircutinspiration.com/wp-content/uploads/2023/03/dyed-hair-colorful-mens-hairstyles-1.jpg",
				"https://content.latest-hairstyles.com/wp-content/uploads/platinum-fire-mens-hair-color-800x1000.jpg");

		assertThrows(ServiceException.class, () -> salonService.registerSalon(salon));

	}
	
	// test salon name number is null
	@Test
	
	 void registerSalonPhoneNull() {
		SalonService salonService = new SalonService();
		Salon salon = new Salon("Mahaan", "munish@gmail.com", "",
				"3/25, East Street, velachery, Chennai - 08",
				"Everyday is great hair day with me around. I am a barber. I shape people's hair for a living. I spend time with my clients and I can make them laugh.",
				"https://losbarberosclassicbarbershop.com/wp-content/uploads/2019/06/Profile-_0000_Yamil.jpg",
				"Velachery", "We have 10 years work experience in this barber career",
				"https://i.pinimg.com/originals/05/90/aa/0590aa50b82ee7e5d90ea3702f18e3f9.jpg",
				"https://haircutinspiration.com/wp-content/uploads/2023/03/dyed-hair-colorful-mens-hairstyles-1.jpg",
				"https://content.latest-hairstyles.com/wp-content/uploads/platinum-fire-mens-hair-color-800x1000.jpg");

		assertThrows(ServiceException.class, () -> salonService.registerSalon(salon));

	}
	
	// test salon profile url not valid.
	@Test
	 void registerSalonProfileNotValid() {
		SalonService salonService = new SalonService();
		Salon salon = new Salon("Mahaan", "munish@gmail.com", "9887766554",
				"3/25, East Street, velachery, Chennai - 08",
				"Everyday is great hair day with me around. I am a barber. I shape people's hair for a living. I spend time with my clients and I can make them laugh.",
				"losbarberosclassicbarbershop.com/wp-content/uploads/2019/06/Profile-_0000_Yamil.jpg",
				"Velachery", "We have 10 years work experience in this barber career",
				"https://i.pinimg.com/originals/05/90/aa/0590aa50b82ee7e5d90ea3702f18e3f9.jpg",
				"https://haircutinspiration.com/wp-content/uploads/2023/03/dyed-hair-colorful-mens-hairstyles-1.jpg",
				"https://content.latest-hairstyles.com/wp-content/uploads/platinum-fire-mens-hair-color-800x1000.jpg");
		 assertThrows(ServiceException.class, () -> {
			salonService.registerSalon(salon);
		});
	
		
	}
	
}
