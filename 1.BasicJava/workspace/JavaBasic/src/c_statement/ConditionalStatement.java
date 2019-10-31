package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 *  <<if문>>
		 *  - if : 조건식의 결과가 true이면 블럭안의 문장을 수행한다.
		 *  - else if : 다수의 조건이 필요할때 if뒤에 추가한다.
		 *  - else : 결과가 true인 조건식이 하나도 없는 경우를 위해 추가한다.
		 */
		
		
		
		int a = 10;
		
		if(a < 100){
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}
		
		if(a < 10){
			System.out.println("조건식의 연산결과가 false이면 수행되지 않는다.");
		}
		
		
		int regNo = 4;
		String gender = null;
		
		
//		if (regNo == 1){
//			gender = "남자";
//		}else if(regNo == 2){
//			gender = "여자";
//		}else if(regNo == 3){
//			gender = "남자";
//		}else if(regNo == 4){ //if 블럭 뒤에 else if(){}로 조건을 추가할 수 있다.
//			gender = "여자";
//		}else{
//			gender = "확인불가";
//	    }
//		
//		System.out.println("당신의 성별은 " + gender + " 입니다.");
//		
		//수행할 내용이 동일한 경우 논리연산자를 사용해 조건식을 결합할 수 있다.
		if (regNo == 1 || regNo ==3){
			gender = "남자";
		}else if(regNo == 2 || regNo == 4)
			gender = "여자";
		else //수행할 내용이 한문장일 경우 블럭을 생략할 수 있다.
			gender = "확인불가";
		
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		//성적에 등급을 부여하는 프로그램을 만들어보자.
		int score = 88;
		String grade = null;
		
//		if(90 <= score){
//			grade = "A";
//		}else if(80 <= score){
//			grade = "B";
//		}else if(70 <= score){
//			grade = "C";
//		}else if(60 <= score){
//			grade = "D";
//		}else{
//			grade = "불합격";
//		}
		
		System.out.println("당신의 성적은 " + grade + " 입니다.");
		
		//등급안에서 +와 -를 나누어보자.
		score = 71;
		
		if(90 <= score){
			grade = "A";
			if(97 <= score){
				grade += "+";
			}else if(93 >= score){
				grade += "-";
			}	
		}else if(80 <= score){
			grade = "B";
			if(87 <= score){
				grade += "+";
			}else if(83 >= score){
				grade += "-";
			}		
		}else if(70 <= score){
			grade = "C";
			if(77 <= score){
				grade += "+";
			}else if(73 >= score){
				grade += "-";
			}
		}else if(60 <= score){
			grade = "D";
			if(67 <= score){
				grade += "+";
			}else if(63 >= score){
				grade += "-";
			}
		}else{
			grade = "F";
		}
		System.out.println("당신의 등급은 " + grade + " 입니다.");
		
		/*
		 *  << switch 문 >>
		 *  - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 *  - 조건식의 결과는 정수와 문자열만(JDK1.7부터 문자열 허용) 허용한다.
		 */
		
		regNo = 2;
		gender = null;
		switch(regNo){ //조건식의 연산결과는 정수와 문자열만 허용한다.
			case 1 :
			case 3 : //조건식과 일치하는 case문 이후의 문장을 수행한다.
				gender = "남자";
				break; //break를 만나면 switch문을 빠져나온다.
			case 2 :
			case 4 :
				gender = "여자";
				break;
			default : //if문의 else와 같은 역할을 한다.
				gender = "확인불가";
		}
		
		score = 95;
		
		switch(score / 10){
			case 10 :
			case 9 :
				grade = "A";
				break;
			case 8 :
				grade = "B";
				break;
			case 7 :
				grade = "C";
				break;
			case 6 :
				grade = "D";
				break;
			default :
				grade = "F";
		}
		System.out.println("당신의 등급은 " + grade + " 입니다.");
		
		//문제1. 숫자를 입력받아 그 숫자가 0인지 아닌지 출력해주세요
		
		Scanner s = new Scanner(System.in);
//		System.out.printf("숫자를입력해주세요 : ");
//		int num1 = Integer.parseInt(s.nextLine());
//		
//		if(num1 == 0){
//			System.out.println("0입니다.");
//		}else{
//			System.out.println("0이아닙니다.");
//		}
//		
//		switch(num1){
//			case 0 :
//				System.out.println("0입니다.");
//			break;
//			default :
//				System.out.println("0이아닙니다.");
//		}
		
		
		// 문제2. 숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요
//		System.out.printf("숫자를입력해주세요 : ");
//		int num2 = Integer.parseInt(s.nextLine());
//		
//		if(num2 % 2 == 1){
//			System.out.println("홀수입니다.");
//		}else{
//			System.out.println("짝수입니다.");
//		}
//		
//		switch(num2 % 2){
//			case 1 :
//				System.out.println("홀수입니다.");
//			break;
//			default :
//				System.out.println("짝수입니다.");
//		}
		
		//문제3. 점수 3개를 입력받아 총점, 평균, 등급을 출력해주세요.
		System.out.println("3개의 점수를 입력해 주세요");
		int num1 = Integer.parseInt(s.nextLine());
		int num2 = Integer.parseInt(s.nextLine());
		int num3 = Integer.parseInt(s.nextLine());
		
		int sum = num1 + num2 + num3;
		double avg = (int)((sum / 3.0) * 10 + 0.5) / 10.0;
		
		if(avg >= 90 ){
			grade = "A";
		}else if(avg >= 80){
			grade = "B";
		}else if(avg >= 70){
			grade = "C";
		}else if(avg >= 60){
			grade = "D";
		}else{
			grade = "불합격";
		}
		System.out.println("점수의 총점은" + sum + "입니다.");
		System.out.println("점수의 평균은" + avg + "입니다.");
		System.out.println("점수의 등급은" + grade + "입니다.");
	}

}
