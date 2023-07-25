package co.yedam.product;

import java.util.Scanner;

public class ProductManageEXE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		boolean stop = true;
		ProductApp app = new ProductApp();

		int menu = 0;
		while (run) {
			while (true) {
				try {
					app.printMenu();
					menu = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("숫자 입력");
				}
			}
			if (menu == 1) {
				app.addPrd();
			} else if (menu == 2) {
				app.salesMgr(true);
			} else if (menu == 3) {
				app.purchaseMgr(true);
			} else if (menu == 4) {
				app.invenInquiry();
			} else if (menu == 5) {
				run = false;
				app.storeToFile(app.productList, "c:/temp/prdlist.db");

			} else {
				System.out.println("없는 메뉴");
			}
		}
		System.out.println("프로그램 종료");

	}

}
