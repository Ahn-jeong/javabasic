package c_statement;

import java.util.Scanner;

public class RepetitiveStatement {


	public static void main(String[] args) {
		/*
//		 *  <<for 문>>
//		 *  - for(int i = 1; i <= 10; i++){}
//		 *  - for(1부터 10까지 1씩증가하며 반복){}
//		 */
//
//		for(int i = 1; i <= 10; i++){
//			//for(초기화; 조건식; 증감식){}
//			//초기화 : 조건식과 증감식에서 사용할 변수 초기화
//			//조건식 : 연산결과가 true이면 블럭안의 내용을 수행한다.
//			//증감식 : 변수를 증/감 시켜 반복문을 제어한다.
//			System.out.println(i + "번째 반복");	
//			//초기화한 변수를 블럭안에서 사용할수 있다.
//		}
//		
//		int sum = 0; //1부터 10까지 합계를 저장
//		
//		sum += 1;
//		sum += 2;
//		sum += 3;
//		sum += 4;
//		sum += 5;
//		sum += 6;
//		sum += 7;
//		sum += 8;
//		sum += 9;
//		sum += 10;
//		
//		System.out.println(sum);
//		
//		sum = 0;
//		//반복문을 사용하면 규칙이 있는 반복되는 작업을 짧게 표현할 수 있다.
//		for(int i = 1; i <= 10; i++){
//			sum += i;
//		}
//		System.out.println(sum);
//	
//	
//		sum = 0;
//		for(int i = 100; i >= 1 ; i--){
//			sum += i;
//		}
//		System.out.println(sum);
//	
//		//1부터 100까지 짝수의 합을 구해보자
//	
//	
//		sum = 0;
//		
//		for(int i = 0; i <= 100; i+=2){
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		sum = 0;
//		
//		for(int i = 1; i <= 100; i++){
//			if(i%2 == 0){
//				sum += i;
//			}
//		}
//		System.out.println(sum);
//		
//		//1부터 100까지 홀수의 합
//		sum = 0;
//		
//		for(int i = 1; i <= 100; i++){
//			if(i%2 == 1){
//				sum += i;
//			}
//		}
//		System.out.println(sum);
		
		//구구단을 출력해보자.
		/*
		 * 2 * 1 =2
		 * 2 * 2 =4
		 */
//		
//		for(int i = 1; i <= 9; i++){
//			System.out.println("2 * " + i + " = " + i*2);
//		}
//		
//		for(int i = 1; i <= 9; i++){
//			System.out.println("7 * " + i + " = " + i*7);
//		}
//		
//		
//		for(int i = 2; i <= 9; i++){
//			for(int j = 1; j <= 9; j++){
//			System.out.println(i + " * " + j + " = " + i * j);
//			}
//		}
		
		
		//구구단 전체의 짝수단의 홀수줄만 출력해주세요
//		for(int i = 2; i <= 9; i+=2){
//			for(int j = 1; j <= 9; j+=2){
//			System.out.println(i + " * " + j + " = " + i * j);
//			}
//		}
		
		//구구단 전체를 가로로 출력해주세요.
		/*
		 * 2 * 1 = 2          3 * 1 = 3        4 * 1 = 4
		 */
		
		
//		for(int i = 1; i <= 9; i++){
//			for(int j = 1; j <= 9; j++){
//			System.out.printf(j + " * " + i + " = " + j*i + "\t"); 
//			}
//			System.out.println();
//		}
		
		
		
		
		/*
		 * << while 문 >>
		 * - while(조건식){}
		 * - 조건식의 결과가 true인 동안 계속해서 반복
		 * - 반복횟수를 알 수 없을때 사용한다.
		 */
		
		Scanner s = new Scanner(System.in);
//		
//		while(true){
//			System.out.println("몇단을 출력할까요?(0 : 종료)");
//			int dan = Integer.parseInt(s.nextLine());
//			if(dan == 0)
//			{
//				System.out.println("종료되었습니다.");
//				break;
//			}
//			for(int i = 1; i<=9; i++){
//				System.out.println(dan + " * " + i + " = " + dan *1);
//			}
//		}
		/* 
		 * <<do-while문>>
		 * -do{}while(조건식);
		 * -최소한 한번의 수행을 보장한다.
		 */
		
//		//숫자 맞추기 게임을 만들어보자.
//		int answer = (int)(Math.random() * 100) +1;
//		// 1 - 100사이의 랜덤 수를 발생시킨다.
//		int input = 0;
//		
//		
//		do{
//			System.out.printf("1 ~ 100사이의 수를 입력해주세요 : ");
//			input = Integer.parseInt(s.nextLine());
//			
//			if(answer < input){
//				System.out.println(input + "보다 작습니다.");
//			}else if(input < answer){
//				System.out.println(input + "보다 큽니다.");
//			}else{
//				System.out.println("정답입니다.");
//			}
//		}while(input != answer);
		
		//이름붙은 반복문
//		outer : for(int i =2; i <= 9; i++){
//			for(int j = 1; j <= 9; j++){
//				if(j == 5){
//					break;//가장가까운 반복문을나간다
////					break outer;//outer라는 이름의 반복문을 빠져나간다.
////					continue; //가장 가까운 반복문의 현재 반복회차를 빠져간다.
////					continue outer; //outer라는 이름의 현재 반복회차를 빠져나간다.
//				}
//				System.out.println(i + " * " + j + " = " + i * j);
//			}
//			System.out.println();
//		}
		
		/*
		 * 123
		 * 
		 * 135 -> 1S 1B 1O
		 * 126 -> 2S 0B 1O
		 * 219 -> 0S 2B 1O
		 * 
		 */
		
		/*
		 *  136 -> 0s 1B 2O
		 *  217 -> 1S 1B 1O
		 *  123 -> 0S 1B 2O
		 *  318 -> 1S 0B 2O
		 *  715 -> 3S 0B 2O 
		 */
		
		
		
		
		
		
//		-----------
		
//		int num1 = 0;
//		int num2 = 0;
//		int num3 = 0;
//		
//		
//		
//		num1 = (int)(Math.random() * 9) +1;
//		
//		
//		do{
//			num2 = (int)(Math.random() * 9) +1;
//		}while(num1 == num2);
//		
//		do{
//			num3 = (int)(Math.random() * 9) +1;
//		}while(num1 == num3 || num2 == num3);
//		
//		int answer1 = 0;
//		int answer2 = 0;
//		int answer3 = 0;
//		int S;
//			do{
//				
//				System.out.printf("1번째 수를 입력해주세요 : ");
//				answer1 = Integer.parseInt(s.nextLine());
//				System.out.printf("2번째 수를 입력해주세요 : ");
//				answer2 = Integer.parseInt(s.nextLine());
//				System.out.printf("3번째 수를 입력해주세요 : ");
//				answer3 = Integer.parseInt(s.nextLine());
//				
//				S=0;
//				int B = 0;
//				int O = 0;
//				
//				if(answer1 == num1){
//					S += 1 ; 
//				}else if(answer1 == num2 || answer1 == num3){
//					B += 1 ;
//				}else{
//					O += 1;
//				}
//				if(answer2 == num2){
//					S += 1 ;  
//				}else if(answer2 == num1 || answer2 == num3){
//					B += 1 ;
//				}else{
//					O += 1;
//				}
//				if(answer3 == num3){
//					S += 1 ; 
//				}else if(answer3 == num2 || answer3 == num1){
//					B += 1 ;
//				}else{
//					O += 1;
//				}
//				System.out.println(S+"S " + B + "B "+ O +"O");
//			} while(S != 3);
//			System.out.println("정답입니다.");
		
		
		int a1, a2, a3;
		
		a1 = (int)(Math.random() * 9) +1;
		
		do{
			a2 = (int)(Math.random() * 9) +1;
		} while(a1 == a2);
		
		
		do{
			a3 = (int)(Math.random() * 9) +1;
		} while(a3 == a1 || a3 == a2);
		
		int count = 0;
		while(true){
			System.out.printf("3자리의 숫자를 입력해주세요 : ");
			int input = Integer.parseInt(s.nextLine());
			int i3 = input % 10;
			input /= 10;
			int i2 = input %10;
			input /= 10;
			int i1 = input %10;
			
			int strike = 0;
			int ball = 0;
			int out = 0;
			
			if (a1 == i1) strike ++;
			if (a2 == i2) strike ++;
			if (a3 == i3) strike ++;
			
			if (a1 == i2 || a1 == i3) ball ++;
			if (a2 == i1 || a2 == i3) ball ++;
			if (a3 == i1 || a3 == i2) ball ++;
			
			out = 3 - strike - ball;
			
			System.out.println(++count + "차 시도" + "\n" + strike + "S " + ball + "B " + out + "O" );
			
			if(strike == 3)
				System.out.println("정답입니다.");
				break;
		}
		
		
		
		
		
		
		
		
			
	}

}
