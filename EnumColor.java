package showroomManagement;

public class EnumColor {
	enum color{
		WHITE(1000),BLACK(15000),SILVER(12000),GREY(5000);
		int value;
		color(int i) {
			// TODO Auto-generated constructor stub
			this.value=i;
		}
	}
}
