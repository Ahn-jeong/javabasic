package e_oop;

public class JVM_Memory {

	/*
	 *  <<JVM 메모리 구조>>
	 *  - Method Area : 클래스가 저장된다.
	 *  - Call Stack : 현재 호출되어있는 메서드가 저장된다.
	 *  - Heap : 객체가 저장된다.
	 *  
	 *  운영체제 -> 프로그램
	 *  운영 체제 -> JVM -> 프로그램
	 */
	
	/*
	 * << Method Area >>
	 * - static
	 * - Math
	 * - System
	 * - PrintStream
	 * - ClassMember : classVariable, classMethod()
	 * - 
	 * << Call Stack >>
	 * - main() : cm1, cm2
	 * - random() : 실행후 삭제
	 * - println() : 실행후 삭제
	 * - println() : 실행후 삭제
	 * - println() : 실행후 삭제
	 * << Heap >>
	 * - cm1 = new ClassMember() : instanceVariable, intstanceMethod()
	 * - cm2 = new ClassMember() : instanceVariable, intstanceMethod()
	 * 
	 */
	
}
