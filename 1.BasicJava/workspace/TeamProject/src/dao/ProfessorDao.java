package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import vo.LectureVO;
import vo.MylecVO;
import vo.ProfessorVO;
import vo.StudentVO;
import vo.SugStdVO;
import vo.SugangListVO;
import data.Database;
import data.ProfSession;

public class ProfessorDao {//사용자 정보 확인 다오

	private static ProfessorDao instance;
	
	private ProfessorDao(){}
	
	public static ProfessorDao getInstance(){
		if(instance == null){
			instance = new ProfessorDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	//아이디 중복 : 관리자가 쓰는 기능
	public ProfessorVO selectProf(String key, String value) {

		for(int i = 0; i < database.tb_prf.size(); i++){
			ProfessorVO user = database.tb_prf.get(i);
				
			if(key.equals("EN")){
				if(user.getEmpnum().equals(value)){
					return user;
				}
			}
		}
			
		return null;
	}
	
	//교수추가
	public void insertProfessor(ProfessorVO user) {
		database.tb_prf.add(user);
	}
	
	// 교수 인덱스 번호 찾기
	public int changeProf(HashMap<String, String> param){
		int count = 0;
		for(int i = 0; i < database.tb_prf.size(); i++){
			ProfessorVO user = database.tb_prf.get(i);
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("EN")){
					if(user.getEmpnum().equals(value)){
						count = i;
					}
				}
			}
		}
		return count;
	}
	
