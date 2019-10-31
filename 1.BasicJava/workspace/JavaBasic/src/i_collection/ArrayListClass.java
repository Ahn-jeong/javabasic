package i_collection;

import java.util.ArrayList;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * add() : 마지막 위치에 객체를 추가
		 * get() : 지정된 위치의 객체를 반환
		 * set() : 지정된 위치에 주어진 객체를 저장(수정)
		 * remove() : 지정된 위치의 객체를 제거
		 * size() : 저장된 객체의 수 반환
		 */
		
//		ArrayList<Object> list = new ArrayList<Object>();
//		
//		list.add(10);
//		list.add("abc");
//		list.add(true);
//		list.add(new ArrayListClass());
//		
//		ArrayList<String> list2 = new ArrayList<String>();
//		
//		list2.add("abc");
//		list2.add("123");
//		list2.add("가나다");
//		list2.set(1, "456");
//		
//		for(int i = 0; i < list2.size(); i++){
//			System.out.println(list2.get(i));
//		}
//		
//		list2.remove(0);
//		//리스트에 저장된 값을 삭제하면 그뒤의 모든 값의 인덱스가 담겨진다.
//		System.out.println(list2.get(0));
//		System.out.println(list2.get(1));
//		
//		ArrayList<ArrayList<Integer>> list3 = new ArrayList<ArrayList<Integer>>(); //2차원배열
//		
//		ArrayList<Integer> list4 = new ArrayList<Integer>();
//		list4.add(10);
//		list4.add(20);
//		
//		list3.add(list4);
//	
//		list4 = new ArrayList<Integer>();
//		list4.add(20);
//	
//		list3.add(list4);
//		
//		for(int i = 0; i < list3.size(); i++){
//			System.out.println(list3.get(i));
//		}
//		
		//정수를 저장할 수 있는 ArrayList를 생성해 값을 5번 넣어주세요.
		
//		ArrayList<Integer> test1 = new ArrayList<Integer>();
//		test1.add(10);
//		test1.add(20);
//		test1.add(30);
//		test1.add(40);
//		test1.add(50);
//		
//		//위에서 만든 ArrayList에 담긴 값들의 합계와 평균을 출력해주세요.
//		int sum = 0;
//		double avg = 0;
//		
//		for(int i = 0; i < test1.size(); i++){
//			sum += test1.get(i);
//		}
//		avg = sum / test1.size();
//		System.out.println("합계 : " + sum + " " + "평균 : " + avg);
//		
//		//위에서 만든 ArrayList에 담긴 값들 중 최솟값과 최대값을 출력해주세요
//		int min = test1.get(0);
//		int max = test1.get(0);
//		for(int i = 0; i < test1.size(); i++){
//			if(test1.get(i) < min){
//				min = test1.get(i);
//			}else if(test1.get(i) > max){
//				max = test1.get(i);
//			}
//		}
//		System.out.println("최솟값 : " + min + " 최대값 : " + max);
		
		ArrayList<String> student = new ArrayList<String>();
		student.add("오동규");
		student.add("박재욱");
		student.add("오제민");
		student.add("전보영");
		student.add("유지상");
		student.add("박신규");
		student.add("진주호");
		student.add("지원희");
		student.add("한승희");
		student.add("안정현");
		student.add("이이슬");
		student.add("이정은");
		student.add("이선욱");
		student.add("조건희");
		student.add("최효은");
		student.add("김혜정");
		student.add("김명성");
		student.add("신유진");
		student.add("조윤호");
		student.add("조아라");
		student.add("백운영");
		student.add("최도혁");
		student.add("김영호");
		student.add("박희제");
		student.add("현솔비");
		
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Java");
		menu.add("Oracle");
		menu.add("HTML");
		menu.add("JQuery");
		menu.add("JSP");
		
		int rank = 1;
		
		ArrayList<ArrayList<Integer>> totalscore = new ArrayList<ArrayList<Integer>>();
		
			for(int j = 0; j < 25; j++){
				ArrayList<Integer> score = new ArrayList<Integer>();
				int sum = 0;
				score.add(rank);
				score.add((int)(Math.random() * 51) + 50); 
				score.add((int)(Math.random() * 51) + 50); 
				score.add((int)(Math.random() * 51) + 50); 
				score.add((int)(Math.random() * 51) + 50); 
				score.add((int)(Math.random() * 51) + 50); 	
				for(int i = 1; i < menu.size()+1; i++){
					sum += score.get(i);
				}
				score.add(sum);
				int avg = (sum / 5);
				score.add(avg);
				totalscore.add(score);
			}
			
			for(int i = 0; i < totalscore.size() ; i++){
				rank = 1;
				for(int j= 0; j < totalscore.size(); j++){
					if(totalscore.get(i).get(6) <= totalscore.get(j).get(6)){
						totalscore.get(i).set(0, rank++);
					}
				}
			}
			
			for(int i = 0; i < totalscore.size(); i++){
				for(int j= 0; j <totalscore.size(); j++){
					if(totalscore.get(i).get(0) < totalscore.get(j).get(0)){
						ArrayList<Integer> temp = totalscore.get(i);
						totalscore.set(i,totalscore.get(j));
						totalscore.set(j,temp);
						
						String temp2 = student.get(i);
						student.set(i, student.get(j));
						student.set(j, temp2);
					}
				}
			}
			
			System.out.println("이름\t" + "석차\t"+ "Java\t" + "Oracle\t" + "HTML\t" + "JQuery\t" + "JSP\t" + "총점\t" + "평균\t" );
			for(int i = 0; i < totalscore.size(); i++){
				System.out.print(student.get(i)+"\t");
				for(int j=0; j <totalscore.get(i).size(); j++){
					System.out.print(totalscore.get(i).get(j)+ "\t");
				}
				System.out.println();
			}
	}
}
