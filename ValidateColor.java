package showroomManagement;
import showroomManagement.*;
import showroomManagement.EnumColor.color;
import showroomManagement.Exceptions.InvaidColorException;
public class ValidateColor {
	public static void validateCol(String col) throws InvaidColorException {
		boolean flag=false;
		for(color c:color.values()) {
			if(c.toString().equals(col)) {
				flag=true;
			}
		}
		if(!flag) {
			throw new InvaidColorException("color not available from the options given");
		}
	}

}
