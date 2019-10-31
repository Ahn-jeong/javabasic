package data;

import java.util.ArrayList;

import controller.Controller;
import vo.AdminVO;
import vo.GradeVO;
import vo.LectureVO;
import vo.ProfessorVO;
import vo.StudentVO;
import vo.SubjectVO;
import vo.SugangListVO;

public class Database {
	
	private static Database instance;
	
	private Database(){}
	
	public static Database getInstance(){
		if(instance == null){
			instance = new Database();
		}
		return instance;
	}
	
	//교수 4자리 학생 8자리 학과는 5글자까지
	public ArrayList<AdminVO> tb_admin = new ArrayList<AdminVO>(); //관리자
	public ArrayList<ProfessorVO> tb_prf = new ArrayList<ProfessorVO>(); //교수
	public ArrayList<StudentVO> tb_std = new ArrayList<StudentVO>(); // 학생
	public ArrayList<SubjectVO> tb_sub = new ArrayList<SubjectVO>();
	public ArrayList<LectureVO> tb_lec = new ArrayList<LectureVO>();
	public ArrayList<SugangListVO> tb_sug = new ArrayList<SugangListVO>();
	public ArrayList<GradeVO> tb_grd = new ArrayList<GradeVO>();
//	public ArrayList<SugangListVO> tb_sugang = new ArrayList<SugangListVO>();
	
