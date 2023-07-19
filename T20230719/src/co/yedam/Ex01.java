package co.yedam;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("num1 입력 >> ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.println("num2 입력 >> ");
			int num2 = Integer.parseInt(sc.nextLine());
			if (num1 > num2) {
				System.out.printf("큰 수는 %d입니다.", num1);
			} else {
				System.out.printf("큰 수는 %d입니다.", num2);
			}
			run = false;
		}

	} // end of main.

}
