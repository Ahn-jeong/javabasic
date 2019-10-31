package dao;

import java.util.ArrayList;

import vo.LectureVO;
import vo.ProfessorVO;
import vo.StudentVO;
import vo.SubjectVO;
import data.Database;

public class ListDao {//리스트검색기능의 다오

	private static ListDao instance;
	
	private ListDao(){}
	
	public static ListDao getInstance(){
		if(instance == null){
			instance = new ListDao();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	public ArrayList<SubjectVO> listsubj() { //강의 전체리스트
		return database.tb_sub;	
	}
	
	public ArrayList<LectureVO> listLect() { //강의 전체리스트
		return database.tb_lec;	
	}
	
	public ArrayList<ProfessorVO> listPr(){//교수 전체 리스트 가져오기
		return database.tb_prf;
	}
	public ArrayList<StudentVO> listSt(){//학생 전체 리스트 가져오기
		return database.tb_std;
	}

}
