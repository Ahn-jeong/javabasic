package e_oop;

public class OOP {
	

	public static void main(String[] args) {
		/*
		 * << 객체지향 프로그래밍 >>
		 * - 프로그래밍을 단순히 코드의 연속으로 보는것이 아니라
		 * 	 객체간의 상호작용으로 보는것.
		 * - 코드의 재사용성이 높고 유지보수가 용이하다.
		 * 
		 * << 객체 생성(인스턴스화) >>
		 * - 클래스를 사용하기 위해 메모리(Heap 영역)에 올려놓는것.
		 * - new 클래스명(); -> 객체가 저장된 메모리 주소 반환.
		 * - 객체 뒤에 참조연산자(.)를 붙여 객체의 변수와 메서드에 접근할 수 있다.
		 * - 객체는 생성될때 마다 새로운 객체가 생성되고,
		 *   여러개의 객체가 동시에 존재할 수 있다.
		 */
		
//		SampleClass sc = new SampleClass();
//
//		sc.method1();
//		
//		sc.method2(10);
//		
//		String returnString = sc.method3();
//		System.out.println(returnString);
//		
//		
//		int returnInt = sc.method4(7, 15);
//		System.out.println(returnInt);
//		
//		sc.test1();
//		
//		ClassMaker cm = new ClassMaker();
//		
//		cm.method1();
//		
//
//		System.out.println(cm.method2());
//		
//		cm.method3(250);
//		
//		System.out.println(cm.method4(10, 15));
		
//		Calculator cal = new Calculator();
//		Scanner s = new Scanner(System.in);
//		
//		System.out.println("첫번째 값을 입력해주세요 : ");
//		double i = s.nextDouble();
//		System.out.println("두번째 값을 입력해주세요 : ");
//		double j = s.nextDouble();
//		double result  = cal.sum(i, j);
//		System.out.println("덧셈값 : " + result);
//		System.out.println("곱셈값 : " + (result = cal.multiple(result, i)));
//		System.out.println("나눈몫 : " + (result = cal.divide(result, i)));
//		System.out.println("뺄셈값 : " + (result = cal.minus(result, j)));
//		System.out.println("나머지값 : " + (result = cal.low(result, i)));

		SimLiTest simli = new SimLiTest();
		simli.start();
	}
	

}
