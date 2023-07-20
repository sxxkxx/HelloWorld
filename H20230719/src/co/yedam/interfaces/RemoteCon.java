package co.yedam.interfaces;

// 인터페이스. (class 대신 interface사용)
// 생성자 없음, 필드 : 상수로 사용(변하지 않음), 메소드: 추상메소드로 선언
public interface RemoteCon {
	
	// 필드
	final int CHANNER = 10;
	
	// 추상메소드 선언
	abstract void turnOn();
	
	void turnOff();
}
