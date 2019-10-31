package z_exam;


public class Exam07 {

	public static void main(String[] args) {

//		[7-3] 오버라이딩의 정의와 필요성에 대해서 설명하시오.
//		부모클래스로 부터 물려받은 메서드를 자식 메서드에서 재정의하는것.
//		부모클래스로부터 받은 메서드의 내용을 자식클래스에서 필요에의해 재정의할때 필요하다.
		
		
//		[7-4] 다음 중 오버라이딩의 조건으로 옳지 않은 것은? (모두 고르시오)
//				a. 조상의 메서드와 이름이 같아야 한다.
//				b. 매개변수의 수와 타입이 모두 같아야 한다.
//				c. 접근 제어자는 조상의 메서드보다 좁은 범위로만 변경할 수 있다.
//				d. 조상의 메서드보다 더 많은 수의 예외를 선언할 수 있다. 
//		(C,D)
		
//		[7-5] 다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기
//		위해서는 코드를 어떻게 바꾸어야 하는가?
		
//		Tv() {} - >  Tv(int price) {
//							super(price);
//							
//					 }
//		기본생성자의 경우 컴파일러가 알아서 해주지만
//		직접 작성한 자식 클래스의 생성자는 첫줄에는 super()가 있어야 한다.
		
//		[7-6] 자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야하는 이유는 무엇인
//		가?
//		조상 클래스 멤버의 초기화 작업이 수행되어야 조상클래스의 멤버를 사용할수 있기때문에
//		그런 이유로 생성자의 첫줄에서 조상클래스의 생성자를 호출하고 생성자를 생성하지 않으면
//		컴파일러가 생성자의 첫줄에 자동으로 super();를 추가시킨다.
	
//		[7-7] 다음 코드의 실행했을 때 호출되는 생성자의 순서와 실행결과를 적으시오.
//		child() -> child(int x)  ->  Parent() -> parent(int x)
	
//		[7-8] 다음 중 접근제어자를 접근범위가 넓은 것에서 좁은 것의 순으로 바르게 나열한
//		것은?
//		a. public-protected-(default)-private
//		b. public-(default)-protected-private
//		c. (default)-public-protected-private
//		d. private-protected-(default)-public
//		(a)
	
//		[7-9] 다음 중 제어자 final을 붙일 수 있는 대상과 붙였을 때 그 의미를 적은 것이다.
//		옳지 않은 것은? (모두 고르시오)
//		a. 지역변수 - 값을 변경할 수 없다. //선언과 동시에 초기화하거나 그 이후엔 값을 지정가능하지만 이후에는 수정불가
//		b. 클래스 - 상속을 통해 클래스에 새로운 멤버를 추가할 수 없다.
//		c. 메서드 - 오버로딩을 할 수 없다. //오버라이딩이 ㄴㄴ함
//		d. 멤버변수 - 값을 변경할 수 없다.
		
//		(c)
	
//		[7-10] MyTv2클래스의 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 접근할
//		수 없도록 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록
//		getter와 setter메서드를 추가하라.
		
		
//		MyTv2 t = new MyTv2();
//		
//		t.setChannel(10);
//		System.out.println("CH:"+t.getChannel());
//		
//		t.setVolume(20);
//		System.out.println("VOL:"+t.getVolume());
		
		
//		[7-11] 문제7-10에서 작성한 MyTv2클래스에 이전 채널(previous channel)로 이동하는 ****
//		기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오.
//		[Hint] 이전 채널의 값을 저장할 멤버변수를 정의하라.
//		메서드명 : gotoPrevChannel
//		기 능 : 현재 채널을 이전 채널로 변경한다.
//		반환타입 : 없음
//		매개변수 : 없음
		
//		MyTv2 t = new MyTv2();
//		
//		t.setChannel(10);
//		System.out.println("CH:"+t.getChannel());
//		t.setChannel(20);
//		System.out.println("CH:"+t.getChannel());
//		t.gotoPrevChannel();
//		System.out.println("CH:"+t.getChannel());
//		t.gotoPrevChannel();
//		System.out.println("CH:"+t.getChannel());
//	
//	
//		[7-12] 다음 중 접근 제어자에 대한 설명으로 옳지 않은 것은? (모두 고르시오)
//				a. public은 접근제한이 전혀 없는 접근 제어자이다.
//				b. (default)가 붙으면, 같은 패키지 내에서만 접근이 가능하다.
//				c. 지역변수에도 접근 제어자를 사용할 수 있다. //사용가능한곳이 클래스 멤버변수 메서드 생성자이다.
//				d. protected가 붙으면, 같은 패키지 내에서도 접근이 가능하다.
//				e. protected가 붙으면, 다른 패키지의 자손 클래스에서 접근이 가능하다.
//		(c)
		
		
//		[7-13] Math클래스의 생성자는 접근 제어자가 private이다. 그 이유는 무엇인가?
//			Math클래스 static으로 생성되어있고,
//			사용자가 임의로 인스턴스 생성할 수 없게 하기 위해서
		
//		[7-15] 클래스가 다음과 같이 정의되어 있을 때, 형변환을 올바르게 하지 않은 것은?
//		(모두 고르시오.)
//		
//		a. u = (Unit)ac;
//		b. u = ac;
//		c. GroundUnit gu = (GroundUnit)u;
//		d. AirUnit au = ac;
//		e. t = (Tank)u;
//		f. GroundUnit gu = t;
		
//		(c)
		
//		7-16] 다음 중 연산결과가 true가 아닌 것은? (모두 고르시오)
		
//		
//		a. fe instanceof FireEngine
//		b. fe instanceof Movable
//		c. fe instanceof Object
//		d. fe instanceof Car
//		e. fe instanceof Ambulance
//		(e)
		
		
//		[7-17] 아래 세 개의 클래스로부터 공통부분을 뽑아서 Unit이라는 클래스를 만들고, 이
//		클래스를 상속받도록 코드를 변경하시오.
		
		
		
//		[7-19] 다음은 물건을 구입하는 사람을 정의한 Buyer클래스이다. 이 클래스는 멤버변수
//		로 돈(money)과 장바구니(cart)를 가지고 있다. 제품을 구입하는 기능의 buy메서드와 장
//		바구니에 구입한 물건을 추가하는 add메서드, 구입한 물건의 목록과 사용금액, 그리고 남
//		은 금액을 출력하는 summary메서드를 완성하시오.
//		1. 메서드명 : buy
//		기 능 : 지정된 물건을 구입한다. 가진 돈(money)에서 물건의 가격을 빼고,
//		장바구니(cart)에 담는다.
//		만일 가진 돈이 물건의 가격보다 적다면 바로 종료한다.
//		반환타입 : 없음
//		매개변수 : Product p - 구입할 물건
//		2. 메서드명 : add
//		기 능 : 지정된 물건을 장바구니에 담는다.
//		만일 장바구니에 담을 공간이 없으면, 장바구니의 크기를 2배로 늘린 다음에 담는다.
//		반환타입 : 없음
//		매개변수 : Product p - 구입할 물건
//		3. 메서드명 : summary
//		기 능 : 구입한 물건의 목록과 사용금액, 남은 금액을 출력한다.
//		반환타입 : 없음
//		매개변수 : 없음
		
//		Buyer b = new Buyer();
//		b.buy(new Tv());
//		b.buy(new Computer());
//		b.buy(new Tv());
//		b.buy(new Audio());
//		b.buy(new Computer());
//		b.buy(new Computer());
//		b.buy(new Computer());
//		b.summary();
		
		
		
//		[7-20] 다음의 코드를 실행한 결과를 적으시오.
//		Parent p = new Child();
//		Child c = new Child();
//		System.out.println("p.x = " + p.x);
//		p.method();
//		System.out.println("c.x = " + c.x);
//		c.method();
//		
//		
//		p.x = 100   <- 답
//		Child Method
//		c.x = 200
//		Child Method
		
//		[7-24] 다음 중 인터페이스의 장점이 아닌 것은?
//				a. 표준화를 가능하게 해준다.
//				b. 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
//				c. 독립적인 프로그래밍이 가능하다.
//				d. 다중상속을 가능하게 해준다.
//				e. 패키지간의 연결을 도와준다. <- 정답
//		
	
	}

}


