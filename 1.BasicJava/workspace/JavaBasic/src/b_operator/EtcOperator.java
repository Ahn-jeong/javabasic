package b_operator;

public class EtcOperator {

	public static void main(String[] args) {
		/*
		 *  <<비트 연산자>>
		 *  - |(OR) : 피연산자 중 한 쪽이라도 값이 1이면 1을, 그외는 0을 결과로 얻는다.
		 *  - &(AND) : 피연산자 양쪽이 모두 1이면 1을 그외는 0을 결과로 얻는다.
		 *  - ^(XOR) : 피연사자의 값이 서로다를때 1을, 같을때는 0을 결과로 얻는다.
		 *  - ~(비트전환) : 피연산자를 0은 1로, 1은 0으로 바꾼다.
		 *  - <<(쉬프트) : 피연산자의 각 자리를 왼쪽으로 이동시킨다. 빈칸은 0으로 채운다.
		 *  - >>(쉬프트) : 피연산자의 각 자리를 오른쪽으로 이동시킨다. 빈칸은 앞자리와 동일한 값으로 채운다.
		 *  
		 *  <<기타 연산자 >>
		 *  - .(참조연산자) : 특정 범위 내에 속해 있는 멤버를 지칭할 떄 사용한다.
		 *  - (type) : 형변환(casting)
		 *  - ?:(삼항연산자) : 조건식 ? 조건식이 참일 경우 수행할 문장 : 조건식이 거짓일 경우 수행할 문장
		 *  - instanceof : 참조형 타입 확인
		 */

		//1바이트는 8비트로 이루어져 있고 1비트는 0 또는 1을 표현할 수 있다.
		//즉, 1바이트는 8개의 0 또는1을 표현할수 있다.
		
		/*
		 *  - 10진수 -> 2진수 : 10진수 값을 1이 될때까지 2로 나눈다.
		 *  - 10 == 1010
		 *  - 2진수 -> 10진수 : 각 자리에 1, 2, 4, 8, 16........를 곱한값을 더한다.
		 *  
		 *  15 
		 *  7  1
		 *  3  1
		 *  1  1
		 *  15 = 1111
		 *  
		 *  1111 = 8 + 4 + 2 + 1 = 15 
		 */ 
		
		
		//00001010 : 10
		//00001111 : 15
		
		// | : 00001111
		System.out.println(10 | 15);
		
		// & : 00001010
		System.out.println(10 & 15);
		
		// ^ : 00000101
		System.out.println(10 ^ 15);
		
		// ~ : ~10 = 11110101
		System.out.println(~10);
		
		// << : 10 << 1 = 00010100
		System.out.println(10 << 1);
		
		// >> : 10 >> 1 = 00000101
		System.out.println(10 >> 1);
		
		int x = 10;
		int y = 20;
		int result = (x < y) ? x : y;
		System.out.println(result);
		
		// 시험점수가 60점 이상이면 합격 , 미만이면 불합격
		int score = 50;
		String res = (score >= 60) ? "합격" : "불합격";
		System.out.println(score + "점은" + res + "입니다.");
		
		//주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자

		int regNo = 3; //주민번호 첫자리
		String res1 = (regNo == 1) ? "남자" : "여자";
		System.out.println(res1 + "입니다.");
		
		res1 = (regNo == 1) ? "남자" : (regNo == 2) ? "여자" : "확인불가";
		System.out.println(res1 + "입니다.");
	
		res1 = (regNo == 1) ? "남자" : (regNo == 2) ? "여자" : (regNo == 3) ? "중성" : "확인불가";
		System.out.println(res1 + "입니다.");
		
		//문제1. 두개의 변수에 저장된 수 중에 큰 숫자를 출력해주세요.
		
		int s = 4;
		int t = 6;
		
		int big = (s > t) ? s : t;
		System.out.println(big);
		
		//문제2. 변수에 저장된 수의 절대값을 출력해주세요.
		int c = -100;
		int h = (c >= 0) ? c : (-c);
		System.out.println(h);
		
		//문제3. 변수에 저장된 주민등록번호 뒷자리의 첫번째 숫자가 1이나 3이면 남자
		//2나 4면 여자를 출력해주세요
		
		int regNo2 = 5;
		String res3 = (regNo2 == 1 || regNo2 ==3) ? "남자" : (regNo2 == 2 || regNo2 == 4) ? "여자" : "확인불가";
		System.out.println(res3 + "입니다.");
		
	}

}
