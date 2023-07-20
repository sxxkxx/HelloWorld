package co.yedam.friend;

import java.util.Scanner;

public class AdderessAppExe {

	public static void main(String[] args) throws MenuException {

		// 1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료
		Scanner sc = new Scanner(System.in);
		AddressApp app = new AddressApp();
		boolean run = true;
		int menu;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료");
			System.out.print("선택>> ");
			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("메뉴잘못선택.");
				// menu = 2;
				continue; // 처음으로
			}
			try {
				// 1 ~ 6 메뉴 이외의 메뉴 선택하면
				if (menu < 1 || menu > 6) {
					throw new MenuException(menu); // 예외 발생.
				}
			} catch (MenuException e) {
				e.showMessage();
				continue;
			}

			if (menu == INIT_MENU.ADD) {
				System.out.println("등록> 1.학교, 2.회사, 3.친구");
				int frd = Integer.parseInt(sc.nextLine());
				if (frd == 1) {
					System.out.println("학교 친구 등록");
					System.out.println("이름 연락처 학교 전공");
					String name = sc.next();
					String phone = sc.next();
					String univ = sc.next();
					String major = sc.next();
					sc.nextLine();

					if (app.addFriend(new UniFriend(name, phone, univ, major)) == false) {
						System.out.println("등록실패");
					} else {
						System.out.println("등록성공");
					}

				} else if (frd == 2) {
					System.out.println("회사 친구 등록");
					System.out.println("이름 연락처 회사 부서");
					String name = sc.next();
					String phone = sc.next();
					String comp = sc.next();
					String dept = sc.next();

					if (app.addFriend(new UniFriend(name, phone, comp, dept)) == false) {
						System.out.println("등록실패");
					} else {
						System.out.println("등록성공");
					}
					sc.nextLine();
				} else if (frd == 3) {
					System.out.println("친구 등록");
					System.out.println("이름 연락처");
					String name = sc.next();
					String phone = sc.next();
					sc.nextLine();

					if (app.addFriend(new Friend(name, phone)) == false) {
						System.out.println("등록실패");
					} else {
						System.out.println("등록성공");
					}

				}
			} else if (menu == INIT_MENU.LIST) {
				System.out.println("친구 목록");
				Friend[] ary = app.friendList();
				for (int i = 0; i < ary.length; i++) {
					if (ary[i] != null) {
						System.out.printf("이름 : %s, 연락처: %s\n", ary[i].getName(), ary[i].getPhone());
					}
				}
			} else if (menu == INIT_MENU.EDIT) {
				System.out.println("연락처 수정");
				System.out.println("이름 새 연락처");
				String name = sc.next();
				String phone = sc.next();
				sc.nextLine();

				if (app.editFriend(name, phone) == true) {
					System.out.println("이름 없음");
				} else {
					System.out.println("등록 완료");
				}
			} else if (menu == INIT_MENU.DEL) {
				System.out.println("삭제 ");
				System.out.println("이름");
				String name = sc.next();
				sc.nextLine();

				if (app.delFriend(name) == false) {
					System.out.println("이름 없음");
				} else {
					System.out.println("삭제 완료");
				}
			} else if (menu == INIT_MENU.SEARCH) {
				System.out.println("상세조회");
				System.out.println("이름");
				String name = sc.next();
				sc.nextLine();

				Friend ary = app.findFriend(name);

				if (ary == null) {
					System.out.println("이름 없음");
				} else {
					System.out.println(ary.showInfo());
				}
			} else if (menu == INIT_MENU.EXIT) {
				run = false;
			}

		}
	}// end of main.

}
