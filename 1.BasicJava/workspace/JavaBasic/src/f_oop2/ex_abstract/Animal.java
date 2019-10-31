package f_oop2.ex_abstract;

public abstract class Animal {

	void run(){
		System.out.println("달려간다요~~");
	}
	
	abstract void bark();
	
}

class Dog extends Animal{

	@Override
	void bark() {
		System.out.println("제가꼭짖어야할까요!!");
	}
}

class Pig extends Animal{

	@Override
	void bark() {
		System.out.println("꾸에에엑!!");
	}
}

class Cow extends Animal{

	@Override
	void bark() {
		System.out.println("으우우음메어에!!");
	}
}
