package e_oop;

import java.util.Scanner;

public class SimLiTest {
	// 9개의 질문을 9개의 메서드로 만들어주세요.
	Scanner s = new Scanner(System.in);
	String i = null;
	void start(){
		System.out.println(" Y & N로 대답해주세얌");
		method1();
	}
	
	void method1(){
		System.out.println("나는 금사빠다 : ");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			method2();
		}else if(i.equals("N") || i.equals("n")){
			method4();
		} 
	}
	
	void method2(){
		System.out.println("연애할때 끌려다니는 타입이다. : ");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			method5();
		}else if(i.equals("N") || i.equals("n")){
			method3();
		}
	}
	void method3(){
		System.out.println("데이트코스는 미리 짜는게 편하다. : ");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			method6();
		}else if(i.equals("N") || i.equals("n")){
			method5();
			
		}
	}
	void method4(){
		System.out.println("감정기복이 크지않다. : ");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			method7();
			
		}else if(i.equals("N") || i.equals("n")){
			method5();
		}
	}
	void method5(){
		System.out.println("감정표현에 솔직한 편이다. : ");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			method8();
			
		}else if(i.equals("N") || i.equals("n")){
			method6();
			
		}
	}
	void method6(){
		System.out.println("활동적인 데이트가 좋다. : ");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			method8();
		}else if(i.equals("N") || i.equals("n")){
			method9();
		}
	}
	void method7(){
		System.out.println("연락이 없어도 믿고 기다리는 편이다. : ");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			System.out.println("A타입입니다.");
		}else if(i.equals("N") || i.equals("n")){
			method8();
		}
	}
	void method8(){
		System.out.println("이성친구는 존재할 수 없다. : ");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			method9();
		}else if(i.equals("N") || i.equals("n")){
			System.out.println("b타입입니다.");
		}
	}
	void method9(){
		System.out.println("아무것도 아닌 일에 쉽게 섭섭함이 쌓인다.");
		i = s.nextLine();
		if(i.equals("Y") || i.equals("y")){
			System.out.println("D타입입니다.");
		}else if(i.equals("N") || i.equals("n")){
			System.out.println("C타입입니다.");
		}
	}
	
	
}
