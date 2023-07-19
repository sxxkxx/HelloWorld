package polymorphism;

public class Car {
	// 필드의 다형성.
	Tire frontLeft = new Tire("fl", 6);
	Tire frontRight = new Tire("fr", 5);
	Tire backLeft = new Tire("bl", 3);
	Tire backRight = new Tire("br", 6);

	int run() {
		System.out.println("[        출발        ]");
		if (frontLeft.roll() == false) {
			stop();
			return 1;
		}
		if (frontRight.roll() == false) {
			stop();
			return 2;
		}
		if (backLeft.roll() == false) {
			stop();
			return 3;
		}
		if (backRight.roll() == false) {
			stop();
			return 4;
		}
		return 0;

	}

	void stop() {
		System.out.println("[       정지        ]");
	}
}
