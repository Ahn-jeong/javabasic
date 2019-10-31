package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import data.Database;
import vo.AdminVO;


public class AdminDao {
	
	private static AdminDao instance;
	
	private AdminDao(){}
	
	public static AdminDao getInstance(){
		if(instance == null){
			instance = new AdminDao();
		}
		return instance;
	}
	

	
	Database database = Database.getInstance();
	
	public AdminVO selectUser(String key, String value) {

		for(int i = 0; i < database.tb_admin.size(); i++){
			AdminVO user = database.tb_admin.get(i);
			
			if(key.equals("ID")){
				if(user.getadminid().equals(value)){
					return user;
				}
			}
		}
		
		return null;
	}
	
	public void insertUser(AdminVO user) {
		database.tb_admin.add(user);
	}

	public AdminVO selectUser(HashMap<String, String> param) {
		AdminVO rtnUser = null;
		
		for(int i = 0; i < database.tb_admin.size(); i++){
			AdminVO user = database.tb_admin.get(i);
			boolean flag = true;
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("ID")){
					if(!user.getadminid().equals(value)){
						flag = false;
					}
				}else if(key.equals("PASSWORD")){
					if(!user.getPwd().equals(value)){
						flag = false;
					}
				}else if(key.equals("NAME")){
					if(!user.getName().equals(value)){
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

	public ArrayList<AdminVO> selectUserList() {
		return database.tb_admin;
	}
	
}
