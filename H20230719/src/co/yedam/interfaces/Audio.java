package co.yedam.interfaces;

// RemoteCon 인터페이스 구현하는 클래스.(implements 인터페이스이름)
public class Audio implements RemoteCon {

	private double freq;

	public Audio() {

	}

	public void setFreq(double freq) {
		this.freq = freq;
	}

	@Override
	public void turnOn() {
		System.out.println("오디오 on");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오 off");
	}

}
