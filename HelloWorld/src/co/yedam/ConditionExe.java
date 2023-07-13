package co.yedam;

public class ConditionExe {

	public static void main(String[] args) {
		switchCondition();

	} // end of main()

	public static void switchCondition() {
		int result = (int) (Math.random() * 3) + 1;

		switch (result) {
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;
		default:
			System.out.println("3입니다.");
		}
	}

	public static void ifCondition() {
		// Math
		for (int i = 0; i < 10; i++) {
			int result = (int) (Math.random() * 6) + 1; // 0 ~ 10 사이의 임의의 값 생성 double
			System.out.print(result + "는 ");

			if (result % 2 == 0) {
				System.out.println("2의 배수입니다.");
			} else if (result % 3 == 0) {
				System.out.println("3의 배수입니다.");
			} else {
				System.out.println("소수입니다.");
			}
		}
	}
}
