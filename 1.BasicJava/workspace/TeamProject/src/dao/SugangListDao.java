package dao;

import java.util.HashMap;
import java.util.Set;

import data.Database;
import data.StuSession;
import service.StudentService;
import vo.SugangListVO;

public class SugangListDao {
	
		private SugangListDao() {
		}
		private static SugangListDao instance;
		
		public static SugangListDao getInstance() {
			if (instance == null) {
				instance = new SugangListDao();
			}
			return instance;
		}
		//수강 신청취소전 확인
		Database database = Database.getInstance();
		public SugangListVO checkSugang(HashMap<String, Integer> param) { 
			SugangListVO rtnUser = null;
			for(int i = 0; i<database.tb_sug.size(); i++){
				SugangListVO user = database.tb_sug.get(i);
				boolean flag = true;
					
				Set<String> keys = param.keySet();
				for(String key : keys){
					int value = param.get(key);
					if(key.equals("SL")){
						if(user.getSugnum() != value){
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
		
		// 수강신청 중복검사
		public SugangListVO checkSugangList(HashMap<String, Integer> param) {
			SugangListVO rtnUser = null;
			for (int i = 0; i < database.tb_sug.size(); i++) {
				SugangListVO user = database.tb_sug.get(i);
				boolean flag = true;
				Set<String> keys = param.keySet();
				for (String key : keys) {
					int value = param.get(key);
					if (key.equals("LECNUM")) {
						if (user.getLec() != value || 
						!StuSession.loginstu.getStunum().equals(user.getStd())) {							
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
				
				
		public int changeSuganglist(HashMap<String, Integer> param){
			int count = 0;	
			for(int i = 0; i < database.tb_sug.size(); i++){
				SugangListVO user = database.tb_sug.get(i);
				Set<String> keys = param.keySet();
				for(String key : keys){
					Integer value = param.get(key);
					if(key.equals("SL")){
						if(user.getSugnum() == value){
							count = i;
						}
					}
				}
			}
			return count;
		}
}
