package e_oop;

public class Static {

	public static void main(String[] args) {
		/*
		 * <<static>>
		 * - 객체 생성 없이 변수나 메서드를 사용하기 위해 붙인다.
		 * - 객체들간에 변수의  값을 공유하기 위해 붙인다.
		 * - static이 붙은 것 : 클래스 변수, 클래스 매서드
		 * - static이 붙지 않은 것 : 인스턴스 변수, 인스터스 매서드
		 */
		
		//static이 붙은 메서드
		 Math.random();
		 System.out.println();
		 
		System.out.println(ClassMember.classVariable); //static이라 따로 객체가필요없음
		ClassMember.classMethod();
		
		ClassMember cm1 = new ClassMember();  //<-인스턴스 변수 사용을 위해 
		
		System.out.println(cm1.instanceVariable);
		cm1.instanceMethod();
		
		System.out.println(cm1.classVariable);
		cm1.classMethod();
		//객체를 통해서도 클래스 멤버에 접근할 수 있지만 좋은 방법은 아니다.
	
		ClassMember cm2 = new ClassMember();
		
		//변경 전
		System.out.println("cm1 : " + cm1.instanceVariable);
		System.out.println("cm2 : " + cm2.instanceVariable);
	
		cm2.instanceVariable = "변경한 값";
		//변경 후
		System.out.println("cm1 : " + cm1.instanceVariable);
		System.out.println("cm2 : " + cm2.instanceVariable);
		
		//변경 전
		System.out.println("cm1 : " + cm1.classVariable);
		System.out.println("cm2 : " + cm2.classVariable);
		
		cm2.classVariable = "변경한 값";
		
		System.out.println("cm1 : " + cm1.classVariable);
		System.out.println("cm2 : " + cm2.classVariable);
	}

}
