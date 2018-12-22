public class EnumTest {
	
	public enum Day{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	}

	public static void dayMessage(Day day){
		switch(day){
		case SUNDAY:
			System.out.println("It's Sunday!");
			break;
		case MONDAY:
			System.out.println("It's Monday!");
			break;
		default:
			System.out.println("Not sure what day it is!");
			break;
		}
	}
	public static void main(String[] args) {
		Day d = Day.FRIDAY;
		dayMessage(Day.MONDAY);
		dayMessage(d);		
	}

}
