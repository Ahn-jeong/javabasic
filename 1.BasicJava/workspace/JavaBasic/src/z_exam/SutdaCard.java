package z_exam;

public class SutdaCard {

 	
	int num;
	boolean isKwang;
	
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	SutdaCard(){
		this(1, true);
	}
	
	String info() {
		return num + (isKwang? "k" : "");
	}

	
	
	
	
}
