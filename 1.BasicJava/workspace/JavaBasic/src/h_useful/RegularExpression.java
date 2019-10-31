package h_useful;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식
		 * 
		 * ^ : 뒷 문자로 시작
		 * $ : 앞 문자로 시작
		 * . : 임의의 문자(줄바꿈 제외)
		 * * : 앞 문자가 0개 이상
		 * + : 앞 문자가 1개 이상
		 * ? : 앞 문자가 없거나 1개
		 * [] : 문자의 집합이나 범위([a-z] : a부터 z까지. [^a-z] : a부터 z가 아닌 것)
		 * {} : 앞 문자의 개수({2} : 2개, {2,4} : 2개 이상 4개 이하)
		 * () : 그룹화(1개의 문자처럼 인식)
		 * | : OR연산
		 * \s : 공백, 탭, 줄바꿈
		 * |S : 공백, 탭, 줄바꿈이 아닌 문자
		 * \w : 알파벳이나 숫자
		 * \W : 알파벳이나 숫자가 아닌 문자
		 * \d : 숫자
		 * \D : 숫자가 아닌 문자
		 * (?!) : 뒷 문자의 대소문자 구분 안함
		 * \ : 정규표현식에서 사용되는 특수문자 표현
		 */
		
//		String str = "abc123";
//		String regex = "[a-z]{3}[0-9]{1,3}";
//		String regex = "[a-z0-9] + ";
//		String regex = "\\w*"; \표현을 위해 \\가 사용됨
//		String regex = ".*";
		
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(str);
//		System.out.println(m.matches());
		
		//아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어 주세요.
		String regexid = "[a-z0-9!@#$%^&*]{5,20}";
		String regexnum = "010-[0-9]{4}-[0-9]{4}";
		String regexmail = "[a-z0-9]{3,30}@[a-z]{3,30}\\.com";
		
		String strid = "dkwjdgus125";
		Pattern p = Pattern.compile(regexid);
		Matcher m = p.matcher(strid);
		System.out.println(m.matches());
		
		String strnum = "010-9744-5073";
		Pattern p1 = Pattern.compile(regexnum);
		Matcher m1 = p1.matcher(strnum);
		System.out.println(m1.matches());
		
		String strmail = "dkswjdgus125@naver.com";
		Pattern p2 = Pattern.compile(regexmail);
		Matcher m2 = p2.matcher(strmail);
		System.out.println(m2.matches());
		
	}

}
