package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * << 배열 >>
		 * - int[] number = new int[5]; //기본값을 초기화된다.
		 * - int number[] = int[]{10, 20, 30, 40, 50};
		 * - int[] number = {10, 20, 30, 40, 50};
		 */
		
		//배열은 참조형 타입이다.
		int[] array; //배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5]; //배열이 생성되고 그 주소가 저장된다.
		//new : 새로운 저장공간 생성 및 주소 반환
		//int[5] : int를 저장할 수 있는 5개의 공간
		//배열 초기화시 기본값이 저장된다.
		System.out.println(array); //주소가 저장되어 있다.
		System.out.println(array[0]);
		//실제값에 접근하기 위해서는 index를 지정해줘야한다.
		//index에는 int만 사용할 수 있다.(리터럴, 변수, 상수, 연산등)
		//배열의 최대 크기는 int의 최대값(약20억)이다.
		
		String arrayStr = Arrays.toString(array);
		//배열의 모든 인덱스에 저장된 값을 문자열로 반환한다.
		System.out.println(arrayStr); //int의 기본값인 0이 저장되어있따.
		
		int[] iArray1 = new int[]{1, 2, 3}; //값의 개수로 배열의 길이가 정해진다.
		int[] iArray2 = {1, 2, 3}; //선언과 초기화를 동시에 해야한다.
		int[] iArray3;
//		iArray = {1, 2, 3}; 컴파일 에러, 선언과 초기화 따로는 불가능하다.
		
		array[0] = 10; //인덱스는 0부터 시작한다.
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50; //마지막 인덱스는 배열의 길이 -1 이다
		
		
		//정수를 저장할 수 있는 길이가 10인 배열을 생성 및 초기화해주세요.
		
		int[] num = new int[10];
		
		//모든 인덱스에 있는 값을 변경해주세요
		num[0] = 10;
		num[1] = 20;
		num[2] = 30;
		num[3] = 40;
		num[4] = 50;
		num[5] = 60;
		num[6] = 70;
		num[7] = 80;
		num[8] = 90;
		num[9] = 100;
		
		//모든 인덱스에 있는 값을 더해주세요.
		
//		int sum = 0;
//		
//		for(int i = 0; i<=9; i++)
//			{
//				sum += num[i];
//			}
//		
//		System.out.println(sum );
//		
//		for(int i = 0; i < num.length; i++)
//		{
//			System.out.println(num[i]);
//		}
	
		
		//배열의 길이를 알고있다고 리터럴을 사용하는 것을 하드코딩이라고 한다.
		//길이를 알더라도 length를 사용하는것이 더 좋은 코드이다.
		
//		
//		for(int i = 0; i < num.length; i++){
//			
//			num[i] = i + 1;
//			
//		}
//		
//		System.out.println(Arrays.toString(num));
//		
//		//배열의 숫자를 저장하고 합계와 평균을 구해주세얌

		int sum = 0;
		float avg = 0;
		
		int[] number = new int[10];
		
		for(int i = 0; i < number.length; i++){
		
			number[i] = (int)(Math.random() * 10) + 1;
		}
		
		
		for(int i = 0; i< number.length; i++)
			{
				sum += number[i];
			}
		avg = (int)((sum / 10f) * 10 + 0.5) / 10f;
		
		System.out.println("합계는 : " + sum);
		System.out.println("평균은 : " + avg);
		
		
		
		//향상된 for문
		for(int numbers : number){ //배열에 있는 값을 차례대로 변수에 넣는다.
			System.out.println(numbers);
			
		}
		
		
		for(int numbers : number){
			numbers = 0; //number의 값은 변경되지 않느다.
			System.out.println(numbers);
		}
		System.out.println(Arrays.toString(number));
		
		//배열에 저장된 숫자들 중 최소값과 최대값을 찾아주세요.
		//배열의 값이 최소값보다 작으면 최소값에 배열의 값을 저장하고
		//배열의 값이 최대값보다 크면 최대값에 배열의 값을 저장한다.
		
		int min = 0;
		int max = 0;
		min = number[0];
		max = number[0];
		for(int i=0; i < number.length; i++){
			if(number[i] < min)
			{
				min = number[i];
			}
			if(number[i] > max)
			{
				max = number[i];
			}
		}
		
		System.out.println("최솟값은 : " + min + " " +"최대값은 : " + max);
		
		int i = 0;
		int[] shuffle = new int[30];
		for(i = 0; i < shuffle.length; i++){
			shuffle[i] = i+1;
		}
		for(i = 0; i < shuffle.length; i ++)
		{
				int ran = (int)(Math.random() * shuffle.length);
				int temp = shuffle[0];
				shuffle [0] = shuffle [ran];	
				shuffle [ran] = temp;
		}
		
		System.out.println(Arrays.toString(shuffle));
		//배열의 값을 섞어주세요
		//0번 인덱스의 값과 랜덤 인덱스의 값을 서로 교환한다.
		
		//배열의 길이를 변경할 수 없기 때문에 길이가 부족할 경우
		//더 큰 배열에 복사를 해야한다.
		
		int[] temp = new int[shuffle.length * 2];
		for(i = 0; i < shuffle.length; i++){
			temp[i] = shuffle[i];
		}
		shuffle = temp;
		System.out.println(Arrays.toString(shuffle));
		
		
		//배열 복사 메서드
		int[] originArray = new int[]{1, 2, 3, 4, 5};
		int[] copyArray = new int[originArray.length * 2];
		System.arraycopy(originArray, 0, copyArray, 0, originArray.length);
		System.out.println(Arrays.toString(copyArray));
	
	
	
	
	
		
		
	
	
	
	
	
	
	
	
	
	}

}
