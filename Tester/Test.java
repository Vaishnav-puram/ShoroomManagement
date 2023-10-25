package showroomManagement.Tester;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import showroomManagement.Exceptions.*;
import showroomManagement.ValidateColor;
import showroomManagement.*;
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner s=new Scanner(System.in);
		String chasis,color,company;
		String md;
		int uid;
		double basePrice;
		System.out.println("Enter chasis no.");
		chasis=s.next();
		System.out.println("Enter unique id:");
		uid=s.nextInt();
		System.out.println("Enter color");
		color=s.next();
		try {
			ValidateColor.validateCol(color);
		}catch(InvaidColorException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Enter manufacturing date :");
		md=s.next();
		try {
			ValidateManufacturedDate.validateMd(md);
		}catch(InvalidManufacturedDate e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Enter company name:");
		company=s.next();
		Vehicle v=new Vehicle(chasis,uid,color,Vehicle.sdf.parse(md),company);
		System.out.println(v);
	}
}
