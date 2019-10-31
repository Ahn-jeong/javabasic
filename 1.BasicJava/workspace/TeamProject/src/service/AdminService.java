package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import dao.AdminDao;
import dao.LectureDao;
import dao.ListDao;
import dao.ProfessorDao;
import dao.StudentDao;
import dao.SubjectDao;
import data.Database;
import data.AdminSession;
import vo.AdminVO;
import vo.LectureVO;
import vo.ProfessorVO;
import vo.StudentVO;
import vo.SubjectVO;

public class AdminService {

	private static AdminService instance;

	private AdminService() {
	}

	public static AdminService getInstance() {
		if (instance == null) {
			instance = new AdminService();
		}
		return instance;
	}

	AdminDao adminDao = AdminDao.getInstance();
	Database database = Database.getInstance();
	ProfessorDao professorDao = ProfessorDao.getInstance();
	StudentDao studentDao = StudentDao.getInstance();
	SubjectDao subjectDao = SubjectDao.getInstance();
	LectureDao lectureDao = LectureDao.getInstance();
	ListDao listDao = ListDao.getInstance();

	public void adminlogin() {
		// 로그인
		// 아이디, 비밀번호 입력
		Scanner s = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = s.nextLine();
		System.out.print("비밀번호 : ");
		String password = s.nextLine();
		// 아이디와 비밀번호가 일치하는 회원 검색
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("ID", id);
		param.put("PASSWORD", password);

		AdminVO user = adminDao.selectUser(param);

		// 있으면 로그인
		// 없으면 로그인 실패
		if (user == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			adminlogin();
		} else {
			AdminSession.loginUser = user;
			System.out.println("로그인 성공");
			System.out.println(user.getName() + "님 환영합니다.");
		}

	}

	public void procMag() {
		Scanner s = new Scanner(System.in);
		int select;

		System.out.println("------------ 교수 관리 화면입니다. ----------------------");
		System.out.println("1. 교수 추가");
		System.out.println("2. 교수 변경");
		System.out.println("3. 교수 삭제");
		System.out.println("4. 교수 검색");
		System.out.println("0. 이전 단계");
		System.out
				.println("----------------------------------------------------");
		System.out.println("실행할 메뉴를 선택해주세요.");

		select = Integer.parseInt(s.nextLine());
		switch (select) {
		case 1:
			professorjoin();
			break;
		case 2:
			professorChange();
			break;
		case 3:
			procdel();
			break;
		case 4:
			searchProfessor();
			break;
		case 0:
			break;
		default:
			procMag();
		}
	}

	// 교수 추가
	public void professorjoin() {
		// 회원가입
		// 사용자 정보 입력
		Scanner s = new Scanner(System.in);

		System.out.println("아이디 : ");
		String id = s.nextLine();
		System.out.println("비밀번호 : ");
		String password = s.nextLine();
		System.out.println("이름 : ");
		String name = s.nextLine();
		System.out.println("학과 : ");
		String major = s.nextLine();
		System.out.println("메일 : ");
		String email = s.nextLine();
		System.out.println("전화번호 : ");
		String tel = s.nextLine();
		System.out.println("재직상태 : ");
		String state = s.nextLine();

		// 아이디 중복 검사(아이디가 일치하는 회원 검색)
		ProfessorVO user = new ProfessorVO();
		user.setEmpnum(id);// 아이디
		user.setPasswd(password);// 비밀번호
		user.setName(name);// 이름
		user.setMajor(major);// 학과
		user.setState(state);// 재직
		user.setEmail(email);// 메일
		user.setTel(tel);// 전화번호

		// 사용자 정보 저장
		ProfessorVO userCheck = professorDao.selectProf("EN", user.getEmpnum());

		if (userCheck == null) {
			professorDao.insertProfessor(user);
			System.out.println(user.getName() + "님의 가입을 환영합니다.");
			
		} else {
			System.out.println("이미 존재하는 아이디입니다.");
			
		}

	}

