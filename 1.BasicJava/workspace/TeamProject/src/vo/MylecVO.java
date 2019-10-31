package vo;

public class MylecVO { //교수가 자신의 강의 목록 담을 클래스
	private int myLecNum;//기본 번호
	private int subNum; //과목번호
	private int lecnum; //강의 번호
	private String subnm; //과목명
	private String day; //강의 요일
	private String time; //강의 시간
	private String room; //강의실
	private int unit; //학점
	private int year; //년도
	private String semester; //학기

	public int getSubNum() {
		return subNum;
	}
	public void setSubNum(int sub) {
		this.subNum = sub;
	}
	public String getSubnm() {
		return subnm;
	}
	public void setSubnm(String subnm) {
		this.subnm = subnm;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getMyLecNum() {
		return myLecNum;
	}
	public void setMyLecNum(int myLecNum) {
		this.myLecNum = myLecNum;
	}
	public int getLecnum() {
		return lecnum;
	}
	public void setLecnum(int lecnum) {
		this.lecnum = lecnum;
	}
	
	

}
