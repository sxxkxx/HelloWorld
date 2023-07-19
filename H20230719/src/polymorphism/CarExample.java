package polymorphism;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();

		for (int i = 0; i < 10; i++) {
			int problemLoc = car.run();

			switch (problemLoc) {
			case 1:
				System.out.println("앞 왼쪽 타이어 펑!!!");
				car.frontLeft = new HankookTire("fl", 8);
				break;
			case 2:
				System.out.println("앞 오른쪽 타이어 펑!!!");
				car.frontRight = new HankookTire("fr", 6);
				break;
			case 3:
				System.out.println("뒤 왼쪽 타이어 펑!!!");
				car.backLeft = new HankookTire("bl", 7);
				break;
			case 4:
				System.out.println("뒤 오른쪽 타이어 펑!!!");
				car.backLeft = new HankookTire("br", 8);
				break;
			}
			System.out.println("----------------");
		}

	}

}
