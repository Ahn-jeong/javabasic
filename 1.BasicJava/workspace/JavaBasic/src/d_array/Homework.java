package d_array;

import java.util.Arrays;

public class Homework {

	public static void main(String[] args) {			
		
		//1~10사이의 난수를 500번 생성하고
		//각 숫자가 생성된 횟수를 출력해주세요
		
//			int[] a= new int[500];
//			int[] b= new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//			int[] count= new int[10];
//		
//		for(int i = 0; i< a.length; i++){
//			a[i] = (int)(Math.random()*10)+1;
//			for(int j = 0; j< b.length; j++){
//				if(a[i] == b[j]){
//					count[j] += 1;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(count));

		
		int[] counts = new int[10];
		
		for(int i = 0; i <500; i++){
			int random = (int)(Math.random() * 10)+1;
			
			counts[random - 1]++;
		}
		
		for(int i = 0; i < counts.length; i++){
			
			System.out.println(i + 1 + " : " + counts[i]);
		}
		
	

		
	}

}
