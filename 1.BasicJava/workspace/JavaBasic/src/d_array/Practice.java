package d_array;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		int[] numbers = new int[10];
		
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = (int)(Math.random() * numbers.length);
		}		
		for(int i = 0; i < numbers.length - 1; i++){
			boolean changed = false;
			for(i=0; i< numbers.length - 1 - i; i++){
				for(int j = 0; j < numbers.length; j++){
					if(numbers[j] > numbers[j+1]){
						int temp = numbers[j];
						numbers[j] = numbers[j+1];
						numbers[j+1] = temp;
						changed = true;
					}
				}
			
			}
			if(!changed) break;
		}
	
		for(int k = 0; k < numbers.length; k++){
			System.out.println(Arrays.toString(numbers));
		}
	
	
	
	}
}
