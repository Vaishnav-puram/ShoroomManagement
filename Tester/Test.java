package showroomManagement.Tester;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import showroomManagement.Exceptions.*;
import showroomManagement.ValidateColor;
import showroomManagement.*;
public class Test {
	public static void main(String[] args) throws ParseException,DuplicateChasisException {
		ArrayList<Vehicle> vehicles=new ArrayList<>();
		int choice;
		Scanner s=new Scanner(System.in);
		String chasis,color,company;
		String md;
		int uid;
		double basePrice;
		boolean flag;
		Vehicle v;
		do {
			System.out.println("1.Store Vehicle");
			System.out.println("2.Display all Vehicles");
			System.out.println("3.Display vehicle");
			System.out.println("4.Remove vehicle from showroom");
			System.out.println("5.Edit color of vehicle");
			System.out.println("6.Exit");
			choice=s.nextInt();
			switch(choice) {
			case 1:
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
				v=new Vehicle(chasis,uid,color,Vehicle.sdf.parse(md),company);
				if(vehicles.isEmpty()) {
					vehicles.add(v);
					break;
				}
				try {
				for(Vehicle vh:vehicles) {
					if(v.equals(vh)) {
						throw new DuplicateChasisException("Error ! the chasis no you entered is duplicate one!");
					}
				}
				}catch(DuplicateChasisException e) {
					System.out.println(e.getMessage());
					return;
				}
				vehicles.add(v);
				break;
			case 2:
				for(Vehicle vh:vehicles) {
					System.out.println(vh);
				}
				break;
			case 3:
				System.out.println("Enter vehicle unique id :");
				uid=s.nextInt();
				flag=false;
				for(Vehicle vh :vehicles) {
					if(vh.getUid()==uid) {
						flag=true;
						System.out.println(vh);
						break;
					}
				}
				if(!flag) {
					System.out.println("Vehicle not found !");
				}
				break;
			case 4:
				flag=false;
				System.out.println("Enter vehicle uid:");
				uid=s.nextInt();
				for(Vehicle vh:vehicles) {
					if(vh.getUid()==uid) {
						flag=true;
						vehicles.remove(vh);
						break;
					}
				}
				if(flag) {
				System.out.println("Vehicle removed from showroom successfully.");
				}else {
					System.out.println("Unable to find the vehicle details!");
				}
				break;
			case 5:
				flag=false;
				System.out.println("Enter id of the vehicle:");
				uid=s.nextInt();
				System.out.println("Enter the color you want to change:");
				color=s.next();
				for(Vehicle vh:vehicles) {
					if(vh.getUid()==uid) {
						vh.setCol(color);
						flag=true;
						break;
					}
				}
				if(flag) {
					System.out.println("Color updated successfully.");
				}else {
						System.out.println("Unable to find the vehicle details!");
				}
				break;
			case 6:
				System.out.println("Qutting...");
				break;
			default:
				System.out.println("Invalid option !");
				break;
			}
			
		}while(choice!=6);
		s.close();
	}
}
