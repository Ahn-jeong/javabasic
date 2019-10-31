package dao;



public class Dummy {
	/*public ArrayList<ProfessorVO> searchProf(HashMap<String, String> param){
		ArrayList<ProfessorVO> prolist = new ArrayList<ProfessorVO>();
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
				}else if(key.equals("MAJOR")){
					if(user.getMajor().equals(value)){
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
	}*/
}
