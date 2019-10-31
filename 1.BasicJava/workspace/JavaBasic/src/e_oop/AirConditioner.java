package e_oop;

public class AirConditioner {

	public static void main(String[] args) {
		AirConditioner aircon = new AirConditioner();
		
		aircon.power();
		
		aircon.temperatureUp();
		
		System.out.println(aircon.temperature);
		
		aircon.temperatureDown();
		aircon.temperatureDown();
		
		System.out.println(aircon.temperature);
		
		aircon.airVoulme();
		
		System.out.println(aircon.airVolume);
		
		aircon.airVoulme();
		
		System.out.println(aircon.airVolume);
		
		aircon.airVoulme();
		
		System.out.println(aircon.airVolume);
		
		aircon.airVoulme();
		
		System.out.println(aircon.airVolume);
		
		
	}

	//온도가 18 ~ 30까지만 변경할 수 있게 해주시고,
	//전원을 켰을때만 버튼들이 작동되도록 매서드들을 변경해주세요.
	
	
	boolean power; // 전원
	int temperature; //온도
	int airVolume; //풍량
	
	AirConditioner(){
		power = false;
		temperature = 24;
		airVolume = 1;
	}
	
	//전원 버튼
	void power(){
		power = !power;
	}
	
	//온도+
	void temperatureUp(){
		if(power){
			if(temperature < 30){
				temperature++;
			}
		}
	}
	
	//온도-
	void temperatureDown(){
		if(power){
			if(temperature >18){
				temperature--;
			}
		}
	}
	
	//풍량 버튼
	void airVoulme(){
		if(power){
			if(3 < ++airVolume){
				airVolume = 1;
			}
		}
	}
}







