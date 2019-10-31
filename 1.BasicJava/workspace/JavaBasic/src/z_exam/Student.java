package z_exam;

public class Student {

	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int sum;
	float avg;
	
	Student(){
		
	}
	
	
	int getTotal(){
		int sum = 0;
		
		sum = kor + eng + math;
		
		return sum;
	}
	
	float getAverage(){
		
		float avg = (float)((int)(((kor + eng + math) / 3f) * 10 + 0.5)) / 10f;
		
		return avg;
	}
	
	Student(String a, int b, int c, int d, int e, int f){
		
		this.name = a;
		this.ban = b;
		this.no = c;
		this.kor = d;
		this.eng = e;
		this.math = f;
		this.sum = d + e + f;
		this.avg = (float)((int)((sum / 3f) * 10 + 0.5)) / 10f;
	}
	
	String info() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + sum + "," + avg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
