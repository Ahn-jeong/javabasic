package vo;

public class ProfessorVO {//교수 VO
    //    교수 : 이름, 사번, 학과, 비밀번호, 전화번호, 이메일
    private String name; // 이름
    private String empnum; // 사번
    private String major; // 학과
    private String passwd; // 비밀번호
    private String tel; // 전화번호
    private String email; // 이메일
    private String state; //재직

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
        return name;
    }

    public String getEmpnum() {
        return empnum;
    }

    public String getMajor() {
        return major;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
