package co.yedam.friend;

public class UniFriend extends Friend {

	private String univ;
	private String major;

	public UniFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String showInfo() {
		return super.showInfo() + ", 학교: " + this.getUniv() + ", 전공: " + this.getMajor();
	}
}
