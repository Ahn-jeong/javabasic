package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import controller.Controller;
import vo.MylecVO;
import vo.ProfessorVO;
import vo.StudentVO;
import vo.SugStdVO;
import vo.SugangListVO;
import dao.ListDao;
import dao.ProfessorDao;
import data.Database;
import data.ProfSession;

public class ProfessorService {//교수 서비스

	private static ProfessorService instance;
	
	private ProfessorService(){}
	
	public static ProfessorService getInstance(){
		if(instance == null){
			instance = new ProfessorService();
		}
		return instance;
	}
	
	ProfessorDao professorDao = ProfessorDao.getInstance();
	
	public void login() {//로그인 메서드
		Scanner s = new Scanner(System.in);
		System.out.print("사번 : ");
		String id = s.nextLine();
		System.out.print("비밀번호 : ");
		String password = s.nextLine();
		
		//사번과 비밀번호 일치하는 교수 검색
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("EN", id);
		param.put("PASSWORD", password);
		
		ProfessorVO prf = professorDao.selectProf(param);
		
		if(prf == null){
			System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
			System.out.println("로그인 화면으로 이동합니다.");
			System.out.println();
			login();
		}else{
			ProfSession.loginprof = prf;
			System.out.println("로그인 성공!");
			System.out.println(prf.getName()+" 교수님, 어서오십시오.");
			System.out.println();
		}
	}
	
	public void info(){//1. 내 정보 확인
		while(true){
			Scanner s = new Scanner(System.in);
			int select;
			
			System.out.println("-------------- "+ ProfSession.loginprof.getName() +" 교수님의 정보입니다. --------------");
			System.out.println("사 번\t: " + ProfSession.loginprof.getEmpnum());
			System.out.println("학 과\t: " + ProfSession.loginprof.getMajor());
			System.out.println("이 름\t: " + ProfSession.loginprof.getName());
			System.out.println("전화번호\t: " + ProfSession.loginprof.getTel());
			System.out.println("e-mail\t: " + ProfSession.loginprof.getEmail());
			System.out.println("상 태\t: " + ProfSession.loginprof.getState());
			System.out.println("----------------------------------------------------");
			System.out.println();
			System.out.println("1. 비밀번호변경 | 2. 전화번호변경 | 3. e-mail변경 | 0. 뒤로가기");
			
			select = Integer.parseInt(s.nextLine());
			switch(select){
			case 1 : pwChange(); break;
			case 2 : telChange(); break;
			case 3 : emailChange(); break;
			case 0 : return;
			default : break;
			}
		}
	}
	
