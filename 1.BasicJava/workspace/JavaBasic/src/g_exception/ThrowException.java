package g_exception;

import java.io.IOException;

public class ThrowException {

	public static void main(String[] args) {
		/*
		 * << 예외 발새시키기 >>
		 * - throw new Exception();
		 * - throw 키워드와 예외 클래스의 객체로 예외를 고의로 발생시킬 수 있다.
		 */

		IOException ioe = new IOException();
		try {
			throw ioe; //예외를 고의로 발생시킬 수 있다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		throw new NullPointerException("예외가 발생한 원인");
		
		
//		System.out.println("여기는 수행되지 않아요.");
	}

}