	//교수 삭제전 검색
	public ProfessorVO checkProf(HashMap<String, String> param) { 
		ProfessorVO rtnUser = null;
		for(int i = 0; i<database.tb_prf.size(); i++){
			ProfessorVO user = database.tb_prf.get(i);
			boolean flag = true;
				
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("EN")){
					if(!user.getEmpnum().equals(value)){
						flag = false;
					}
						
				}
					
			}
			if(flag){
				rtnUser = user;
			}
		}
		return rtnUser;
	}
	
	public ArrayList<ProfessorVO> selectProfessorList(){
		return database.tb_prf;
	}
	
 	//키워드로 테이블에 저장되어 있는 값 확인해서 비교하기
	public ProfessorVO selectProf(HashMap<String, String> param) { 
		ProfessorVO rtnUser = null;
		for(int i = 0; i<database.tb_prf.size(); i++){
			ProfessorVO user = database.tb_prf.get(i);
			boolean flag = true;
			
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("EN")){
					if(!user.getEmpnum().equals(value)){
						flag = false;
					}
				}else if(key.equals("PASSWORD")){
					if(!user.getPasswd().equals(value)){
						flag = false;
					}
				}else if(key.equals("MAJOR")){
					if(!user.getMajor().equals(value)){
						flag = false;
					}
				}else if(key.equals("NAME")){
					if(!user.getName().equals(value)){
						flag = false;
					}
				}else if(key.equals("TEL")){
					if(!user.getTel().equals(value)){
						flag = false;
					}
				}else if(key.equals("EMAIL")){
					if(!user.getEmail().equals(value)){
						flag = false;
					}
				}else if(key.equals("STATE")){
					if(!user.getState().equals(value)){
						flag = false;
					}
				}
			}
			if(flag){
				rtnUser = user;
			}
		}
		return rtnUser;
	}
	
	//비밀번호 변경 기능
	public void changePw(String newPw){
		for(int i = 0; i < database.tb_prf.size(); i++){
			if(ProfSession.loginprof.getEmpnum() == database.tb_prf.get(i).getEmpnum()){
				database.tb_prf.get(i).setPasswd(newPw);
				break;
			}
		}
	}
	//전화번호 변경 기능
	public void changeTel(String newTel){
		for(int i = 0; i < database.tb_prf.size(); i++){
			if(ProfSession.loginprof.getEmpnum() == database.tb_prf.get(i).getEmpnum()){
				database.tb_prf.get(i).setTel(newTel);
				break;
			}
		}
	}
	//이메일 변경 기능
	public void changeEmail(String newEm){
		for(int i = 0; i < database.tb_prf.size(); i++){
			if(ProfSession.loginprof.getEmpnum() == database.tb_prf.get(i).getEmpnum()){
				database.tb_prf.get(i).setEmail(newEm);
				break;
			}
		}
	}
	
	//내 강의 목록 기능
	public ArrayList<MylecVO> myLecList(){
		ArrayList<MylecVO> lecList = new ArrayList<MylecVO>();//반환할 리스트
		int cnt = 0;//기본키 값으로 넣을 변수
		for(int i = 0; i < database.tb_lec.size(); i++){
			MylecVO myLec = new MylecVO(); //리스트에 넣어줄 강의
			//for문 안에서 로그인된 사번과 강의개설 테이블의 i번째의 사번이 같을 경우
			if(ProfSession.loginprof.getEmpnum().equals(database.tb_lec.get(i).getProf())){
				cnt++;
				myLec.setDay(database.tb_lec.get(i).getDay()); //리스트에 추가한다.
				myLec.setRoom(database.tb_lec.get(i).getRoom());
				myLec.setSemester(database.tb_lec.get(i).getSemester());
				myLec.setSubNum(database.tb_lec.get(i).getSubNum());
				myLec.setTime(database.tb_lec.get(i).getTime());
				myLec.setUnit(database.tb_lec.get(i).getUnit());
				myLec.setYear(database.tb_lec.get(i).getYear());
				myLec.setLecnum(database.tb_lec.get(i).getLecnum());
				myLec.setMyLecNum(cnt);
				for(int j = 0; j < database.tb_sub.size(); j++){
					//for문 안에서 myLec의 과목번호가 과목테이블 j번째의 과목번호가 같을 경우
					if(myLec.getSubNum() == database.tb_sub.get(j).getSubNum()){
						myLec.setSubnm(database.tb_sub.get(j).getSubName());
					}
				}
				lecList.add(myLec);
			}
		}
		return lecList;
	}
	
	//내 수강생 목록 기능
	public ArrayList<SugStdVO> mySugsList(int param){//param은 이미 기본키 값이다.
		ArrayList<SugStdVO> sugsList = new ArrayList<SugStdVO>();//반환할 리스트
		ArrayList<MylecVO> myLecList = myLecList();//파라미터 값과 비교하기 위한 myLecList()의 리턴값
		int lecNum = myLecList.get(param-1).getLecnum();//강의 번호 인덱스는 기본키값-1번이다.
		int subNum = myLecList.get(param-1).getSubNum();//과목 번호
		
		int cnt = 0;
		for(int i = 0; i < database.tb_sug.size(); i++){//수강리스트 데이터 돌려서 
			SugStdVO myStd = new SugStdVO(); //리스트에 담을 SugStdVO
			if(lecNum == database.tb_sug.get(i).getLec()){//강의번호가 서로 같을 경우
				cnt++;
				myStd.setSugStdNum(cnt);//수강생 리스트 번호
				myStd.setLecNum(lecNum);//강의번호
				myStd.setSugNum(database.tb_sug.get(i).getSugnum());//수강번호
				myStd.setStNum(database.tb_sug.get(i).getStd());//학번
				myStd.setGrade(database.tb_sug.get(i).getGrade());//성적
				for(int j = 0; j < database.tb_std.size(); j++){//학생 데이터 돌려서 
					if(myStd.getStNum().equals(database.tb_std.get(j).getStunum())){//학번이 같을 경우
						myStd.setMajor(database.tb_std.get(j).getMajor());//학생의 학과
						myStd.setStNm(database.tb_std.get(j).getName());//학생 이름	
					}
				}
				for(int j = 0; j < database.tb_lec.size(); j++){//강의 데이터 돌려서
					if(myStd.getLecNum() == database.tb_lec.get(j).getLecnum()){//강의 번호가 같은 경우
						myStd.setSemester(database.tb_lec.get(j).getSemester());//학기
						myStd.setSubNm(database.tb_lec.get(j).getSubName());//과목명
						myStd.setSubNum(subNum);//과목번호
						myStd.setYear(database.tb_lec.get(j).getYear());//년도
					}
				}
				sugsList.add(myStd);
			}
		} 
//		ArrayList<StudentVO> sugsList = new ArrayList<StudentVO>();
//		for (int i = 0; i < database.tb_sug.size(); i++) {
//			if (param == database.tb_sug.get(i).getLec()) {
//				String value = database.tb_sug.get(i).getStd();
//				for (int j = 0; j < database.tb_std.size(); j++) {
//					if (value.equals(database.tb_std.get(j).getStunum())) {
//						sugsList.add(database.tb_std.get(j));
//					}
//				}
//
//			}
//		}
						
		return sugsList;
	}
	
	//현재 학기 강의 목록 가져오기 기능(성적기입)
		public ArrayList<MylecVO> nowList(){
			ArrayList<MylecVO> myLecList = myLecList();//모든 학기 전체 내 강의 리스트
			ArrayList<MylecVO> nowList = new ArrayList<MylecVO>();//반환할 리스트
			Date today = new Date();//오늘 날짜
			SimpleDateFormat sy = new SimpleDateFormat("yyyy");//오늘의 년도 빼오기
			SimpleDateFormat sm = new SimpleDateFormat("MM");//오늘의 월 빼오기
			int year = Integer.parseInt(sy.format(today));//오늘의 년도 int타입으로
			int month = Integer.parseInt(sm.format(today));//오늘의 월 int타입으로
			String semester; //학기 비교하기 위한 변수
			if(month < 9){//월이 9보다 작을때
				semester = "1학기"; //1학기로 저장
			}else{semester = "2학기";} //크면 2학기로 저장
			
			int cnt = 0;
			for(int i = 0; i < myLecList.size(); i++){//모든 내 강의를 돌려서
				MylecVO now = new MylecVO();//현재 학기를 담아올 변수
				//연도와 학기가 모두 같은 강의를 찾는다.
				if(myLecList.get(i).getYear() == year && myLecList.get(i).getSemester().equals(semester)){
					cnt++;
					now = (myLecList.get(i));
					now.setMyLecNum(cnt);
					nowList.add(now);
				}
			}
			return nowList;
		}
	
	
	
	//현재 학기에서 강의 하나에서 고른 수강생 목록 가져오기 기능(성적기입) 
	public ArrayList<SugStdVO> nowStu(int param){//param은 이미 기본키 값이다.
		ArrayList<SugStdVO> sugsList = new ArrayList<SugStdVO>();//반환할 리스트
		ArrayList<MylecVO> nowList = nowList();//파라미터 값과 비교하기 위한 myLecList()의 리턴값
		int lecNum = nowList.get(param-1).getLecnum();//강의 번호 인덱스는 기본키값-1번이다.
		int subNum = nowList.get(param-1).getSubNum();//과목 번호
		
		int cnt = 0;
		for(int i = 0; i < database.tb_sug.size(); i++){//수강리스트 데이터 돌려서 
			SugStdVO myStd = new SugStdVO(); //리스트에 담을 SugStdVO
			if(lecNum == database.tb_sug.get(i).getLec()){//강의번호가 서로 같을 경우
				cnt++;
				myStd.setSugStdNum(cnt);//수강생 리스트 번호
				myStd.setLecNum(lecNum);//강의번호
				myStd.setSugNum(database.tb_sug.get(i).getSugnum());//수강번호
				myStd.setStNum(database.tb_sug.get(i).getStd());//학번
				myStd.setGrade(database.tb_sug.get(i).getGrade());//성적
				for(int j = 0; j < database.tb_std.size(); j++){//학생 데이터 돌려서 
					if(myStd.getStNum().equals(database.tb_std.get(j).getStunum())){//학번이 같을 경우
						myStd.setMajor(database.tb_std.get(j).getMajor());//학생의 학과
						myStd.setStNm(database.tb_std.get(j).getName());//학생 이름	
					}
				}
				for(int j = 0; j < database.tb_lec.size(); j++){//강의 데이터 돌려서
					if(myStd.getLecNum() == database.tb_lec.get(j).getLecnum()){//강의 번호가 같은 경우
						myStd.setSemester(database.tb_lec.get(j).getSemester());//학기
						myStd.setSubNm(database.tb_lec.get(j).getSubName());//과목명
						myStd.setSubNum(subNum);//과목번호
						myStd.setYear(database.tb_lec.get(j).getYear());//년도
					}
				}
				sugsList.add(myStd);
			}
		}
		return sugsList;
	}
	
	//수강생 목록에서 수강생 하나 뽑기(성적 기입)
		public void insertGrade(int param1, int param2, String grade){
			//1은 강의 목록에서 선택한 학생번호, 2는 내 강의 번호 grade는 입력한 성적
			ArrayList<SugStdVO> nowStu = nowStu(param2);//내 강의 번호를 넣어서 내 강의 수강생목록 가져온다.
			SugStdVO stucheck = nowStu.get(param1-1);//내 강의 목록에서의 학생번호로 찾아온 것
			
			for(int i = 0; i < database.tb_sug.size(); i++){//수강내역 데이터 테이블 돌려서
				//stucheck의 수강번호와 수강내역의 수강번호가 같을 경우
				if(stucheck.getSugNum() == database.tb_sug.get(i).getSugnum()){
					database.tb_sug.get(i).setGrade(grade);//성적 입력한다.
				}
			}
		}
	
	//교수 검색 기능 / 키워드로 테이블에 있는 값 비교해서 리스트로 다시 리턴
	public ArrayList<ProfessorVO> searchProf(HashMap<String, String> param){
		ArrayList<ProfessorVO> prolist = new ArrayList<ProfessorVO>();
		for(int i = 0; i < database.tb_prf.size(); i++){
			ProfessorVO user = database.tb_prf.get(i);
			boolean flag = true;
			
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("EN")){
					if(!user.getEmpnum().equals(value)){
						flag = false;
					}
				}else if(key.equals("MAJOR")){
					if(!user.getMajor().equals(value)){
						flag = false;
					}
				}else if(key.equals("NAME")){
					if(!user.getName().equals(value)){
						flag = false;
					}
				}
			}
			if(flag){
				prolist.add(user);
			}
		}
		return prolist;
	}
	//학생 검색 기능 / 키워드로 테이블에 있는 값 비교해서 리스트로 다시 리턴
	public ArrayList<StudentVO> searchSt(HashMap<String, String> param){
		ArrayList<StudentVO> stlist = new ArrayList<StudentVO>();
		for(int i = 0; i<database.tb_std.size(); i++){
			StudentVO user = database.tb_std.get(i);
			boolean flag = true;
			
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("SN")){
					if(!user.getStunum().equals(value)){
						flag = false;
					}
				}else if(key.equals("MAJOR")){
					if(!user.getMajor().equals(value)){
						flag = false;
					}
				}else if(key.equals("NAME")){
					if(!user.getName().equals(value)){
						flag = false;
					}
				}
			}
			if(flag){
				stlist.add(user);
			}
		}
		return stlist;
	}
	
}
