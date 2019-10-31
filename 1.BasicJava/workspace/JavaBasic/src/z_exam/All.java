package z_exam;

import java.util.Scanner;

public class All {

	public static void main(String[] args) {
			Scanner s= new Scanner(System.in);
			
			System.out.println("두자리의 정수를 하나 입력해주세요 : ");
			int input1 = s.nextInt();
			System.out.println("두자리의 정수를 하나 입력해주세요 : ");
			int input2 = s.nextInt();
			
			System.out.printf("입력받은 숫자들은  : %d ,%d", input1,input2);
			
	}

}
