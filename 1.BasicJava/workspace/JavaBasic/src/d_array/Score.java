package d_array;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 Java, Oracle, HTML, JQuery, JSP점수를 50~ 100까지
		 * 랜덤으로 생성시켜주고, 
		 * 석차순으로 석차, 이름, 과목별 점수, 총점, 평균을 출력해주세요.
		 * 
		 * 석차 이름  Java  Oracle  HTML  JQuery  JSP   총점   평균
		 *  1  오동규 100     100    100    100   100   500   100 
		 *
		 */

		String[] name = new String[]{"오동규", "박재욱", "오제민", "전보영", "유지상", "박신규", "진주호", "지원희", "한승희", "안정현", "이이슬", "이정은", "이선욱", "조건희", "최효은", "김혜정", "김명성", "신유진", "조윤호", "조아라", "백운영", "최도혁", "김영호", "박희제", "현솔비"};
		String[] subject = new String[]{"Java", "Oracle", "HTML", "JQuery", "JSP"}; 
 		double[][] scores = new double[name.length][subject.length + 3];  
 		int[] sum = new int[name.length];
 		int[] lank = new int[name.length];
 		double[] avg = new double[name.length];
		
		for(int i = 0; i < scores.length; i++){
			for(int j =0; j < subject.length; j++){
				scores[i][j] = (int)(Math.random() * 51) + 50; 
			}
		}
		for(int i = 0; i < scores.length; i++){
			for(int j =0; j < scores[i].length-3; j++){
				sum[i] += scores[i][j];
				scores[i][5] = sum[i];
			}
			avg[i] = (int)(sum[i] / (double)(subject.length) * 10 + 0.5) / 10.0; 
			scores[i][6] = avg[i];
		}
		
		for(int i = 0; i < name.length; i++){
			scores[i][7]++;
		}
		
		for(int i =0; i < name.length; i++){
			for(int j=0; j <name.length; j++){
				if(scores[i][5] < scores[j][5]){
					scores[i][7]++;
				}
			}
		}
		
		for(int i = 0; i < scores.length; i++){
			for(int j = i+1; j < scores.length; j++){
				if(scores[i][7] > scores[j][7]){
					double[] temp = scores[i];
					scores [i] = scores [j];
					scores [j] = temp;
					String temp2 = name[i];
					name[i] = name [j];
					name[j] = temp2;
				}
			}	
		}
		for(int i = 0; i < scores.length; i++){
			System.out.print("석차 " + scores[i][7] + " 이름: " + name[i]);
			for(int j=0; j < scores[i].length - 3; j++){
				System.out.print(" " + subject[j] + " : " + scores[i][j]);
			}
			System.out.print(" 총합 :" + scores[i][5]);
			System.out.print(" 평균 :" + scores[i][6]);
			System.out.println();
		}
		
	}

}
