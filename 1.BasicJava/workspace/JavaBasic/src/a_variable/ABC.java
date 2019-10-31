package a_variable;

//주석 : 프로그램 코드로 인식하지 않는 문장(주로 코드를 설명하는데 사용한다.)
//한줄 주석 : Ctrl + Shift + c
// 범위 주석 : Ctrl + shift + /(해제 : \) 

//프로그램 이란 ? 어떠한 데이터를 목적에 따라 처리하는 것이다.
//프로그램은 데이터와 처리로 구성되어 있다.

//자바 프로그램은 하나 이상의 클래스로 구성되어 있고 클래스 안에 
//데이터와 처리내용을 작성한다.
//클래스(class) : 데이터와 처리내용의 집합
//사용하고 싶은 클래스, 데이터, 처리내용 등이 있는 경우 선언을 통해 
//의사표현을 해야한다.
//선언 : 사용하고자 하는 것의 종류와 이름을 컴퓨터에게 알려주는 것.

public class ABC {
	//[] : 블럭(내용의 범위)
	
	//변수 : 데이터
	int variable; //;(세미콜론) : 문장의 마침표
	
	//매서드 : 기능
	//main 매서드 : 프로그램의 시작과 끝
	public static void main(String[] args) { 
		//Java에서는 중괄호를 선언부 옆에 넣는다.
		//블럭이 시작되면 Tab(탭) 1칸으로 계층을 표현(계층을 쉽게 구분하기 위해)
		//코드는 기본적으로 위에서 아래로 왼쪽에서 오른쪽으로 실행된다.
		//실행할 문장을 메서드 안에 넣는다.
		System.out.println("Hello");
		//괄호안에 있는 내용을 콘솔창에 출력하는 매서드
		System.out.print("Hello");//줄바꿈을 하지않는다.
		System.out.printf("%5.3f", 3.14);//출력 포멧을 지정한다.
		//코딩 : 프로그램 코드를 작성하는 것
		//main메서드의 마지막 문장까지 수행되면 프로그램은 종료된다.
		
		//예약어(키워드) : 자바에서 사용하는 특별한 의미와 기능을 가진 단어
		
		/*
		 *  1. 클래스는 변수(데이터)와 메서드(기능)으로 이루어져 있다..
		 *  2. 변수선언을 제외한 모든 문장은 매서드 안에 작성한다.
		 *  3. 선언이란 내가 사용하고자 하는 것이 무엇인지(클래스, 매서드, 변수등)
		 *     그리고 이름은 무엇인지 컴퓨터에게 알려주는 것이다.
		 */
		
		//코드는 영문을 사용하기 때문에 영타연습이 필요하다.
		//최소한 200타 이상 나오도록 연습하자!!(손가락 자리 맞춰서)
		
	
				
	}

}
