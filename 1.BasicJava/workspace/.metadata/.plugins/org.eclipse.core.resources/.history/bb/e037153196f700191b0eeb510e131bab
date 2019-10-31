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
	
	public ArrayList<AdminVO> tb_admin = new ArrayList<AdminVO>();
	public ArrayList<ProfessorVO> tb_prf = new ArrayList<ProfessorVO>();
	public ArrayList<StudentVO> tb_std = new ArrayList<StudentVO>();
	public ArrayList<SubjectVO> tb_sub = new ArrayList<SubjectVO>();
	public ArrayList<LectureVO> tb_lec = new ArrayList<LectureVO>();
	public ArrayList<SugangListVO> tb_sug = new ArrayList<SugangListVO>();
	public ArrayList<GradeVO> tb_grd = new ArrayList<GradeVO>();
	
	{
		AdminVO user = new AdminVO();
		user.setadminid("admin");
		user.setPwd("admin");
		user.setName("관리자");
		
		tb_admin.add(user);
	}
	{
		ProfessorVO user = new ProfessorVO();
		user.setEmpnum("20090380");
		user.setPasswd("asdf1234");
		user.setMajor("사학과");
		user.setName("오제민");
		user.setTel("010-1234-1234");
		user.setEmail("dun4602@gmail.com");
		user.setState("재직");
		
		tb_prf.add(user);
	}
	{
		ProfessorVO user = new ProfessorVO();
		user.setEmpnum("20090381");
		user.setPasswd("asdf1234");
		user.setMajor("사학과");
		user.setName("조건희");
		user.setTel("010-1234-5678");
		user.setEmail("dun4603@gmail.com");
		user.setState("재직");
		
		tb_prf.add(user);
	}
	{
		StudentVO user = new StudentVO();
		user.setStunum("200900380");
		user.setPassword("1234asdf");
		user.setMajor("사학과");
		user.setName("오제민");
		user.setTel("010-4336-6821");
		user.setEmail("dun4602@naver.com");
		user.setState("재학");
		
		tb_std.add(user);
	}
	{
		SubjectVO sub = new SubjectVO();
		sub.setSubNum(1);
		sub.setSubName("중국고대사");
		
		tb_sub.add(sub);
	}
	{
		SubjectVO sub = new SubjectVO();
		sub.setSubNum(2);
		sub.setSubName("서양사입문");
		
		tb_sub.add(sub);
	}
	{
		SubjectVO sub = new SubjectVO();
		sub.setSubNum(3);
		sub.setSubName("동양사개설");
		
		tb_sub.add(sub);
	}
	{
		SubjectVO sub = new SubjectVO();
		sub.setSubNum(4);
		sub.setSubName("한국고대사");
		
		tb_sub.add(sub);
	}
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(1);
//		lec.setSubNum(1);
//		lec.setProfName("오제민");
//		lec.setDay("월요일");
//		lec.setTime("1교시");
//		lec.setRoom("a101");
//		lec.setUnit(3);
//		lec.setYear(2019);
//		lec.setSemester("1학기");
//		
//		tb_lec.add(lec);
//	}
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(2);
//		lec.setSubNum(2);
//		lec.setSubName("서양사입문");
//		lec.setProfName("오제민");
//		lec.setDay("화요일");
//		lec.setTime("1교시");
//		lec.setRoom("a101");
//		lec.setUnit(3);
//		lec.setYear(2019);
//		lec.setSemester("1학기");
//		
//		tb_lec.add(lec);
//	}
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(3);
//		lec.setSubNum(3);
//		lec.setProfName("오제민");
//		lec.setDay("수요일");
//		lec.setTime("1교시");
//		lec.setRoom("a101");
//		lec.setUnit(3);
//		lec.setYear(2019);
//		lec.setSemester("1학기");
//		
//		tb_lec.add(lec);
//	}
//	{
//		LectureVO lec = new LectureVO();
//		lec.setLecnum(4);
//		lec.setSubNum(4);
//		lec.setProf("오제민");
//		lec.setDay("수요일");
//		lec.setTime("1교시");
//		lec.setRoom("a101");
//		lec.setUnit(3);
//		lec.setYear(2019);
//		lec.setSemester("1학기");
//		
//		tb_lec.add(lec);
//	}
	{
		SugangListVO su = new SugangListVO();
		su.setSugnum(1);
		su.setStd("200900380");
		su.setLec(1);
		
		tb_sug.add(su);
	}
	{
		SugangListVO su = new SugangListVO();
		su.setSugnum(2);
		su.setStd("200900380");
		su.setLec(2);
		
		tb_sug.add(su);
	}
	{
		SugangListVO su = new SugangListVO();
		su.setSugnum(3);
		su.setStd("200900380");
		su.setLec(3);
		
		tb_sug.add(su);
	}

}
