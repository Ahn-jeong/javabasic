package h_useful;

public class StringSpeedTest {

	public static void main(String[] args) {
//		String str = "a";
//		
//		
//		long start = System.currentTimeMillis(); //현재시각을 밀리세컨드단위로 표현
//		for(int i = 0; i < 200000; i++){
//			str += "a";
//		}
//		long end = System.currentTimeMillis();
//		
//		System.out.println(end - start + "ms");
		
		StringBuffer sb = new StringBuffer("a");
		long start = System.currentTimeMillis();
		for(int i = 0; i < 200000; i++){
			sb.append("a"); //뒤로 계속 더함
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
	}

}
