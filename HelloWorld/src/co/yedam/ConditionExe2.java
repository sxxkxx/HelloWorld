package co.yedam;

import java.io.IOException;
import java.util.Scanner;

public class ConditionExe2 {

	public static void main(String[] args) {
		switchChoice();
	} // end of main();

	public static void switchChoice() {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
			System.out.print("메뉴를 선택하세요: (숫자를 입력)>> ");
			String menu = scn.nextLine();
//			try {
			// switch case
				switch(menu) {
				case "1":login();break;
				case "2":logout();break;
				case "3":signup();break;
				default:
//					throw new IOException(); //예외발생
					run = false;
				}	
//			} catch (IOException e) {
//				e.printStackTrace();
//				break;
			}

		System.out.println("end of prog.");
		scn.close();
	}	
	public static void menuChoice() {
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
			System.out.print("메뉴를 선택하세요: (숫자를 입력)>> ");
			String menu = scn.nextLine();
			// switch case
			if (Integer.parseInt(menu) == 1) {
				login();
			} else if (Integer.parseInt(menu) == 2) {
				logout();
			} else if (Integer.parseInt(menu) == 3) {
				signup();
			} else if (Integer.parseInt(menu) == 4) {
				break;
			}

		}

		System.out.println("end of prog.");
		scn.close();
	} // end of main();

	public static void login() {
		System.out.println("로그인메뉴입니다.");
	}

	public static void logout() {
		System.out.println("로그아웃메뉴입니다.");
	}

	public static void signup() {
		System.out.println("회원가입메뉴입니다.");
	}
}
