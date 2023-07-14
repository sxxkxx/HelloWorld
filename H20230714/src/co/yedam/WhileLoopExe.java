package co.yedam;

import java.util.Scanner;

public class WhileLoopExe {
	static Scanner scn = new Scanner(System.in);
	static int balance = 0;

	public static void main(String[] args) {
		boolean run = true;
		// 은행업무: 1.입금 2.출금 3.잔액조회 4.종료
		// 제한금액 : max = 10만원, 5만원 + 5.2만원 => 입금불가
		// 제한금액 : min = 0원
		// break; 반복문 탈출.
		// continue; 아랫코드 무시하고 처음으로 돌아감.
		// return; 메소드 탈출

		while (run) {
			System.out.println("1.입금 2.출금 3.잔액조회 4.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				check();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
		System.out.println("end of prog.");
	} // end of main

	public static void deposit() {
		System.out.print("입금액을 입력>> ");
		int ip = Integer.parseInt(scn.nextLine());
		// 제한금액 : 최대금액 = 10만원
		if (balance + ip > 100000) {
			System.out.println("입금한도 초과입니다.");
			return;
		}
		balance += ip;
		System.out.printf("입급액은 %d원, 현재 잔액은 %d원 입니다.\n", ip, balance);
	} // end of deposit

	public static void withdraw() {
		System.out.println("출금액을 입력>> ");
		int chul = Integer.parseInt(scn.nextLine());
		// 제한금액 : 최소금액 = 0원
		if (balance - chul < 0) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		balance -= chul;
		System.out.printf("출금액은 %d원, 현재 잔액은 %d원 입니다.\n", chul, balance);

	} // end of withdraw

	public static void check() {
		System.out.printf("현재 잔액은 %d원 입니다.\n", balance);
	} // end of check

} // end of class
