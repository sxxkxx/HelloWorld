package co.yedam.interfaces;

public class Television implements RemoteCon {

	int channel;

	public Television() {

	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public void turnOn() {
		System.out.println("TV on");
	}

	@Override
	public void turnOff() {
		System.out.println("TV off");
	}

}
