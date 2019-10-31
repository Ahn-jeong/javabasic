package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.LectureVO;
import vo.MylecVO;
import vo.ProfessorVO;
import vo.StudentVO;
import vo.SubjectVO;
import vo.SugangListVO;
import dao.LectureDao;
import dao.ListDao;
import dao.StudentDao;
import dao.SugangListDao;
import data.Database;
import data.StuSession;

public class StudentService {

	/*
	 * private static StudentService instance; StudentDao studnetDao =
	 * StudentDao.getInstance();
	 */

	private StudentService() {
	}

	private static StudentService instance;

	ListDao listDao = ListDao.getInstance();

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

	Database database = Database.getInstance();
	LectureDao lectureDao = LectureDao.getInstance();
	StudentDao studentDao = StudentDao.getInstance();
	SugangListDao suganglistDao = SugangListDao.getInstance();

	public void login() {// 로그인 메서드
		Scanner s = new Scanner(System.in);
		System.out.print("학번 : ");
		String id = s.nextLine();
		System.out.print("비밀번호 : ");
		String password = s.nextLine();

		// 사번과 비밀번호 일치하는 교수 검색
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("SN", id);
		param.put("PASSWORD", password);

		StudentVO stu = studentDao.selectStudent(param);

		if (stu == null) {
			System.out.println("학번 혹은 비밀번호가 일치하지 않습니다.");
			System.out.println("로그인 화면으로 이동합니다.");
			System.out.println();
			login();
		} else {
			StuSession.loginstu = stu;
			System.out.println("로그인 성공!");
			System.out.println(stu.getName() + ", 로그인되었습니다.");
			System.out.println();
		}
	}

	public void Stuinfo() {
		Scanner s = new Scanner(System.in);
		int select;

		System.out.println("-------------- " + StuSession.loginstu.getName()
		+ " 학생의 정보입니다. -------------------");
		System.out.println("학 번\t\t: " + StuSession.loginstu.getStunum());
		System.out.println("학 과\t\t: " + StuSession.loginstu.getMajor());
		System.out.println("이 름\t\t: " + StuSession.loginstu.getName());
		System.out.println("전화번호\t\t: " + StuSession.loginstu.getTel());
		System.out.println("e-mail\t\t: " + StuSession.loginstu.getEmail());
		System.out.println("상 태\t\t: " + StuSession.loginstu.getState());
		System.out
		.println("----------------------------------------------------");
		System.out.println();
		System.out.println("1. 비밀번호변경 | 2. 전화번호변경 | 3. e-mail변경 | 0. 뒤로가기");

		select = Integer.parseInt(s.nextLine());
		switch (select) {
		case 1:
			stdpwChange();
			Stuinfo();
			break;
		case 2:
			stdtelChange();
			Stuinfo();
			break;
		case 3:
			stdemailChange();
			Stuinfo();
			break;
		case 0:
			break;
		default:
			Stuinfo();
		}

	}

	public void stdpwChange() {// 1-1. 비밀번호변경
		Scanner s = new Scanner(System.in);
		System.out.print("새로운 비밀번호 : ");
		String newPw = s.nextLine();
		studentDao.changePw(newPw);
		System.out.println("비밀번호 변경 완료");
	}

	public void stdtelChange() {// 1-2. 전화번호변경
		Scanner s = new Scanner(System.in);
		System.out.print("새로운 전화번호 : ");
		String newTel = s.nextLine();
		studentDao.changeTel(newTel);
		System.out.println("전화번호 변경 완료");
	}

	public void stdemailChange() {// 1-3. 이메일변경
		Scanner s = new Scanner(System.in);
		System.out.print("새로운 e-mail : ");
		String newEm = s.nextLine();
		studentDao.changeEmail(newEm);
		System.out.println("e-mail 변경 완료");
	}


