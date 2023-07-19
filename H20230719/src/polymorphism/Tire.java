package polymorphism;

// 상속관계 : Tire <- 한국타이어, 금호타이어
public class Tire {
	// 필드.
	int maxRotation; // 최대사용가능 회전수
	int accumulatedRotation;
	String location;

	// 생성자.
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}

	// 메소드.
	public boolean roll() {
		accumulatedRotation++;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + " Tire 수명: " + (maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("***"+location+" Tire 펑크 ***");
			return false;
		}
	}
}
