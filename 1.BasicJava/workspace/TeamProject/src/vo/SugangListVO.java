package vo;

public class SugangListVO {//수강신청 내역
	//수강번호 학생 강의개설
	private int sugnum; //수강번호
	private String std; //학생학번
	private int lec; //강의개설번호
	private String grade; //성적
	private String prof; // 교수사번	
	
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public int getSugnum() {
		return sugnum;
	}
	public void setSugnum(int sugnum) {
		this.sugnum = sugnum;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public int getLec() {
		return lec;
	}
	public void setLec(int lec) {
		this.lec = lec;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
