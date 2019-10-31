package z_exam;

public class Exam04 {

	public static void main(String[] args) {
		
//		[4-1] 다음의 문장들을 조건식으로 표현하라.
//		1. int x 10 20 true 형 변수 가 보다 크고 보다 작을 때 인 조건식
//			10<= X && X <=20
//		2. char ch true 형 변수 가 공백이나 탭이 아닐 때 인 조건식
//			ch !=' ' && ch!='\t'
//		3. char ch ‘x' ’X' true 형 변수 가 또는 일 때 인 조건식
//			ch == 'x' || ch == "X"
//		4. char ch 형 변수 가 숫자(‘0’~‘9’)일 때 인 조건식 true
//					ch >= '0' && ch = <'9'
//		5. char ch ( ) true 형 변수 가 영문자 대문자 또는 소문자 일 때 인 조건식
//			('A'<= ch && ch <='Z') || ('a'<= ch && ch <='z')
//		6. int year 400 4 100 형 변수 가 으로 나눠떨어지거나 또는 로 나눠떨어지고 으로 나눠떨어지지
//		않을 때 인 조건식 true
//			(year % 400 ==0) || ((year % 4 ==0) && (year %100 !=0))
//		7. boolean powerOn false true 형 변수 가 일 때 인 조건식
//			powerOn == false
//		8. str “yes” true 문자열 참조변수 이 일 때 인 조건식
//			str.equals("yes")

//		[4-2] 1부터 20까지의 정수중에 2 또는3의 배수가 아닌 수의 총합을 구하시오 .
		
//		int sum = 0;
//			for(int i = 1; i<=20; i++){
//				if(i % 2 != 0 && i % 3 != 0){
//					sum += i;
//				}
//			}
//			System.out.println(sum);
//		(답73)
				
		
//		[4-3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오
		
//		int sum = 0;
//		int sum2 = 0;
//		for(int i=1; i<=10; i++ ){
//			sum += i;
//			sum2 += sum;
//		}
//		System.out.println(sum2);
//		답(220)
		
		
//		[4-4] 1+(-2)+3+(-4)+... , 과 같은 식으로 계속 더해나갔을 때 몇까지 더해야 총합이
//		100 . 이상이 되는지 구하시오
		
//		int sum = 0;
//		int i = 1;
//		while(sum <= 100)
//		{
//			sum = i-(i+1)+(i+2)-(i+3);
//			i++;
//			sum += sum;
//		}
//		System.out.println(sum);
//		
//		4-5] 다음의 문을 문으로 변경하시오 for while .
//
//		int i = 0;
//		while(i <=10){
//			int j = 0;
//			while(j++ <= i){
//				System.out.printf("*");
//			}
//			System.out.println();
//			i++;
//		}
////	
		
		
//		[4-6] 두 개의 주사위를 던졌을 때 눈의 합이 이 되는 모든 경우의 수를 출력하는 프 , 6
//		로그램을 작성하시오
		
//		
//		int sum = 0;
//		for(int i = 1; i<=6; i++){
//			for(int j =1; j<=6; j++){
//				sum = i+j;
//				if(sum == 6){
//					System.out.println("두눈의 합이 6이 되는경우는" + i  + "와" + j);
//				}
//			}
//		}
//			
//		[4-7] Math.random() 1 6 value 을 이용해서 부터 사이의 임의의 정수를 변수 에 저장하는
//		코드를 완성하라 에 알맞은 코드를 넣으시오 . (1) .
		
//			int value = (int)((Math.random()*6)+1);
//			System.out.println("value:"+value);
		
		
//		[4-8] 방정식 의 모든 해를 구하시오 단 와 는 정수이고 각각의 범위는 2x+4y=10 . , x y
//				0<=x<=10, 0<=y<=10 . 
//			int num = 0;
//			for(int x =0; x<=10; x++){
//				for(int y=0; y<=10; y++){
//					num = (2*x) + (4*y); 
//					if(num == 10){
//						System.out.println("x = " + x + " " + "y = " + y);
//					}
//				}
//			}
		
		
		
//		[4-10] int num , 타입의 변수 이 있을 때 각 자리의 합을 더한 결과를 출력하는 코드를
//		완성하라 만일 변수 의 값이 라면 . num 12345 , ‘1+2+3+4+5’ 15 의 결과인 를 출력하라. (1)
//		에 알맞은 코드를 넣으시오.
		
		
//			int num = 12345;
//			int sum = 0;
//			
//			while(num > 0){
//				sum += num % 10;
//				num/=10;
//			}
//			 
//		
//			System.out.println("sum="+sum);
//		
//		[4-11] 피보나치 수열 은 앞을 두 수를 더해서 다음 수를 만들어 나가 (Fibonnaci) ( ) 數列
//		는 수열이다 예를 들어 앞의 두 수가 과 이라면 그 다음 수는 가 되고 그 다음 수는 . 1 1 2
//		1 2 3 1,1,2,3,5,8,13,21,... . 1 1 과 를 더해서 이 되어서 과 같은 식으로 진행된다 과 부터
//		시작하는 피보나치수열의 번째 수는 무엇인지 계산하는 프로그램을 완성하시오 10 .

//			int num1 = 1;
//			int num2 = 1;
//			int num3 = 0; // 세번째 값
//			System.out.print(num1+","+num2);
//			for (int i = 0 ; i < 8 ; i++ ) {
//				
//				num3 = num1 + num2;
//				num1 = num2;
//				num2 = num3;
//				System.out.printf("," + num3);
//			}

		
		
//		[4-13] 다음은 주어진 문자열 이 숫자인지를 판별하는 프로그램이다 에 알맞 (value) . (1)
//		은 코드를 넣어서 프로그램을 완성하시오.
		
		
//			String value = "12o34";
//			char ch = ' ';
//			boolean isNumber = true;
//			for(int i=0; i < value.length() ;i++) {	
//				ch = value.charAt(i);
//				if(!('0' <= ch && ch <='9')){
//					isNumber = false;
//				}
//			}
//			if (isNumber) {
//			System.out.println(value+"는 숫자입니다."); 
//			} else {
//			System.out.println(value+" 는 숫자가 아닙니다."); 
//		}
		
//		[4-14] 다음은 숫자맞추기 게임을 작성한 것이다 과 사이의 값을 반복적으로 입력 . 1 100
//		해서 컴퓨터가 생각한 값을 맞추면 게임이 끝난다 사용자가 값을 입력하면 컴퓨터는 자 . ,
//		신이 생각한 값과 비교해서 결과를 알려준다 사용자가 컴퓨터가 생각한 숫자를 맞추면 .
//		게임이 끝나고 몇 번 만에 숫자를 맞췄는지 알려준다 에 알맞은 코드를 넣어 프 . (1)~(2)
//		로그램을 완성하시오.

			
			
//			int answer = (int)(Math.random()*100)+1;
//			int input = 0; 
//			int count = 0; 
//		
//			java.util.Scanner s = new java.util.Scanner(System.in);
//			do {
//				count++;
//				System.out.print("1 과 100사이의 값을 입력하세요 :");
//				input = s.nextInt(); 
//				if(input > answer){
//					System.out.println(input + "보다 낮습니다.");
//				}else if(input < answer){
//					System.out.println(input + "보다 높습니다.");
//				}else{
//					System.out.println("정답입니다." + "\n" + "시도횟수는 : " + count +" 회 입니다.");
//					break;
//				}
//			} while(true); 
			
		
//		[4-15] 다음은 회문수를 구하는 프로그램이다 회문수 란 숫자를 거꾸로 읽 . (palindrome) ,
//		어도 앞으로 읽는 것과 같은 수를 말한다 예를 들면 이나 같은 수를 말한 . ‘12321’ ‘13531’
//		다 에 알맞은 코드를 넣어서 프로그램을 완성하시오 . (1) .

//		
//			int number = 12321;
//			int tmp = number;
//			int result =0; // number 변수 를 거꾸로 변환해서 담을 변수
//			while(tmp !=0) {
//				
//				result *= 10;
//				result += tmp%10;
//				tmp /= 10;
//			}
//			if(number == result)
//			System.out.println( number + "는 회문수 입니다."); 
//			else
//			System.out.println( number + "아닙니다.");
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