	public void lecinfo() {
		int sel;
		Scanner s = new Scanner(System.in);
		//		System.out.println("---------------------- 강의 정보---------------------");
		//
		//		System.out
		//				.println("-----------------------------------------------------------------------------------");
		//		System.out.println("강의번호\t\t강의년도\t\t학기\t\t과목번호\t\t과목명\t\t담당교수\t\t강의요일\t\t강의시간\t\t강의실");
		//		System.out
		//				.println("-----------------------------------------------------------------------------------");

		ArrayList<LectureVO> lectureList = listDao.listLect();
		System.out.println("-------------강의리스트입니다.--------------------------------------------------------------------------------------------------------------");
		System.out.println("강의번호\t\t강의년도\t\t학기\t\t과목번호\t\t과목명\t\t담당교수\t\t강의요일\t\t강의시간\t\t강의실");
		for (int i = 0; i < lectureList.size(); i++) {
			LectureVO user = lectureList.get(i);
			System.out.println(user.getLecnum() + "\t\t" + user.getYear() + "\t\t" + user.getSemester() + "\t\t"
					+ user.getSubNum() + "\t\t" + user.getSubName()  +"\t\t"+ user.getProfName()
					+ "\t\t" + user.getDay() + "\t\t" + user.getTime() + "\t\t" + user.getRoom());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("1. 수강신청하기  2. 뒤로가기");

		sel = Integer.parseInt(s.nextLine());
		switch (sel) {
		case 1:
			Sugang();
			break;			
		case 2 :
			break;
		default:
			lecinfo();
		}
	}

	public void Sugang() {
		while(true) {		
		int sel;
		Scanner s = new Scanner(System.in);
		System.out.println("수강할 강의번호를 적어주세요");
		// 강의번호로 강의 가지고 오기
		String lecnum = s.nextLine();

		HashMap<String, Integer> lec = new HashMap<String, Integer>();
		lec.put("LECNUM", Integer.parseInt(lecnum));


		HashMap<String, String> lec2 = new HashMap<String, String>();
		lec2.put("LECNUM", lecnum);


		SugangListVO sugangCheck = suganglistDao.checkSugangList(lec);
		if(sugangCheck == null) {			
			LectureVO lectemp = database.tb_lec.get(lectureDao.changeLecture(lec2));
			SugangListVO user = studentDao.myLecList(lectemp);


			System.out.println("신청이완료되었습니다.");			
		} else {
			System.out.println("이미 신청한 강의입니다.");			
		}
		System.out.println("1. 뒤로가기");

		sel = Integer.parseInt(s.nextLine());
		switch (sel) {
		case 1:			
			return;			
		default:
			lecinfo();
			}
		}
	}

	public void SugangDel() {
		int sel;

		Scanner s = new Scanner(System.in);
		System.out.println("삭제할 강의번호를 적어주세요");

		int sl = Integer.parseInt(s.nextLine());
		// 수강리스트번호 참조해서 수강리스트의 인덱스를 찾고 데이터베이스에서  
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("SL", sl);

		SugangListVO checksugang = suganglistDao.checkSugang(param);
		if(checksugang == null) {
			System.out.println("다시 확인해주세요");
			myLeclist();
		} else {
			database.tb_sug.remove(suganglistDao.changeSuganglist(param));
			System.out.println("취소되었습니다.");
			myLeclist();
		}

	}



	public void myLeclist(){
		int sel;
		Scanner s = new Scanner(System.in);

		System.out.println("---------------- 수강신청 내역-------------------------------------------------------------------------");
		System.out.println("수강신청번호\t강의번호\t\t강의년도\t\t학기\t\t과목번호\t\t과목명\t\t담당교수\t\t강의요일\t\t강의시간\t\t강의실");
		for(int i = 0; i < database.tb_sug.size(); i++){
			SugangListVO user = database.tb_sug.get(i);
			if(StuSession.loginstu.getStunum().equals(user.getStd())){
				for(int j = 0; j < database.tb_lec.size(); j++){
					if(user.getLec() == database.tb_lec.get(j).getLecnum()){
						LectureVO user2 = database.tb_lec.get(j);
						System.out.println(user.getSugnum() +"\t\t"+  user2.getLecnum() + "\t\t" + user2.getYear() + "\t\t" + user2.getSemester() + "\t\t"
								+ user2.getSubNum() + "\t\t" + user2.getSubName()  +"\t\t"+ user2.getProfName()
								+ "\t\t" + user2.getDay() + "\t\t" + user2.getTime() + "\t\t" + user2.getRoom()); 
					}
				}
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("1. 수강취소하기 2. 뒤로 가기");
		sel = Integer.parseInt(s.nextLine());
		switch (sel) {
		case 1:
			SugangDel();
			break;			
		case 2 :
			break;
		default:
			myLeclist();
		}

	}
	public void nowSearchGrade() {

		ArrayList<SugangListVO> nowgrade = studentDao.nowSearch();	
		ArrayList<LectureVO> lectureList = listDao.listLect();
		System.out.println("---------------- 현재 성적 조회-------------------------------------------------------------------------");		
		System.out.println("수강신청번호\t강의번호\t\t강의년도\t\t학기\t\t과목명\t\t담당교수\t\t강의요일\t\t강의시간\t\t강의실\t\t성적");
		for(int i = 0; i < nowgrade.size(); i++) {
			SugangListVO now = nowgrade.get(i);
			for(int j = 0; j < lectureList.size(); j++) {				
				if(lectureList.get(j).getLecnum() == nowgrade.get(i).getLec()) {					
					System.out.println(now.getSugnum() +"\t\t" + now.getLec() +"\t\t"+lectureList.get(j).getYear() + "\t\t" 
							+ lectureList.get(j).getSemester() + "\t\t" + lectureList.get(j).getSubName() + "\t\t" + lectureList.get(j).getProfName()
							+ "\t\t" + lectureList.get(j).getDay() + "\t\t" + lectureList.get(j).getTime() +"\t\t" + lectureList.get(j).getRoom() + "\t\t" + now.getGrade());					
				}
			}


		}
	}

	public void allSearchGrade() {
		while(true) {				
			int sel;
			Scanner s = new Scanner(System.in);

			System.out.println("---------------- 전체 성적 조회-------------------------------------------------------------------------");
			for(int i = 0; i < database.tb_sug.size(); i++){
				SugangListVO user = database.tb_sug.get(i);
				if(StuSession.loginstu.getStunum().equals(user.getStd())){
					for(int j = 0; j < database.tb_lec.size(); j++){
						if(user.getLec() == database.tb_lec.get(j).getLecnum()){
							LectureVO user2 = database.tb_lec.get(j);
							System.out.println("수강신청번호\t강의번호\t\t강의년도\t\t학기\t\t과목번호\t\t과목명\t\t담당교수\t\t강의요일\t\t강의시간\t\t강의실\t\t성적");
							System.out.println(user.getSugnum() +"\t\t"+  user2.getLecnum() + "\t\t" + user2.getYear() + "\t\t" + user2.getSemester() + "\t\t"
									+ user2.getSubNum() + "\t\t" + user2.getSubName()  +"\t\t"+ user2.getProfName()
									+ "\t\t" + user2.getDay() + "\t\t" + user2.getTime() + "\t\t" + user2.getRoom() + "\t\t" +user.getGrade()); 
						}
					}
				}
			}
			System.out.println("---------------------------------------------------------------------------------------------------");	
			System.out.println("1. 뒤로 가기");
			sel = Integer.parseInt(s.nextLine());
			switch (sel) {
			case 1:			
				return;
			default:
				allSearchGrade();
			}

		}
	}



	//	public void searchstu() {// 3. 교수 검색
	//		Scanner s = new Scanner(System.in);
	//		int select;
	//
	//		System.out
	//				.println("----------------------------------------------------");
	//		System.out.println("1. 학과로 검색");
	//		System.out.println("2. 학번으로 검색");
	//		System.out.println("3. 이름으로 검색");
	//		System.out.println("0. 뒤로 가기");
	//		System.out
	//				.println("----------------------------------------------------");
	//		System.out.println("검색할 방법을 고르세요.");
	//
	//		select = Integer.parseInt(s.nextLine());
	//		switch (select) {
	//		case 1:
	//			searchByMajor();
	//			break;
	//		case 2:
	//			searchByStu();
	//			break;
	//		case 3:
	//			searchByName();
	//			break;
	//		case 0:
	//			break;
	//		default:
	//			searchstu();
	//		}
	//	}
	//
	//	private void searchByMajor() {
	//		Scanner s = new Scanner(System.in);
	//		System.out.print("학과 : ");
	//		String major = s.nextLine();
	//
	//		HashMap<String, String> param = new HashMap<String, String>();
	//		param.put("MAJOR", major);
	//
	//		ArrayList<StudentVO> prList = studentDao.searchStu(param);
	//		System.out
	//				.println("-----------------------------------------------------------------------------------");
	//		System.out.println("번호\t\t사번\t\t학과\t\t이름\t\t전화번호\t\te-mail\t\t상태");
	//		System.out
	//				.println("-----------------------------------------------------------------------------------");
	//		for (int i = 0; i < prList.size(); i++) {
	//			StudentVO pr = prList.get(i);
	//			System.out.println(i + 1 + "\t\t" + pr.getStunum() + "\t\t"
	//					+ pr.getMajor() + "\t\t" + pr.getName() + "\t\t" + pr.getTel()
	//					+ "\t\t" + pr.getEmail() + "\t\t" + pr.getState());
	//		}
	//		System.out
	//				.println("-----------------------------------------------------------------------------------");
	//		searchstu();
	//
	//	}
	//
	//	private void searchByStu() {
	//		// TODO Auto-generated method stub
	//
	//	}
	//
	//	private void searchByName() {
	//		// TODO Auto-generated method stub
	//
	//	}

}
