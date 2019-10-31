package i_collection;

import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * put() : 지정된 키와 값을 저장
		 * get() : 지정된 키의 값을 반환(없으면 null)
		 * remove() : 지정된 키로 저장된 값을 제거
		 * keySet() : 저장된 모든 키를 Set으로 반환
		 */
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("title", "제목입니다.");
		map.put("content", "내용입니다.");
		map.put("user", "김승섭");
		map.put("date", "2019-10-16 09:29");
		
		System.out.println(map.get("title"));
		System.out.println(map.get("content"));
		System.out.println(map.get("user"));
		System.out.println(map.get("date"));
		
		map.put("user", "홍길동"); //1개의 키에 여러개의 값을 저장할 수 없다.
		System.out.println(map.get("user"));
		map.put("user", "이순신");
		System.out.println(map.get("user"));
		
		map.remove("user");
		System.out.println(map.get("user"));

		//map에 저장된 모든 내용 출력
		Set<String> keys = map.keySet();
		for(String key : keys){
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
	
	}
}
