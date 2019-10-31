package e_oop;

public class ClassMember {
	
	static String classVariable = "클래스 변수 입니다.";
	
	String instanceVariable = "인스턴스 변수입니다.";
	
	static void classMethod(){
		System.out.println("클래스 매서드입니다.");
	}
	
	void instanceMethod(){
		System.out.println("인스턴스 매서드입니다.");
	}
	
}
