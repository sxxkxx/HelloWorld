package co.yedam.inherit;

public class DmbCellPhone extends CellPhone {
	// 추가속성과 메소드
	private int channel;

	// 기본생성자 자동생성
	public DmbCellPhone() {
		super();
	}

	public DmbCellPhone(String model, String color, int channel) {
		super(model, color);
		this.channel = channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getChannel() {
		return channel;
	}

	public void turnOn() {
		System.out.println("화면 ON");
	}

	public void turnOff() {
		System.out.println("화면 OFF");
	}

	public void changeChannel(int channel) {
		this.channel = channel;
	}

	// Override : 부모클래스의 메소드 => 재정의.

	@Override
	public void powerOn() {
		System.out.println("DMB폰 전원 켬.");
		;
	}

	@Override
	public void powerOff() {
		System.out.println("DMB폰 전원 끔.");
		;
	}

	@Override
	public String showInfo() {
		return "모델: " + this.getModel() + ", 색상 : " + this.getColor() + ", 채널 : " + this.channel;
	}
}
