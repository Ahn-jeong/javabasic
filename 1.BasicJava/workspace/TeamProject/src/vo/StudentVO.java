package vo;

public class StudentVO {//학생 VO
    private String stunum; // 학번
    private String name; // 이름
    private String password; // 비밀번호
    private String major; // 학과
    private String tel; // 전화번호
    private String email; // 이메일
    private String state; // 휴 복학 상태


    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//학생 : 학번, 이름, 학과, 전화번호, 이메일
    public String getStunum() {
        return stunum;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getMajor() {
        return major;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