	public void pwChange(){//1-1. 비밀번호변경
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("새로운 비밀번호 : ");
			String newPw = s.nextLine();
			professorDao.changePw(newPw);
			System.out.println("비밀번호 변경 완료");
			break;
		}
	}
	
	public void telChange(){//1-2. 전화번호변경
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("새로운 전화번호 : ");
			String newTel = s.nextLine();
			professorDao.changeTel(newTel);
			System.out.println("전화번호 변경 완료");
			break;
		}
	}
	
	public void emailChange(){//1-3. 이메일변경
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("새로운 e-mail : ");
			String newEm = s.nextLine();
			professorDao.changeEmail(newEm);
			System.out.println("e-mail 변경 완료");
			break;
		}
	}
	
	public void lectureManage(){//2. 강의 과목 관리
		while(true){
			Scanner s = new Scanner(System.in);
			int select;
			
			System.out.println("----------------------------------------------------");
			System.out.println("1. 내 강의 과목 확인");
			System.out.println("2. 수강생 정보 확인");
			System.out.println("3. 성적 기입");
			System.out.println("0. 뒤로 가기");
			System.out.println("----------------------------------------------------");
			System.out.println("실행할 메뉴를 선택해주세요.");
			
			select = Integer.parseInt(s.nextLine());
			switch(select){
			case 1 : lecConfirm(); break;
			case 2 : sugStd(); break;
			case 3 : insertGrade(); break;
			case 0 : return;
			default : break;
			}
		}
	}
	
	public void lecConfirm(){//2-1. 내 강의 과목 확인
		while(true){
			Scanner s = new Scanner(System.in);
			
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("번호\t과목명\t학점\t담당교수\t강의요일\t강의시간\t강의실\t학기");			
			ArrayList<MylecVO> list = professorDao.myLecList();
			for(int i = 0; i < list.size(); i++){
				System.out.println(i + 1 + "\t" + list.get(i).getSubnm() + "\t" + list.get(i).getUnit()
						+ "\t" + ProfSession.loginprof.getName() + "\t" + list.get(i).getDay() + "\t"
						+ list.get(i).getTime() + "\t" + list.get(i).getRoom() + "\t" 
						+ list.get(i).getYear() + " " + list.get(i).getSemester());
			}
			System.out.println("---------------------------------------------------------------------------");
			System.out.println();
			System.out.println("이전 화면(enter)");
			s.nextLine();
			break;
		}
	}
	
	public void sugStd(){//2-2. 수강생 확인
		while(true){
			Scanner s = new Scanner(System.in);
			int select;
			
			System.out.println("---------------------------------------------------------------------------");
//			System.out.println("번호\t\t과목명\t\t학점\t\t담당교수\t\t강의시간\t\t강의실\t\t학기");
			System.out.println("번호\t과목명\t학점\t담당교수\t강의요일\t강의시간\t강의실\t학기");
			
			ArrayList<MylecVO> list = professorDao.myLecList();
			for(int i = 0; i < list.size(); i++){
				System.out.println(i + 1 + "\t" + list.get(i).getSubnm() + "\t" + list.get(i).getUnit()
						+ "\t" + ProfSession.loginprof.getName() + "\t" + list.get(i).getDay() + "\t"
						+ list.get(i).getTime() + "\t" + list.get(i).getRoom() + "\t" 
						+ list.get(i).getYear() + " " + list.get(i).getSemester());
			}
			System.out.println("---------------------------------------------------------------------------");
			
			System.out.println("수강생을 확인할 번호를 선택하세요. (0. 뒤로가기)");
			select = Integer.parseInt(s.nextLine());
			switch(select){
			case 0 : return;
			default : selectStu1(select);
			}
				
		}
	}
	
	public void selectStu1(int param){
		while(true){
			Scanner s = new Scanner(System.in);
			
			ArrayList<SugStdVO> sugsList = professorDao.mySugsList(param);
//			ArrayList<StudentVO> sugsList = professorDao.mySugsList(param);
			
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("번호\t학기\t\t과목명\t학번\t\t이름\t학과");
			System.out.println("---------------------------------------------------------------------------");
			for(int i = 0; i < sugsList.size(); i++){
				System.out.println(i + 1 + "\t" + sugsList.get(i).getYear() + " " 
						+ sugsList.get(i).getSemester() + "\t" + sugsList.get(i).getSubNm() 
						+ "\t" + sugsList.get(i).getStNum() + "\t" + sugsList.get(i).getStNm()
						+ "\t" + sugsList.get(i).getMajor());
//				System.out.println(i + 1 + "\t\t" + sugsList.get(i).getName() + "\t\t" 
//						+ sugsList.get(i).getMajor() + "\t\t" + sugsList.get(i).getStunum());
						
						
			}
			System.out.println("---------------------------------------------------------------------------");
			
			System.out.println();
			System.out.println("이전 화면(enter)");
			s.nextLine();
			break;
		}
	}
	
	public void insertGrade(){//2-3. 성적 기입
		while(true){
			Scanner s = new Scanner(System.in);
			int select;
											
			//반환할 리스트
			System.out.println("---------------------------"+ " 이번 학기 강의 목록입니다 " + "--------------------------");
			System.out.println("번호\t과목명\t학점\t담당교수\t강의요일\t강의시간\t강의실\t학기");		
			ArrayList<MylecVO> list = professorDao.nowList();
			for(int i = 0; i < list.size(); i++){
				System.out.println(i + 1 + "\t" + list.get(i).getSubnm() + "\t" + list.get(i).getUnit()
						+ "\t" + ProfSession.loginprof.getName() + "\t" + list.get(i).getDay() + "\t"
						+ list.get(i).getTime() + "\t" + list.get(i).getRoom() + "\t" 
						+ list.get(i).getYear() + " " + list.get(i).getSemester());
			}
			System.out.println("---------------------------------------------------------------------------");
			
			System.out.println("수강생을 확인할 과목을 선택하세요. (0. 뒤로가기)");
			
			select = Integer.parseInt(s.nextLine());
			switch(select){
			case 0 : return;
			default : selectSub(select);
			}
		}
	}
	
	public void selectSub(int param){//2-3-s. 성적기입할 과목 고르기
		while(true){
			Scanner s = new Scanner(System.in);
			int select;
			
			ArrayList<SugStdVO> sugsList = professorDao.nowStu(param);
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("번호\t학기\t\t과목명\t학번\t\t이름\t학과");
			System.out.println("---------------------------------------------------------------------------");
			for(int i = 0; i < sugsList.size(); i++){
				System.out.println(i + 1 + "\t" + sugsList.get(i).getYear() + " " 
						+ sugsList.get(i).getSemester() + "\t\t" + sugsList.get(i).getSubNm() 
						+ "\t" + sugsList.get(i).getStNum() + "\t" + sugsList.get(i).getStNm()
						+ "\t" + sugsList.get(i).getMajor());
			}
			System.out.println("---------------------------------------------------------------------------");
			
			System.out.println();
			System.out.println("성적 기입할 수강생의 번호를 입력하세요. (0. 뒤로가기)");
			select = Integer.parseInt(s.nextLine());
			switch(select){
			case 0 : return;
			default : selectStu2(select);
			}
		}
	}
	
	public void selectStu2(int param){//2-3-s-s. 성적기입 - 선택과목의 수강생 고르기
		while(true){
			Scanner s = new Scanner(System.in);
			int select;
			int lecNum = param;
			ArrayList<SugStdVO> sugsList = professorDao.nowStu(param);
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("번호\t학기\t과목명\t학번\t\t이름\t학과\t성적");
			System.out.println("---------------------------------------------------------------------------");
			for(int i = 0; i < sugsList.size(); i++){
				System.out.println(i + 1 + "\t" + sugsList.get(i).getSemester() + "\t" + sugsList.get(i).getSubNm() 
						+ "\t" + sugsList.get(i).getStNum() + "\t" + sugsList.get(i).getStNm()
						+ "\t" + sugsList.get(i).getMajor() + "\t" + sugsList.get(i).getGrade());
			}
			System.out.println("---------------------------------------------------------------------------");
		
			System.out.println();
			System.out.println("성적 기입할 수강생의 번호를 입력하세요. (0. 뒤로가기)");
			select = Integer.parseInt(s.nextLine());
			
			switch(select){
			case 0 : return;
			default : insertStGrade(select, lecNum);
			}
		}
	}
	
	public void insertStGrade(int param1, int param2){//2-3. 성적 기입juk
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("성적을 입력해주세요. : ");
			String grade = s.nextLine();
			professorDao.insertGrade(param1, param2, grade);
			System.out.println("성적 입력 완료");
			break;
								
		}						
	}
	
	public void searchProf(){//3. 교수 검색
		while(true){
			Scanner s = new Scanner(System.in); 
			int select;
			
			System.out.println("----------------------------------------------------");
			System.out.println("1. 학과로 검색");
			System.out.println("2. 사번으로 검색");
			System.out.println("3. 이름으로 검색");
			System.out.println("0. 뒤로 가기");
			System.out.println("----------------------------------------------------");
			System.out.println("검색할 방법을 고르세요.");
			
			select = Integer.parseInt(s.nextLine());
			switch(select){
			case 1 : searchByMajor(); break;
			case 2 : searchByEn(); break;
			case 3 : searchByName(); break;
			case 0 : return;
			default : break;
			}
		}
	}
	
	public void searchByMajor(){//3-1. 학과로 검색
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("학과 : ");
			String major = s.nextLine();
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("MAJOR", major);
			
			ArrayList<ProfessorVO> prList = professorDao.searchProf(param);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("번호\t사번\t학과\t이름\t전화번호\t\te-mail\t\t\t상태");
			System.out.println("-----------------------------------------------------------------------------------");
			for(int i = 0; i < prList.size(); i++){
				ProfessorVO pr = prList.get(i);
				System.out.println(i+1 + "\t" + pr.getEmpnum() + "\t" + pr.getMajor() + "\t" 
						+ pr.getName() + "\t" + pr.getTel() + "\t" + pr.getEmail() + "\t" + pr.getState());
			}
			System.out.println("-----------------------------------------------------------------------------------");
			break;
		}
	}
	
	public void searchByEn(){//3-2. 사번으로 검색
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("사번 : ");
			String en = s.nextLine();
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("EN", en);
			
			ArrayList<ProfessorVO> prList = professorDao.searchProf(param);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("번호\t사번\t학과\t이름\t전화번호\t\te-mail\t\t상태");
			System.out.println("-----------------------------------------------------------------------------------");
			for(int i = 0; i < prList.size(); i++){
				ProfessorVO pr = prList.get(i);
				System.out.println(i+1 + "\t" + pr.getEmpnum() + "\t" + pr.getMajor() + "\t" 
						+ pr.getName() + "\t" + pr.getTel() + "\t" + pr.getEmail() + "\t" + pr.getState());
			}
			System.out.println("-----------------------------------------------------------------------------------");
			break;
		}
	}
	
	public void searchByName(){//3-3. 이름으로 검색
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("이름 : ");
			String nm = s.nextLine();
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("NAME", nm);
			
			ArrayList<ProfessorVO> prList = professorDao.searchProf(param);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("번호\t사번\t학과\t이름\t전화번호\t\te-mail\t\t상태");
			System.out.println("-----------------------------------------------------------------------------------");
			for(int i = 0; i < prList.size(); i++){
				ProfessorVO pr = prList.get(i);
				System.out.println(i+1 + "\t" + pr.getEmpnum() + "\t" + pr.getMajor() + "\t" 
						+ pr.getName() + "\t" + pr.getTel() + "\t" + pr.getEmail() + "\t" + pr.getState());
			}
			System.out.println("-----------------------------------------------------------------------------------");
			break;
		}
	}
	
	public void searchSt(){//4. 학생 검색
		while(true){
			Scanner s = new Scanner(System.in);
			int select;
			
			System.out.println("----------------------------------------------------");
			System.out.println("1. 학과로 검색");
			System.out.println("2. 학번으로 검색");
			System.out.println("3. 이름으로 검색");
			System.out.println("0. 뒤로 가기");
			System.out.println("----------------------------------------------------");
			System.out.println("검색할 방법을 고르세요.");
			
			select = Integer.parseInt(s.nextLine());
			switch(select){
			case 1 : searchByMajors(); break;
			case 2 : searchBySn(); break;
			case 3 : searchByNames(); break;
			case 0 : return;
			default : break;
			}
		}
	}
	public void searchByMajors(){//4-1. 학과로 검색
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("학과 : ");
			String major = s.nextLine();
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("MAJOR", major);
			
			ArrayList<StudentVO> stList = professorDao.searchSt(param);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("번호\t학번\t\t학과\t이름\t전화번호\t\te-mail\t\t상태");
			System.out.println("-----------------------------------------------------------------------------------");
			for(int i = 0; i < stList.size(); i++){
				StudentVO st = stList.get(i);
				System.out.println(i+1 + "\t" + st.getStunum() + "\t" + st.getMajor() + "\t" 
						+ st.getName() + "\t" + st.getTel() + "\t" + st.getEmail() + "\t" + st.getState());
			}
			System.out.println("-----------------------------------------------------------------------------------");
			break;
		}
	}
	
	public void searchBySn(){//4-2. 학번으로 검색
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("학번 : ");
			String sn = s.nextLine();
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("SN", sn);
			
			ArrayList<StudentVO> stList = professorDao.searchSt(param);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("번호\t학번\t\t학과\t이름\t전화번호\t\te-mail\t\t상태");
			System.out.println("-----------------------------------------------------------------------------------");
			for(int i = 0; i < stList.size(); i++){
				StudentVO st = stList.get(i);
				System.out.println(i+1 + "\t" + st.getStunum() + "\t" + st.getMajor() + "\t" 
						+ st.getName() + "\t" + st.getTel() + "\t" + st.getEmail() + "\t" + st.getState());
			}
			System.out.println("-----------------------------------------------------------------------------------");
			break;
		}
	}
	
	public void searchByNames(){//4-3. 이름으로 검색
		while(true){
			Scanner s = new Scanner(System.in);
			System.out.print("이름 : ");
			String nm = s.nextLine();
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("NAME", nm);
			
			ArrayList<StudentVO> stList = professorDao.searchSt(param);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("번호\t학번\t\t학과\t이름\t전화번호\t\te-mail\t\t상태");
			System.out.println("-----------------------------------------------------------------------------------");
			for(int i = 0; i < stList.size(); i++){
				StudentVO st = stList.get(i);
				System.out.println(i+1 + "\t" + st.getStunum() + "\t" + st.getMajor() + "\t" 
						+ st.getName() + "\t" + st.getTel() + "\t" + st.getEmail() + "\t" + st.getState());
			}
			System.out.println("-----------------------------------------------------------------------------------");
			break;
		}
	}
//	ArrayList<StudentVO> stlist = listDao.listSt();
//	System.out.println("-----------------------------------------------------------------------------------");
//	System.out.println("번호\t\t학번\t\t학과\t\t이름\t\t전화번호\t\te-mail\t\t\t\t상태");
//	System.out.println("-----------------------------------------------------------------------------------");
//	for(int i = 0; i < stlist.size(); i++){
//		StudentVO st = stlist.get(i);
//		System.out.println(i+1 + "\t\t" + st.getStunum() + "\t\t" + st.getMajor() + "\t\t" 
//				+ st.getName() + "\t\t" + st.getTel() + "\t\t" + st.getEmail() + "\t\t" + st.getState());
//	}
//	System.out.println("-----------------------------------------------------------------------------------");

}
