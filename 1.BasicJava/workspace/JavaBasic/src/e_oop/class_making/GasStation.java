package e_oop.class_making;

import java.util.Scanner;

public class GasStation {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.printf("경유인지 휘발유인지 선택해주세요 : ");
		String oil = s.nextLine();
	
		System.out.printf("충전ℓ(최대 999ℓ) 또는 금액을(1000원 이상 100단위) 입력해 주세요 : ");
		double literorprice = s.nextInt();
		GasStation gas = new GasStation(oil, literorprice);
		
	}
	
	int disel_price = 1350;
	int gasoline_price = 1480;
	static double total_price;
	static double liter;
	static boolean state;
	
	static void state(){
		state = !state;  //true : 주유중 , false : 주유완료
		System.out.println(state ? "주유중" : "주유완료");
	}
	
	GasStation(String a, double b){
		if(a.equals("경유") && b < 1000){
			GasStation.state();
			for(int i = 0; i <= b; i++){
				total_price = i * disel_price;
				System.out.println("충전 ℓ :" + i + "ℓ "+" 요금 : " +  GasStation.total_price);
			}
			GasStation.state();
			System.out.println("총합요금은 : " +  GasStation.total_price);
		}else if(a.equals("휘발유") && b < 1000){
			GasStation.state();
			for(int i = 0; i <= b; i++){
				total_price = i * gasoline_price;
				System.out.println("충전 ℓ :" + i + "ℓ "+" 요금 : " +  GasStation.total_price);
			}
			GasStation.state();
			System.out.println("총합요금은 : " +  GasStation.total_price);
		}
		
		if(a.equals("경유") && b >= 1000){
			GasStation.state();
			for(int i = 1000; i <= b; i +=100){
				liter = (int)( i / (double)(disel_price) * 100.0 + 0.5) / 100.0;
				System.out.println("충전ℓ : " + GasStation.liter + "ℓ " + " 요금 : " + i + "원");
			}
			GasStation.state();
			System.out.println("총 주유량 : " + GasStation.liter + "ℓ");
		}else if(a.equals("휘발유") && b >= 1000){
			GasStation.state();
			for(int i = 1000; i <= b; i +=100){
				liter = (int)(i / (double)(gasoline_price) * 100.0 + 0.5) / 100.0;
				System.out.println("충전ℓ : " + GasStation.liter + "ℓ " + " 요금 : " + i + "원");
			}
			GasStation.state();
			System.out.println("총 주유량 : " + GasStation.liter + "ℓ");
		}
		
	}
	
		
	
	
	
	
	

}
	
	