package co.yedam.abstracts;

public class SmartPhone extends Phone {

	// 생성자 생성
	public SmartPhone(String owner) {
		super(owner);
	}

	@Override
	public void powerOn() {
		System.out.println("스마트폰 on");
	}

	@Override
	public void powerOff() {
		System.out.println("스마트폰 off");
	}
	
	public void internetSearch() {
		System.out.println("인터넷 검색");
	}
}
