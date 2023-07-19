package co.yedam;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("num1 입력 >> ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.println("num2 입력 >> ");
			int num2 = Integer.parseInt(sc.nextLine());
			int big = 0;
			int small = 0;
			int sum2 = 0;
			int sum3 = 0;

			if (num1 > num2) {
				big = num1;
				small = num2;
			} else {
				big = num2;
				small = num1;
			}

			for (int i = small; i <= big; i++) {
				if (i % 2 == 0) {
					sum2 += i;
				} else if (i % 3 == 0) {
					sum3 += i;
				}
			}
			System.out.printf("2의배수합 : %d, 3의배수합 : %d", sum2, sum3);
			run = false;
		}
	}

}
