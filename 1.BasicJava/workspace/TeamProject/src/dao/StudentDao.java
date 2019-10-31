
package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import vo.LectureVO;
import vo.MylecVO;
import vo.StudentVO;
import vo.SugangListVO;
import data.Database;
import data.StuSession;

public class StudentDao {//사용자 정보 확인 다오

	private static StudentDao instance;
	
	private StudentDao(){}
	
	public static StudentDao getInstance(){
		if(instance == null){
			instance = new StudentDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	//관리자 : 학생 학번 검사
	public StudentVO selectStudent(String key, String value) {

		for (int i = 0; i < database.tb_std.size(); i++) {
			StudentVO user = database.tb_std.get(i);

			if (key.equals("SN")) {
				if (user.getStunum().equals(value)) {
					return user;
				}
			}
		}

		return null;
	}

	//학생 추가
	public void insertStudent(StudentVO user) {
		database.tb_std.add(user);
	}
	
	// 학생 인덱스 번호 찾기
	public int ChangeStd(HashMap<String, String> param) {
		int count = 0;
		for (int i = 0; i < database.tb_std.size(); i++) {
			StudentVO user = database.tb_std.get(i);
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("SN")) {
					if (user.getStunum().equals(value)) {
						count = i;
					}
				}
			}
		}
		return count;
	}
		
	// 학생 삭제전 중복찾기
	public StudentVO CheckStudent(HashMap<String, String> param) {
		StudentVO rtnUser = null;
		for (int i = 0; i < database.tb_std.size(); i++) {
			StudentVO user = database.tb_std.get(i);
			boolean flag = true;
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("SN")) {
					if (!user.getStunum().equals(value)) {
						flag = false;
					}

				}

			}
			if (flag) {
				rtnUser = user;
			}
		}
		return rtnUser;
	}

	//학생 전체 리스트
	public ArrayList<StudentVO> selectStudentList() {
		return database.tb_std;
	}
	
 	//키워드로 테이블에 저장되어 있는 값 확인해서 비교하기
	public StudentVO selectStudent(HashMap<String, String> param) { 
		StudentVO rtnUser = null;
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
				}else if(key.equals("PASSWORD")){
					if(!user.getPassword().equals(value)){
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
		for(int i = 0; i < database.tb_std.size(); i++){
			if(StuSession.loginstu.getStunum() == database.tb_std.get(i).getStunum()){
				database.tb_std.get(i).setPassword(newPw);
				break;
			}
		}
	}
	//전화번호 변경 기능
	public void changeTel(String newTel){
		for(int i = 0; i < database.tb_std.size(); i++){
			if(StuSession.loginstu.getStunum() == database.tb_std.get(i).getStunum()){
				database.tb_std.get(i).setTel(newTel);
				break;
			}
		}
	}
	//이메일 변경 기능
	public void changeEmail(String newEm){
		for(int i = 0; i < database.tb_std.size(); i++){
			if(StuSession.loginstu.getStunum() == database.tb_std.get(i).getStunum()){
				database.tb_std.get(i).setEmail(newEm);
				break;
			}
		}
	}
	
	int count = 0;
	//내 수강 신청 기능
	public SugangListVO myLecList(LectureVO lectemp){
		
		SugangListVO mySugang = new SugangListVO();
		for(int i =0; i < database.tb_lec.size(); i++) {
			if(lectemp.getSubNum() == database.tb_lec.get(i).getSubNum()) {				
				mySugang.setStd(StuSession.loginstu.getStunum());
				mySugang.setLec(database.tb_lec.get(i).getLecnum());
				count++;
				mySugang.setSugnum(count);
				database.tb_sug.add(mySugang);
			}
		}
		
		return mySugang;			
	}
	
	public ArrayList<SugangListVO> nowSearch(){
		ArrayList<SugangListVO> search = new ArrayList<SugangListVO>();
		SugangListVO user = new SugangListVO();
		LectureVO user2 = new LectureVO();
				
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
		for(int i = 0; i < database.tb_sug.size(); i++){//모든 내 수강을 돌려서
			user = database.tb_sug.get(i);//현재 학기를 담아올 변수
			
			if(StuSession.loginstu.getStunum().equals(user.getStd())){
				for(int j=0; j < database.tb_lec.size(); j++) {
					
					user2 = database.tb_lec.get(j);
					if(user.getLec() == user2.getLecnum() 										
					&& user2.getYear() == year && user2.getSemester().equals(semester)) {
						search.add(user);
					}
				}
													
			}
			
		}			
		return search;
		
	}
		
	
}



