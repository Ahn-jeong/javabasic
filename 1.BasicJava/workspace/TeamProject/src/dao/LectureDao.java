package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import vo.LectureVO;
import vo.ProfessorVO;
import vo.SubjectVO;
import data.Database;

public class LectureDao {// 강의 다오

	private static LectureDao instance;

	private LectureDao() {
	}

	public static LectureDao getInstance() {
		if (instance == null) {
			instance = new LectureDao();
		}
		return instance;
	}

	Database database = Database.getInstance();

	public void insertLec(LectureVO user) {
		database.tb_lec.add(user);
	}

	public LectureVO selectLecture(String key, Integer value) {

		for (int i = 0; i < database.tb_lec.size(); i++) {
			LectureVO user = database.tb_lec.get(i);
			if (key.endsWith("LECNUM")) {
				if (user.getLecnum() == (value)) {
					return user;
				}
			}
		}

		return null;
	}

	// 강의 인덱스 찾기
	public int changeLecture(HashMap<String, String> param) {
		int count = 0;
		for (int i = 0; i < database.tb_lec.size(); i++) {
			LectureVO user = database.tb_lec.get(i);
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("LECNUM")) {
					if (user.getLecnum() == Integer.parseInt(value)) {
						count = i;
					}
				}
			}
		}
		return count;
	}

	// 강의 중복검사
	public LectureVO checkLecture(HashMap<String, String> param) {
		LectureVO rtnUser = null;
		for (int i = 0; i < database.tb_lec.size(); i++) {
			LectureVO user = database.tb_lec.get(i);
			boolean flag = true;
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("LECNUM")) {
					if (user.getLecnum() != Integer.parseInt(value)) {
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

	// 강의 개설 내용 중복검사
	public LectureVO selectLecture(LectureVO user) {
		for (int i = 0; i < database.tb_lec.size(); i++) {
			LectureVO check = database.tb_lec.get(i);
			if (user.getYear() == check.getYear()) {
				if (user.getSemester().equals(check.getSemester())) {
					if (user.getDay().equals(check.getDay())) {
						if (user.getRoom().equals(check.getRoom())) {
							if (user.getTime().equals(check.getTime())) {
								return check;
							}
						}
					}
				}
			}
			if (user.getYear() == check.getYear()) {
				if (user.getSemester().equals(check.getSemester())) {
					if (user.getDay().equals(check.getDay())) {
						if (user.getProf().equals(check.getProf())) {
							if (user.getTime().equals(check.getTime())) {
								return check;
							}
						}
					}
				}
			}

		}
		return null;
	}

	// 수강 전체 검색
	public ArrayList<LectureVO> selectLectureList() {
		return database.tb_lec;
	}

}