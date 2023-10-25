package showroomManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import showroomManagement.EnumColor.color;

public class Vehicle {
	private String chasisNo;
	private int uid;
	private String col;
	private static double basePrice=3000;
	private double totPrice;
	private Date manufacturedDate;
	public static SimpleDateFormat sdf;
	private String company;
	static {
		sdf=new SimpleDateFormat("yyy-MM-DD");
	}
	public Vehicle(String chasisNo, int uid, String col, Date manufacturedDate,String company) {
		this.chasisNo = chasisNo;
		this.uid = uid;
		this.col = col;
		this.manufacturedDate = manufacturedDate;
		this.company=company;
	}
	public double getPrice(String col) {
		for(color c:color.values()) {
			if(c.toString().equals(col)) {
				this.totPrice=basePrice+c.value;
			}
		}
		return this.totPrice;
	}
	
	public void setCol(String col) {
		this.col = col;
	}
	public int getUid() {
		return uid;
	}
	public String getChasisNo() {
		return this.chasisNo;
	}
	
	@Override
	public boolean equals(Object v) {
		if(v instanceof Vehicle) {
		if(this.getChasisNo().equals(((Vehicle) v).getChasisNo())) {
			return true;
		}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", uid=" + uid + ", color=" + col + ", basePrice=" + basePrice+"total Price= "+this.getPrice(this.col)
				+ ", manufacturedDate=" + manufacturedDate + ", company=" + company + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(chasisNo, col, company, manufacturedDate, totPrice, uid);
	}
	
}