//문제 20
//class Parent {
//	int x = 100;
//	void method() {
//		System.out.println("Parent Method");
//	}
//}
//class Child extends Parent {
//	int x = 200;
//	void method() {
//		System.out.println("Child Method");
//	}
//}




//
//문제 19
//class Buyer {
//	int money = 1000;
//	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
//	int i = 0; // Product배열 cart에 사용될 index
//	void buy(Product p) {
//		if(money < p.price){
//			return;
//		}else{
//			money -= p.price;
//		}
//		add(p);
//
//	}
//	void add(Product p) {
//		if(i >= cart.length){
//			Product[] newcart = new Product[cart.length * 2];
//			System.arraycopy(cart, 0, newcart, 0, cart.length);
//		    cart = new Product[newcart.length];
//			System.arraycopy(newcart, 0, cart, 0, cart.length);
//		}
//		cart[i] = p;
//		i++;
//	} // add(Product p)
//	void summary() {
//		int sum = 0;
//		System.out.printf("구입한 물건은 : ");
//		for(int i = 0; i < cart.length; i++){
//			if(cart[i] != null){
//				System.out.printf(""+ cart[i]+" ");
//				sum += cart[i].price;
//			}
//		}
//		System.out.printf("입니다.");
//		System.out.println();
//		System.out.println("사용한 금액 : " + sum);
//		System.out.println("남은 금액 : " + money);
//		
//	} // summary()
//}
//class Product {
//	int price; // 제품의 가격
//	Product(int price) {
//		this.price = price;
//	}
//}
//class Tv extends Product {
//	Tv() { super(100); }
//	public String toString() { return "Tv"; }
//}
//class Computer extends Product {
//	Computer() { super(200); }
//	public String toString() { return "Computer";}
//}
//class Audio extends Product {
//	Audio() { super(50); }
//	public String toString() { return "Audio"; }
//}





