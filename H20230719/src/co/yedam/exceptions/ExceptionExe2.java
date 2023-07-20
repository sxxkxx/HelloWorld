package co.yedam.exceptions;

import java.util.Scanner;

public class ExceptionExe2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("이름 >> ");
		String name = sc.nextLine();
		int age;
		while (true) {
			try {
				System.out.println("나이 >> ");
				age = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) { 
				System.out.println("숫자 입력");
			}
		}
		System.out.println("주소 >> ");
		String addr = sc.nextLine();
		System.out.printf("이름: %s, 나이: %d, 주소: %s", name, age, addr);
	}

}