	{
		AdminVO user = new AdminVO();
		user.setadminid("admin");
		user.setPwd("admin");
		user.setName("관리자");
		
		tb_admin.add(user);
	}
	{
		ProfessorVO user = new ProfessorVO();
		user.setEmpnum("1001");
		user.setPasswd("1234");
		user.setMajor("사학과");
		user.setName("천선주");
		user.setTel("010-1234-1234");
		user.setEmail("dun4602@gmail.com");
		user.setState("재직");
		
		tb_prf.add(user);
	}
	{
		ProfessorVO user = new ProfessorVO();
		user.setEmpnum("1002");
		user.setPasswd("1234");
		user.setMajor("화학과");
		user.setName("김승섭");
		user.setTel("010-1234-5678");
		user.setEmail("sungsap@gmail.com");
		user.setState("재직");
		
		tb_prf.add(user);
	}
	{
		ProfessorVO user = new ProfessorVO();
		user.setEmpnum("1003");
		user.setPasswd("1234");
		user.setMajor("전자과");
		user.setName("하재관");
		user.setTel("010-2222-1234");
		user.setEmail("hjg@gmail.com");
		user.setState("재직");
		
		tb_prf.add(user);
	}
	{
		StudentVO user = new StudentVO();
		user.setStunum("20190001");
		user.setName("오제민");
		user.setPassword("1234");
		user.setMajor("사학과");		
		user.setTel("010-4336-6821");
		user.setEmail("ojm@naver.com");
		user.setState("재학");
		
		tb_std.add(user);
	}
	{
		StudentVO user = new StudentVO();
		user.setStunum("20190002");
		user.setName("안정현");
		user.setPassword("1234");
		user.setMajor("전자과");		
		user.setTel("010-4336-1234");
		user.setEmail("ajh@naver.com");
		user.setState("재학");				
		tb_std.add(user);
	}
	{
		StudentVO user = new StudentVO();
		user.setStunum("20190003");
		user.setName("조건희");
		user.setPassword("1234");
		user.setMajor("스페인어과");		
		user.setTel("010-4336-5678");
		user.setEmail("jgh@naver.com");
		user.setState("재학");				
		tb_std.add(user);
	}
	{
		StudentVO user = new StudentVO();
		user.setStunum("20190004");
		user.setName("김혜정");
		user.setPassword("1234");
		user.setMajor("반도체과");		
		user.setTel("010-3333-1234");
		user.setEmail("khj@naver.com");
		user.setState("재학");				
		tb_std.add(user);
	}
	{
		StudentVO user = new StudentVO();
		user.setStunum("20190005");
		user.setName("신유진");
		user.setPassword("1234");
		user.setMajor("간호학과");		
		user.setTel("010-3333-5678");
		user.setEmail("suj@naver.com");
		user.setState("재학");				
		tb_std.add(user);
	}	
	{
		SubjectVO sub = new SubjectVO();
		sub.setSubNum(1);
		sub.setSubName("java");
		
		tb_sub.add(sub);
	}
	{
		SubjectVO sub = new SubjectVO();
		sub.setSubNum(2);
		sub.setSubName("html5");
		
		tb_sub.add(sub);
	}
	{
		SubjectVO sub = new SubjectVO();
		sub.setSubNum(3);
		sub.setSubName("oracle");
		
		tb_sub.add(sub);
	}
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(1);
//		lec.setSubNum(1);
//		lec.setSubName("java");
//		lec.setProf("1001");
//		lec.setDay("월요일");
//		lec.setTime("1교시");
//		lec.setRoom("a100");
//		lec.setUnit(3); //학점
//		lec.setYear(2019);
//		lec.setSemester("1학기");
//		lec.setProfName("천선주");
//		tb_lec.add(lec);
//	}
//	
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(2);
//		lec.setSubNum(2);
//		lec.setSubName("html5");
//		lec.setProf("1002");
//		lec.setDay("화요일");
//		lec.setTime("1교시");
//		lec.setRoom("a100");
//		lec.setUnit(3); //학점
//		lec.setYear(2019);
//		lec.setSemester("1학기");
//		lec.setProfName("김승섭");
//		tb_lec.add(lec);
//	}
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(3);
//		lec.setSubNum(3);
//		lec.setSubName("oracle");
//		lec.setProf("1003");
//		lec.setDay("화요일");
//		lec.setTime("2교시");
//		lec.setRoom("a100");
//		lec.setUnit(3); //학점
//		lec.setYear(2019);
//		lec.setSemester("2학기");
//		lec.setProfName("하재관");
//		tb_lec.add(lec);
//	}

//	{
//		SugangListVO su = new SugangListVO();
//		su.setSugnum(1);
//		su.setStd("200900380");
//		su.setLec(1);
//		
//		tb_sug.add(su);
//	}
//	{
//		SugangListVO su = new SugangListVO();
//		su.setSugnum(2);
//		su.setStd("200900380");
//		su.setLec(2);
//		
//		tb_sug.add(su);
//	}
//	{
//		SugangListVO su = new SugangListVO();
//		su.setSugnum(3);
//		su.setStd("200900380");
//		su.setLec(3);
//		
//		tb_sug.add(su);
//	}
//	{
//		SugangListVO su = new SugangListVO();
//		su.setSugnum(3);
//		su.setStd("200900381");
//		su.setLec(3);
//		
//		tb_sug.add(su);
//	}
//	{
//		SugangListVO su = new SugangListVO();
//		su.setSugnum(5);
//		su.setStd("200900380");
//		su.setLec(5);
//		
//		tb_sug.add(su);
//	}
//	{
//		SugangListVO su = new SugangListVO();
//		su.setSugnum(5);
//		su.setStd("200900381");
//		su.setLec(5);
//		
//		tb_sug.add(su);
//	}
//	
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(1);
//		lec.setSubNum(1);
//		lec.setSubName("1");
//		lec.setProf("1");
//		lec.setDay("1");
//		lec.setTime("1");
//		lec.setRoom("1");
//		lec.setUnit(1);
//		lec.setYear(1);
//		lec.setSemester("1");
//		lec.setProfName("1");
//		tb_lec.add(lec);
//	}
//	
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(2);
//		lec.setSubNum(2);
//		lec.setSubName("2");
//		lec.setProf("2");
//		lec.setDay("2");
//		lec.setTime("2");
//		lec.setRoom("3");
//		lec.setUnit(2);
//		lec.setYear(2);
//		lec.setSemester("2");
//		lec.setProfName("2");
//		tb_lec.add(lec);
//	}
//	
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(333333);
//		lec.setSubNum(3);
//		lec.setSubName("데이터베이스");
//		lec.setProf("3");
//		lec.setDay("3");
//		lec.setTime("3");
//		lec.setRoom("3");
//		lec.setUnit(3);
//		lec.setYear(3);
//		lec.setSemester("3");
//		lec.setProfName("3");
//		tb_lec.add(lec);
//	}

}