//문제 17
//abstract class Unit{
//	int x,y;
//	abstract void move(int x, int y);
//	void stop();
//}
//
//class Marine extends Unit{ // 보병
//
//	void move(int x, int y) { /* 지정된 위치로 이동 */ }

//	void stimPack() { /* 스팀팩을 사용한다.*/}
//}
//	class Tank extends Unit{ // 탱크
//	
//	void move(int x, int y) { /* 지정된 위치로 이동 */ }

//	void changeMode() { /* 공격모드를 변환한다. */}
//}
//	class Dropship { // 수송선
//	
//	void move(int x, int y) { /* 지정된 위치로 이동 */ }

//	void load() { /* 선택된 대상을 태운다.*/ }
//	void unload() { /* 선택된 대상을 내린다.*/ }
//}
//	
	


// 문제 7-10, 11
//class MyTv2 {
//	private boolean isPowerOn;
//	private int channel;
//	private int volume;
//    int prevchannel;
//	final int MAX_VOLUME = 100;
//	final int MIN_VOLUME = 0;
//	final int MAX_CHANNEL = 100;
//	final int MIN_CHANNEL = 1;
//	
//	public void gotoPrevChannel() {
//		setChannel(prevchannel);
//	}
//	
//	public boolean isPowerOn() {
//		return isPowerOn;
//	}
//
//	public void setPowerOn(boolean isPowerOn) {
//		this.isPowerOn = isPowerOn;
//	}
//	
//	public int getChannel() {
//		return channel;
//	}
//	public void setChannel(int channel) {
//		prevchannel = this.channel;
//		this.channel = channel;
//	}
//	
//	public int getVolume() {
//		return volume;
//	}
//	public void setVolume(int volume) {
//		this.volume = volume;
//	}
//}



