package f_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(0 <= hour && hour <= 23){
			this.hour = hour;
		}
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(0 <= minute && minute <=59){
			this.minute = minute;
		}
	}
	public int getSecond() {
			return second;
	}
	public void setSecond(int second) {
		if(0 <= second && second <=59){
			this.second = second;
		}
	}
	@Override
	public String toString() {
		return hour + " : " + minute + " : " + second;
	}
	
	
}
