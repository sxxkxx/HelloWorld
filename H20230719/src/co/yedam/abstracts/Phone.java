package co.yedam.abstracts;

public abstract class Phone {
	// 필드
	private String owner;
	
	// 생성자 (추상클래스에서는 사용불가, 상속받는 자식클래스에서 생성자 사용가능)
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return owner;
	}
	
	//메소드
	public void powerOn() {
		System.out.println("전원 on");
	}
	
	// 추상메소드 : 자식클래스에서 기능을 반드시 구현하도록 강제함.
	// 자식클래스에서 재정의(오버라이드) 후 사용
	public abstract void powerOff();
}
