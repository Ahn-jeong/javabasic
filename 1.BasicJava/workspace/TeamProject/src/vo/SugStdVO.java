package vo;

public class SugStdVO { //교수 : 수강생 리스트 담을 클래스
	//수강번호 년도 학기 과목번호 과목명 학생학과 학번 학생이름 성적
	private int sugStdNum; //수강생 리스트 번호
	private int lecNum; //강의 번호
	private int sugNum; //수강번호
	private int year; //년도
	private String semester; //학기
	private int subNum; //과목번호
	private String subNm; //과목명
	private String major; //학생학과
	private String stNum; //학번
	private String stNm; //학생이름
	private String grade; //성적
	
	public int getSugNum() {
		return sugNum;
	}
	public void setSugNum(int sugNum) {
		this.sugNum = sugNum;
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
	public int getSubNum() {
		return subNum;
	}
	public void setSubNum(int subNum) {
		this.subNum = subNum;
	}
	public String getSubNm() {
		return subNm;
	}
	public void setSubNm(String subNm) {
		this.subNm = subNm;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStNm() {
		return stNm;
	}
	public void setStNm(String stNm) {
		this.stNm = stNm;
	}
	public int getSugStdNum() {
		return sugStdNum;
	}
	public void setSugStdNum(int sugStdNum) {
		this.sugStdNum = sugStdNum;
	}
	public int getLecNum() {
		return lecNum;
	}
	public void setLecNum(int lecnum) {
		this.lecNum = lecnum;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
