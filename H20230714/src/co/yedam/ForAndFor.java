package co.yedam;

public class ForAndFor {

	public static void main(String[] args) {
		practice4();
	} // end of main

	public static void practice3() {
		boolean run = true;
		int n1 = 0;
		int n2 = 0;

		while (run) {
			n1 = (int) (Math.random() * 6 + 1);
			n2 = (int) (Math.random() * 6 + 1);
			if (n1 + n2 == 5) {
				run = false;
			}

		}
		System.out.printf("(%d, %d)", n1, n2);

	}// end of practice3

	public static void practice4() {
		// 4x + 5y ==60;
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}
	}// end of practice4

	public static void forAndfor() {
		for (int j = 1; j <= 9; j++) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", j, i, j * i);
			}
			System.out.println();
		}
	}
}
