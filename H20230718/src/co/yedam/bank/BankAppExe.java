package co.yedam.bank;

import java.util.Scanner;

public class BankAppExe {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
//		BankApp bApp = new BankApp(); 
		BankApp bApp = BankApp.getInstance(); // 싱글톤방식으로 할당

		while (run) {

			System.out.println("1.등록 2.입금 3.출금 4.잔액조회 5.계좌목록 6.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("정보입력");
				System.out.print("계좌번호 입력 >> ");
				String accountNo = scn.nextLine();
				System.out.print("예금주 입력 >> ");
				String Name = scn.nextLine();
				System.out.print("입금액 입력 >> ");
				int balance = Integer.parseInt(scn.nextLine());

				bApp.registerAccount(new Account(accountNo, Name, balance));
				System.out.println("등록 완료");

			} else if (menu == 2) {
				System.out.println("입금");
				System.out.print("계좌번호 입력 >> ");
				String accountNo = scn.nextLine();
				if (bApp.accCheck(accountNo) == 0) {
					System.out.println("미등록 계좌입니다.");
				} else {
					System.out.print("입금액 입력 >> ");
					int dps = Integer.parseInt(scn.nextLine());
					bApp.deposit(accountNo, dps);
				}

			} else if (menu == 3) {
				System.out.println("출금");
				System.out.print("계좌번호 입력 >> ");
				String accountNo = scn.nextLine();
				if (bApp.accCheck(accountNo) == 0) {
					System.out.println("미등록 계좌입니다.");
				} else {
					System.out.print("금액 입력 >> ");
					int wdr = Integer.parseInt(scn.nextLine());
					if (bApp.withdraw(accountNo, wdr) == false) {
						System.out.println("잔액이 부족합니다.");
					}
					System.out.println("출금 완료");
				}

			} else if (menu == 4) {
				System.out.println("잔액조회");
				System.out.print("계좌번호 입력 >> ");
				String accountNo = scn.nextLine();
				if (bApp.accCheck(accountNo) == 0) {
					System.out.println("미등록 계좌입니다.");
				} else {
					System.out.printf("현재잔고 : %d원\n", bApp.checkBalance(accountNo));
				}
			} else if (menu == 5) {
				Account[] ary = bApp.accountList();
				for (int i = 0; i < ary.length; i++) {
					if (ary[i] != null) {
						System.out.printf("계좌번호 : %s, 예금주 : %s\n", ary[i].accountNo, ary[i].name);
					}
				}
			} else if (menu == 6) {
				run = false;
				System.out.println("거래종료");
			}
		}
	} // end of main.

}
