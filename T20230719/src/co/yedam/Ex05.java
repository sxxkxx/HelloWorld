package co.yedam;

import java.util.Scanner;

public class Ex05 {
	static Scanner sc = new Scanner(System.in);
	static Friend[] friends = new Friend[10];

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.전화번호수정 4.삭제 5.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				register();
			} else if (menu == 2) {
				list();
			} else if (menu == 3) {
				modify();
			} else if (menu == 4) {
				remove();
			} else if (menu == 5) {
				run = false;
				System.out.print("종료");
			}
		}

	} // end of main.

	static void register() {
		System.out.println("등록");
		System.out.print("이름입력 >>");
		String name = sc.nextLine();
		System.out.print("전화번호입력 >>");
		String phone = sc.nextLine();
		System.out.print("생년월일입력 >>");
		String birth = sc.nextLine();
		System.out.print("키입력 >>");
		double height = Double.parseDouble(sc.nextLine());

		Friend frd = new Friend(name, phone, birth, height);
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = frd;
				break;
			}
		}
		System.out.println("등록완료");
	}

	static void list() {
		System.out.println("목록");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.printf("이름 : %s, 전화번호 : %s, 생년월일 : %s, 키: %.1f\n", friends[i].name, friends[i].phone,
						friends[i].birth, friends[i].height);
			}
		}

	}

	static void modify() {
		System.out.println("전화번호수정");
		System.out.println("이름입력 >>");
		String name = sc.nextLine();
		int ox = 0;
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].name.equals(name)) {
				System.out.println("전화번호입력 >>");
				String phone = sc.nextLine();
				friends[i].phone = phone;
				System.out.println("수정완료");
				ox = 1;
				break;
			}
		}
		if (ox == 0) {
			System.out.println("미등록이름");
		}
	}

	static void remove() {
		int ox = 0;
		System.out.println("삭제");
		System.out.println("이름입력 >>");
		String name = sc.nextLine();
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].name.equals(name)) {
				friends[i] = null;
				System.out.println("삭제완료");
				ox = 1;
				break;
			}
		}
		if (ox == 0) {
			System.out.println("미등록이름");
		}
	}

}