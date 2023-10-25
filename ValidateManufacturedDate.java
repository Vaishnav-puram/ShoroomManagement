package showroomManagement;

import java.text.ParseException;
import java.util.Date;

import showroomManagement.Exceptions.InvalidManufacturedDate;

public class ValidateManufacturedDate {
	public static void validateMd(String d) throws ParseException, InvalidManufacturedDate {
		Date md1=Vehicle.sdf.parse(d);
		String testDate="2021-01-01";
		Date md2=Vehicle.sdf.parse(testDate);
		if(md1.before(md2)) {
			throw new InvalidManufacturedDate("Invalid manufactured date !");
		}
	}
}
