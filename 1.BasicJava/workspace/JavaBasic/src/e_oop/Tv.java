package e_oop;

import java.util.Scanner;

public class Tv {

	public static void main(String[] args) {
		
		Tv t = new Tv();
		t.power();
		t.channelUp();
		t.channelUp();
		t.channelUp();
		t.volumeDown();

		
	}

//Tv를 대상으로 가능한 Tv와 비슷하게 Tv클래스를 만들어주세요.
	
	static boolean power;
	static int channel;
	static int volume;
	
	Tv(){
		power = false;
		channel = 11;
		volume = 5;
	}
	
	
	void power(){
		power = !power;
		
		System.out.println(power ? "Tv켜짐" : "Tv꺼짐");
	}
	
	void changeChannel(int channel){
		if(power && 0 < channel && channel <=100){
			this.channel = channel;
		}
		System.out.println("채널 : " + this.channel );
	}
	
	
	void channelUp(){
		if(power && channel < 100){
			changeChannel(++channel);
		}
	}
	
	void channelDown(){
		if(power && channel > 0){
			changeChannel(--channel);
		}
	}
	
	
	void volumeUp(){
		if(power &&  volume < 10){
			volume++;
		}
		showVolume(volume);
	}
	
	void volumeDown(){
		if(power &&  volume > 0){
			volume--;
		}showVolume(volume);
	}
	
	void showVolume(int volume){
		System.out.println("음량 : ");
		for(int i = 1; i <= 10; i++){
			if( i <= volume){
				System.out.printf("■ ");
			}else{
				System.out.printf("□ ");
			}
		}
		System.out.println();
	
	}
}
