package co.yedam.memo;

import java.util.Scanner;

public class MemoApp {
	public static void main(String[] args) {
		MemoManager mgr = new MemoManager();
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int menu = 0;

		while (run) {
			mgr.printMenu();
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				mgr.inputData();
			} else if (menu == 2) {
				mgr.searchData();
			} else if (menu == 3) {
				mgr.deleteData();
			} else if (menu == 4) {
				mgr.storeToFile();
				System.out.println("종료");
				run = false;
			} else {
				System.out.println("없는 메뉴");
			}

		}
		System.out.println("end of prog.");
		sc.close();
	}
}
