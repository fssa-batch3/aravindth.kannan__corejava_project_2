package SharpAndClean.service;

import java.sql.SQLException;

import SharpAndClean.dao.*;
import SharpAndClean.module.*;
import SharpAndClean.service.exception.HairService_Exception;
import SharpAndClean.validation.HairserviceValidator;
import SharpAndClean.validation.exception.InvalidHairServiceException;
public class HairService_service {

	public boolean addedHairService(HairService hairservice) throws HairService_Exception {
		HairServiceDAO hair_service = new HairServiceDAO();
		
		try {
			HairserviceValidator.validateHairService(hairservice);
			
			return hair_service.addHairService(hairservice);
		}catch (InvalidHairServiceException | SQLException e) {
			throw new HairService_Exception(e);
		}
		
		
	}
}
