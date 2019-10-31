package dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import vo.ProfessorVO;
import vo.StudentVO;
import vo.SubjectVO;
import data.Database;

public class SubjectDao {

	private static SubjectDao instance;
	
	private SubjectDao (){}
	
	public static SubjectDao getInstance(){
		if(instance == null){
			instance = new SubjectDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	
	//데이터베이스 저장
	public void insertSubject (SubjectVO user) {
		database.tb_sub.add(user);
	}
	
	// 과목번호 중복검사
	public SubjectVO selectSubject (String key, int value) {

		for(int i = 0; i < database.tb_sub.size(); i++){
			SubjectVO user = database.tb_sub.get(i);
			
			if(key.equals("SUBNUM")){
				if(user.getSubNum() == value){
					return user;
				}
			}
		}
		
		return null;
	}
	
	//
	public SubjectVO selectSubject(HashMap<String, Integer> param) {
		SubjectVO rtnUser = null;
		for (int i = 0; i < database.tb_sub.size(); i++) {
			SubjectVO user = database.tb_sub.get(i);
			boolean flag = true;

			Set<String> keys = param.keySet();
			for (String key : keys) {
				int value = param.get(key);
				if (key.equals("SUBNUM")) {
					if (!(user.getSubNum() == value)) {
						flag = false;
					}
				} else if (key.equals("SUBNAME")) {
					if (!user.getSubName().equals(value)) {
						flag = false;
					}

				}
				if (flag) {
					rtnUser = user;
				}
			}
			
		}
		return rtnUser;
	}
	
	
	
	public int changeSubject(HashMap<String, Integer> param) {
		int count = 0;
		for (int i = 0; i < database.tb_sub.size(); i++) {
			SubjectVO user = database.tb_sub.get(i);
			Set<String> keys = param.keySet();
			for (String key : keys) {
				int value = param.get(key);
				if (key.equals("SUBNUM")) {
					if (user.getSubNum() == value) {
						count = i;
					}
				}
			}
		}
		return count;
	}
	
	
	
	public SubjectVO checkSubject(HashMap<String, Integer> param) {
		SubjectVO rtnUser = null;
		for (int i = 0; i < database.tb_sub.size(); i++) {
			SubjectVO user = database.tb_sub.get(i);
			boolean flag = true;
			Set<String> keys = param.keySet();
			for (String key : keys) {
				int value = param.get(key);
				if (key.equals("SUBNUM")) {
					if (!(user.getSubNum() == value)) {
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

	
	
	public ArrayList<SubjectVO> selectSubjectList() {
		return database.tb_sub;
	}
	
}

