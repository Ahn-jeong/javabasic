package vo;

public class GradeVO {//성적 VO
	//성적번호 수강내역 등급
	private int grdnum;//성적VO
	private int suglist;
	private String grade;
	
	public int getGrdnum() {
		return grdnum;
	}
	public void setGrdnum(int grdnum) {
		this.grdnum = grdnum;
	}
	public int getSuglist() {
		return suglist;
	}
	public void setSuglist(int suglist) {
		this.suglist = suglist;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
