package vo;

public class AdminVO {//관리자 VO
    private String adminid; //관리자번호
    private String pwd; // 비밀번호
    private String name; // 관리자 이름


    public String getadminid() {
        return adminid;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setadminid(String adminid) {
        this.adminid = adminid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;

    }
}