	// 교수 변경
	public void professorChange() {
		Scanner s = new Scanner(System.in);
		String select;
		String empnum;
		System.out.println("------------ 교수 변경 화면입니다. ------------");
		System.out.println("교수사번을 입력하세요 : ");
		empnum = s.nextLine();

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("EN", empnum);

		ProfessorVO userCheck = professorDao.selectProf(param);

		if (userCheck == null) {
			System.out.println("존재하지 않는 교수입니다..");
			procMag();
		} else {

			System.out.println("1.이름" + "\t\t" + "2.학과" + "\t\t" + "3.비밀번호" + "\t\t"
					+ "4.전화번호  " + "\t\t" + "5.이메일" + "\t\t" + "6.재직상태" + "\t\t "
					+ "0.종료");
			System.out.print("변경할 내용을 선택해주세요 : ");
			select = s.nextLine();
			System.out.println("-------------------------------------------");

			switch (select) {
			case "1":
				String name;
				System.out.println("이름을 변경해 주세요 : ");
				name = s.nextLine();
				database.tb_prf.get(professorDao.changeProf(param)).setName(
						name);
				procMag();
				break;
			case "2":
				String major;
				System.out.println("학과를 변경해 주세요 : ");
				major = s.nextLine();
				database.tb_prf.get(professorDao.changeProf(param)).setMajor(
						major);
				procMag();
				break;
			case "3":
				String password;
				System.out.println("비밀번호를 변경해 주세요 : ");
				password = s.nextLine();
				database.tb_prf.get(professorDao.changeProf(param)).setPasswd(
						password);
				procMag();
				break;
			case "4":
				String tel;
				System.out.println("전화번호를 변경해 주세요 : ");
				tel = s.nextLine();
				database.tb_prf.get(professorDao.changeProf(param)).setTel(tel);
				procMag();
				break;
			case "5":
				String email;
				System.out.println("이메일을 변경해 주세요 : ");
				email = s.nextLine();
				database.tb_prf.get(professorDao.changeProf(param)).setEmail(
						email);
				procMag();
				break;
			case "6":
				String state;
				System.out.println("재직상태를 변경해 주세요 : ");
				state = s.nextLine();
				database.tb_prf.get(professorDao.changeProf(param)).setState(
						state);
				procMag();
				break;
			case "0":
				procMag();
				break;
			default:
				professorChange();
			}

		}

	}

	// 교수삭제
	public void procdel() {
		Scanner s = new Scanner(System.in);
		String delCheck;
		String delId;

		System.out.println("------------ 교수 삭제 화면입니다. ---------------");
		System.out.println("교수 사번을 입력하세요. ");
		delId = s.nextLine();
		System.out.println("-------------------------------------------");

		// 입력한 교수의 정보 보여주고 삭제여부 묻기

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("EN", delId);

		ProfessorVO profCheck = professorDao.checkProf(param);

		if (profCheck != null) {
			System.out.println("삭제하시겠습니까? Y / N");
			delCheck = s.nextLine();
			if (delCheck.equals("Y") || delCheck.equals("y")) {
				database.tb_prf.remove(professorDao.changeProf(param));
				System.out.println("해당교수를 삭제하였습니다.");
				
			} else {
				
			}
		} else {
			System.out.println("해당교수가 존재하지 않습니다.");
			
		}
	}

	// 교수전체검색
	public void searchProfessor() {
		Scanner s = new Scanner(System.in);

		ArrayList<ProfessorVO> professorList = listDao.listPr();
		System.out.println("--------------------------------");
		System.out.println("번호\t\t사번\t\t이름\t\t상태");
		for (int i = 0; i < professorList.size(); i++) {
			ProfessorVO user = professorList.get(i);
			System.out.println(i + 1 + "\t\t" + user.getEmpnum() + "\t\t"
					+ user.getName() + "\t\t" + user.getState());
		}
		System.out.println("--------------------------------");

		System.out.println("되돌아가기 : 0");
		String end = s.nextLine();
		if (end.equals("0")) {
			procMag();
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------------

	public void stdtMag() {
		Scanner s = new Scanner(System.in);
		int select;

		System.out.println("-------------학생 관리 화면입니다. ----------------------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 변경");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 검색");
		System.out.println("0. 이전 단계");
		System.out
				.println("----------------------------------------------------");
		System.out.println("실행할 메뉴를 선택해주세요.");

		select = Integer.parseInt(s.nextLine());
		switch (select) {
		case 1:
			studentjoin();
			break;
		case 2:
			studentChange();
			break;
		case 3:
			studentdel();
			break;
		case 4:
			searchStudent();
			break;
		case 0:
			break;
		default:
			procMag();
		}
	}

	// 학생추가
	public void studentjoin() {
		// 회원가입
		// 사용자 정보 입력
		Scanner s = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = s.nextLine();
		System.out.print("비밀번호 : ");
		String password = s.nextLine();
		System.out.print("이름 : ");
		String name = s.nextLine();
		System.out.print("학과 : ");
		String major = s.nextLine();
		System.out.print("메일 : ");
		String email = s.nextLine();
		System.out.print("전화번호 : ");
		String tel = s.nextLine();
		System.out.print("재직상태 : ");
		String state = s.nextLine();

		// 아이디 중복 검사(아이디가 일치하는 회원 검색)
		StudentVO user = new StudentVO();
		user.setStunum(id);// 아이디
		user.setPassword(password);// 비밀번호
		user.setName(name);// 이름
		user.setMajor(major);// 학과
		user.setState(state);// 재학/복학
		user.setEmail(email);// 메일
		user.setTel(tel);// 전화번호

		// 사용자 정보 저장
		StudentVO userCheck = studentDao.selectStudent("SN", user.getStunum());

		if (userCheck == null) {
			studentDao.insertStudent(user);
			System.out.println(user.getName() + "님의 가입을 환영합니다.");
			
		} else {
			System.out.println("이미 존재하는 아이디입니다.");
			
		}

	}

	// 학생 변경
	public void studentChange() {
		Scanner s = new Scanner(System.in);
		String select;
		String id;
		System.out.println("------------ 학생 변경 화면입니다. ------------");
		System.out.println("학생사번을 입력하세요 : ");
		id = s.nextLine();

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("SN", id);

		StudentVO userCheck = studentDao.selectStudent(param);

		if (userCheck == null) {
			System.out.println("존재하지 않는 학생입니다..");
			stdtMag();
		} else {

			System.out.println("1.이름" + "\t\t" + "2.학과" + "\t\t" + "3.비밀번호" + "\t\t"
					+ "4.전화번호  " + "\t\t" + "5.이메일" + "\t\t" + "6.재학상태" + "\t\t "
					+ "0.종료");
			System.out.print("변경할 내용을 선택해주세요 : ");
			select = s.nextLine();
			System.out.println("-----------------------------------");

			switch (select) {
			case "1":
				String name;
				System.out.println("이름을 변경해 주세요 : ");
				name = s.nextLine();
				database.tb_std.get(studentDao.ChangeStd(param)).setName(name);
				stdtMag();
				break;
			case "2":
				String major;
				System.out.println("학과를 변경해 주세요 : ");
				major = s.nextLine();
				database.tb_std.get(studentDao.ChangeStd(param)).setMajor(major);
				stdtMag();
				break;
			case "3":
				String password;
				System.out.println("비밀번호를 변경해 주세요 : ");
				password = s.nextLine();
				database.tb_std.get(studentDao.ChangeStd(param)).setPassword(password);
				stdtMag();
				break;
			case "4":
				String tel;
				System.out.println("전화번호을 변경해 주세요 : ");
				tel = s.nextLine();
				database.tb_std.get(studentDao.ChangeStd(param)).setTel(tel);
				stdtMag();
				break;
			case "5":
				String email;
				System.out.println("이름을 변경해 주세요 : ");
				email = s.nextLine();
				database.tb_std.get(studentDao.ChangeStd(param)).setEmail(email);
				stdtMag();
				break;
			case "6":
				String state;
				System.out.println("재학상태 변경해 주세요 : ");
				state = s.nextLine();
				database.tb_std.get(studentDao.ChangeStd(param)).setState(state);
				stdtMag();
				break;
			case "0":
				stdtMag();
				break;
			default:
				studentChange();
			}

		}

	}

	// 학생삭제
	public void studentdel() {
		Scanner s = new Scanner(System.in);
		String delCheck;
		String delId;

		System.out.println("------------ 학생 삭제 화면입니다. ---------------");
		System.out.println("학생 학번을 입력하세요. ");
		delId = s.nextLine();
		System.out.println("-------------------------------------------");

		// 입력한 교수의 정보 보여주고 삭제여부 묻기

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("SN", delId);

		StudentVO profCheck = studentDao.CheckStudent(param);

		if (profCheck != null) {
			System.out.println("삭제하시겠습니까? Y / N");
			delCheck = s.nextLine();
			if (delCheck.equals("Y") || delCheck.equals("y")) {
				database.tb_std.remove(studentDao.ChangeStd(param));
				System.out.println("해당학생을 삭제하였습니다.");
				
			} else {
				
			}
		} else {
			System.out.println("해당학생이 존재하지 않습니다.");
			
		}
	}

	// 학생 검색
	public void searchStudent() {
		Scanner s = new Scanner(System.in);

		ArrayList<StudentVO> StudentList = listDao.listSt();

		System.out.println("--------------------------------");
		System.out.println("번호\t\t학번\t\t\t이름\t\t재학");
		for (int i = 0; i < StudentList.size(); i++) {
			StudentVO user = StudentList.get(i);
			System.out.println(i + 1 + "\t\t" + user.getStunum() + "\t\t"
					+ user.getName() + "\t\t" + user.getState());
		}
		System.out.println("--------------------------------");

		System.out.println("되돌아가기 : 0");
		String end = s.nextLine();
		if (end.equals("0")) {
			stdtMag();
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	// 교과목관리
	public void subMag() {
		Scanner s = new Scanner(System.in);
		int select;

		System.out.println("------------ 교과목 관리 화면입니다.-----------------------");
		System.out.println("1. 과목 추가");
		System.out.println("2. 과목 변경");
		System.out.println("3. 과목 삭제");
		System.out.println("4. 과목 검색");
		System.out.println("0. 되돌아가기");
		System.out.println("----------------------------------------------------");
		System.out.println("실행할 메뉴를 선택해주세요.");

		select = Integer.parseInt(s.nextLine());
		switch (select) {
		case 1:
			subAdd();
			break;
		case 2:
			subjectChange();
			break;
		case 3:
			subjectdel();
			break;
		case 4:
			searchSubject();
			break;
		case 0:
			break;
		default:
			subMag();
		}
	}

	// 과목 추가하기
	public void subAdd() {
		Scanner s = new Scanner(System.in);
		int subNum;
		String subName;

		System.out.println("------------ 과목 추가 화면입니다. ----------------");
		System.out.println("과목번호 : ");// 중복시 알려주기
		subNum = Integer.parseInt(s.nextLine());
		System.out.println("과목명 : ");
		subName = s.nextLine();
		System.out.println("--------------------------------------------");

		SubjectVO user = new SubjectVO();
		user.setSubNum(subNum);// 아이디
		user.setSubName(subName);// 비밀번호

//		HashMap<String, String> param = new HashMap<String, String>();
//		param.put("SUBNUM", subNum);
//		param.put("SUBNAME", subName);
		// 사용자 정보 저장
		SubjectVO userCheck = subjectDao.selectSubject("SUBNUM", user.getSubNum());

		if (userCheck == null) {
			subjectDao.insertSubject(user);
			System.out.println("과목이 개설되었습니다.");
			
		} else {
			System.out.println("이미 존재하는 과목번호입니다.");
			
		}

	}

	// 과목 변경
	public void subjectChange() {
		Scanner s = new Scanner(System.in);
		String select;
		int num;
		System.out.println("------------ 과목 변경 화면입니다. ------------");
		System.out.println("과목번호를 입력하세요 : ");
		num = Integer.parseInt(s.nextLine());

		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("SUBNUM", num);

		SubjectVO userCheck = subjectDao.selectSubject(param);

		if (userCheck == null) {
			System.out.println("존재하지 않는 과목입니다..");
			stdtMag();
		} else {
			System.out.println("1.과목번호" + "\t\t" + "2.과목명" + "\t\t " + "0.종료");
			System.out.print("변경할 내용을 선택해주세요 : ");
			select = s.nextLine();
			System.out.println("----------------------------------------");

			switch (select) {
			case "1":
				int subnum;
				System.out.println("과목번호를 변경해 주세요 : ");
				subnum = Integer.parseInt(s.nextLine());
				database.tb_sub.get(subjectDao.changeSubject(param)).setSubNum(subnum);
				stdtMag();
				break;
			case "2":
				String subname;
				System.out.println("과목번호를 변경해 주세요 : ");
				subname = s.nextLine();
				database.tb_sub.get(subjectDao.changeSubject(param)).setSubName(subname);
				stdtMag();
				break;
			case "0":
				subMag();
				break;
			default:
				subjectChange();
			}

		}

	}

	// 과목삭제
	public void subjectdel() {
		Scanner s = new Scanner(System.in);
		String delCheck;
		int delId;

		System.out.println("------------ 교과목 삭제 화면입니다. ---------------");
		System.out.println("과목번호를 입력하세요. ");
		delId = Integer.parseInt(s.nextLine());
		System.out.println("---------------------------------------------");

		// 입력한 과목의 정보 보여주고 삭제여부 묻기

		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("SUBNUM", delId);

		SubjectVO subjectCheck = subjectDao.checkSubject(param);

		if (subjectCheck != null) {
			System.out.println("삭제하시겠습니까? Y / N");
			delCheck = s.nextLine();
			if (delCheck.equals("Y") || delCheck.equals("y")) {
				database.tb_sub.remove(subjectDao.changeSubject(param));
				System.out.println("해당과목을 삭제하였습니다.");
				
			} else {
				
			}
		} else {
			System.out.println("해당과목이 존재하지 않습니다.");
			
		}
	}

	// 과목 검색하기
	public void searchSubject() {
		Scanner s = new Scanner(System.in);

		ArrayList<SubjectVO> subjectList = listDao.listsubj();
		System.out.println("-------------과목리스트입니다.-------------------");
		System.out.println("과목번호\t\t과목명");
		for (int i = 0; i < subjectList.size(); i++) {
			SubjectVO user = subjectList.get(i);
			System.out.println(user.getSubNum() + "\t\t" + user.getSubName());
		}
		System.out.println("--------------------------------------------");

		System.out.println("되돌아가기 : 0");
		String end = s.nextLine();
		if (end.equals("0")) {
			subMag();
		}
	}

	
//-----------------------------------------------------------------------------------------------------------------------------------
	
	// 강의관리화면
	public void sugMag() {
		Scanner s = new Scanner(System.in);
		int select;

		System.out.println("------------ 강의 관리 화면입니다. ---------------");
		System.out.println("1. 강의 개설");
		System.out.println("2. 강의 변경");
		System.out.println("3. 강의 삭제");
		System.out.println("4. 강의 검색");
		System.out.println("0. 되돌아가기");
		System.out.println("-------------------------------------------");
		System.out.println("실행할 메뉴를 선택해주세요.");

		select = Integer.parseInt(s.nextLine());
		switch (select) {
		case 1:
			sugAdd();
			break;
		case 2:
			lectureChange();
			break;
		case 3:
			lecturedel();
			break;
		case 4:
			searchSug();
			break;
		case 0:
			
			break;
		default:
			sugMag();
		}
	}
	
	//강의 개설하기
	public void sugAdd() {
		Scanner s = new Scanner(System.in);
		
		int lecnum; //강의 번호
		int subNum; //과목번호 (과목번호로 과목명을 가져올 키)
		String prof; //담당교수
		String day; //강의 요일
		String time; //강의 시간
		String room; //강의실
		int unit = 0; //학점
		int year = 0; //년도
		String semester; //학기

		System.out.println("------------ 강의 개설 화면입니다. 개설할 과목번호를 입력하세요.------------");
		ArrayList<LectureVO> lectureList = listDao.listLect();
		System.out.println("-------------강의리스트입니다.----------------------");
		System.out.println("강의번호\t\t강의년도\t\t학기\t\t과목번호\t\t과목명\t\t담당교수\t\t강의요일\t\t강의시간\t\t강의실");
		for (int i = 0; i < lectureList.size(); i++) {
			LectureVO user = lectureList.get(i);
			System.out.println(user.getLecnum() + "\t\t" + user.getYear() + "\t\t" + user.getSemester() + "\t\t"
					+ user.getSubNum() + "\t\t" + user.getSubName()  + user.getProfName()
					+ "\t\t" + user.getDay() + "\t\t" + user.getTime() + "\t\t" + user.getRoom());
		}
		System.out.println("-----------------------------------------------");
		System.out.println("강의번호 : ");//중복시 알려주기
		lecnum = Integer.parseInt(s.nextLine());
		ArrayList<SubjectVO> subjectList = listDao.listsubj();
		System.out.println("-------------존재하는 과목리스트입니다.-----------------");
		System.out.println("과목번호\t\t과목명");
		for (int i = 0; i < subjectList.size(); i++) {
			SubjectVO user = subjectList.get(i);
			System.out.println(user.getSubNum() + "\t\t" + user.getSubName());
		}
		System.out.println("-----------------------------------------------");
		System.out.println("과목번호 : ");//중복시 알려주기
		subNum = Integer.parseInt(s.nextLine());
		ArrayList<ProfessorVO> professorList = listDao.listPr();
		System.out.println("---------교수목록 입니다.---------------------------");
		System.out.println("번호\t\t사번\t\t이름\t\t상태");
		for (int i = 0; i < professorList.size(); i++) {
			ProfessorVO user = professorList.get(i);
			System.out.println(i + 1 + "\t\t" + user.getEmpnum() + "\t\t"
					+ user.getName() + "\t\t" + user.getState());
		}
		System.out.println("-----------------------------------------------");
		System.out.println("교수사번 : ");
		prof = s.nextLine();
		System.out.println("강의실 번호 : ");
		room = s.nextLine();
		System.out.println("수업시간 : ");
		time = s.nextLine();
		System.out.println("요일 : ");
		day = s.nextLine();
		System.out.println("학점 : ");
		unit = Integer.parseInt(s.nextLine());
		System.out.println("년도 : ");
		year = Integer.parseInt(s.nextLine());
		System.out.println("학기 : ");
		semester = s.nextLine();
		System.out.println("-----------------------------------------------");

		
		
		HashMap<String, Integer> param1 = new HashMap<String,Integer>();
		param1.put("LECNUM", lecnum);
		param1.put("SUBNUM", subNum);
		param1.put("UNIT", unit);
		param1.put("YEAR", year);
		
		
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("SUBNAME", database.tb_sub.get(subjectDao.changeSubject(param1)).getSubName());
		param.put("EN", prof);
		param.put("DAY", day);
		param.put("ROOM", room);
		param.put("TIME", time);
		
		
		LectureVO user = new LectureVO();
		user.setLecnum(lecnum);//강의번호
		user.setSubNum(subNum);//과목번호
		user.setSubName(database.tb_sub.get(subjectDao.changeSubject(param1)).getSubName());//과목명
		user.setProf(prof);//담당교수사번
		user.setProfName(database.tb_prf.get(professorDao.changeProf(param)).getName());//담당교수명
		user.setDay(day);//강의요일
		user.setTime(time);//강의시간
		user.setRoom(room);// 강의실
		user.setUnit(unit);//학점
		user.setYear(year);//년도
		user.setSemester(semester);//학기
		
		
		
		//중복체크에서 같은 요일 교수의 이름이같고 강의시간이 같을시 X, 같은 요일 강의실의 이름이 같고 강의시간이 같을시 X 
		
		LectureVO userCheck = lectureDao.selectLecture("LECNUM", user.getLecnum());
		LectureVO userCheck2 = lectureDao.selectLecture(user);
		if (userCheck2 == null && userCheck == null) {
			lectureDao.insertLec(user);
			System.out.println("강의가 개설되었습니다.");
			sugMag();
		} else {
			System.out.println("생성 할 수 없습니다.");
			sugMag();
		}
	}
	
	
	//강의변경
	public void lectureChange() {
		Scanner s = new Scanner(System.in);
		String select;
		String checkId;
		System.out.println("------------ 강의 변경 화면입니다. ------------");
		System.out.println("강의번호를 입력하세요 : ");
		checkId = s.nextLine();

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("LECNUM", checkId);

		LectureVO userCheck = lectureDao.checkLecture(param);

		if (userCheck == null) {
			System.out.println("존재하지 않는 과목입니다..");
		
			sugMag();
		} else {
			System.out.println("1.강의년도" + "\t\t" + "2.강의학기" + "\t\t " + "3.과목번호" + "\t\t " + "4.강의요일 " + "\t\t " + "5.강의실 " + "\t\t " + "6.강의시간 " + "0.종료");
			System.out.print("변경할 내용을 선택해주세요 : ");
			select = s.nextLine();
			System.out.println("-----------------------------------");

			switch (select) {
			case "1":
				int year;
				System.out.println("강의년도를 변경해 주세요 : ");
				year = Integer.parseInt(s.nextLine());
				database.tb_lec.get(lectureDao.changeLecture(param)).setYear(year);
				sugMag();
				break;
			case "2":
				String semester;
				System.out.println("강의학기를 변경해 주세요 : ");
				semester = s.nextLine();
				database.tb_lec.get(lectureDao.changeLecture(param)).setSemester(semester);
				sugMag();
				break;
			case "3":
				int subnum;
				System.out.println("과목번호를 변경해 주세요 : ");
				subnum = Integer.parseInt(s.nextLine());
				database.tb_lec.get(lectureDao.changeLecture(param)).setSubNum(subnum);
				HashMap<String, Integer> param1 = new HashMap<String, Integer>();
				param1.put("SUBNUM", subnum);
				database.tb_lec.get(lectureDao.changeLecture(param)).setSubName(database.tb_sub.get(subjectDao.changeSubject(param1)).getSubName());
				sugMag();
				break;
			case "4":
				String day;
				System.out.println("강의요일을 변경해 주세요 : ");
				day = s.nextLine();
				database.tb_lec.get(lectureDao.changeLecture(param)).setDay(day);
				sugMag();
				break;
			case "5":
				String room;
				System.out.println("강의실을 변경해 주세요 : ");
				room = s.nextLine();
				database.tb_lec.get(lectureDao.changeLecture(param)).setRoom(room);
				sugMag();
				break;
			case "6":
				String time;
				System.out.println("강의시간을 변경해 주세요 : ");
				time = s.nextLine();
				database.tb_lec.get(lectureDao.changeLecture(param)).setTime(time);
				subMag();
				break;
			default:
				lectureChange();
			}

		}

	}
	
	//강의삭제
	public void lecturedel() {
		Scanner s = new Scanner(System.in);
		String delCheck;
		String delId;

		System.out.println("------------ 강의 삭제 화면입니다. ------------");
		System.out.println("강의번호를 입력하세요. ");
		delId = s.nextLine();
		System.out.println("----------------------------------------");

		// 입력한 과목의 정보 보여주고 삭제여부 묻기

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("LECNUM", delId);

		LectureVO lectureCheck = lectureDao.checkLecture(param);

		if (lectureCheck != null) {
			System.out.println("삭제하시겠습니까? Y / N");
			delCheck = s.nextLine();
			if (delCheck.equals("Y") || delCheck.equals("y")) {
				database.tb_lec.remove(lectureDao.changeLecture(param));
				System.out.println("해당강의을 삭제하였습니다.");
				sugMag();
			} else {
				sugMag();
			}
		} else {
			System.out.println("해당강의가 존재하지 않습니다.");
			sugMag();
		}
	}
	
	//강의 검색하기
	public void searchSug() {
		Scanner s = new Scanner(System.in);

		ArrayList<LectureVO> lectureList = listDao.listLect();
		System.out.println("-------------강의리스트입니다.----------------------------------------------------------");
		System.out.println("강의번호\t\t강의년도\t\t학기\t\t과목번호\t\t과목명\t\t담당교수\t\t강의요일\t\t강의시간\t\t강의실");
		for (int i = 0; i < lectureList.size(); i++) {
			LectureVO user = lectureList.get(i);
			System.out.println(user.getLecnum() + "\t\t" + user.getYear() + "\t\t" + user.getSemester() + "\t\t"
					+ user.getSubNum() + "\t\t" + user.getSubName()  +"\t\t" +user.getProfName() 
					+ "\t\t" + user.getDay() + "\t\t" + user.getTime() + "\t\t" + user.getRoom());
		}
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("되돌아가기 : 0");
		String end = s.nextLine();
		if (end.equals("0")) {
			sugMag();
		}
	}
	
}
