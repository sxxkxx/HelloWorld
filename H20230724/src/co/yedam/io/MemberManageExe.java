package co.yedam.io;

import java.util.List;
import java.util.Scanner;

public class MemberManageExe {
	// 이름, 주소, 연락처, => 시작(초기값), 추가, 수정, 삭제, 목록, 종료(저장)
	public static void main(String[] args) {
		MemberManage mgr = new MemberManage();
		Scanner sc = new Scanner(System.in);
		boolean run = true;

		while (run) {

			int menu = 0;

			while (true) {
				try {

					System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
					System.out.print("선택>> ");
					menu = Integer.parseInt(sc.nextLine());
					break;
				} catch (NullPointerException | NumberFormatException e) {
					System.out.println("숫자 입력");
				}
			}

			if (menu == 1) {

				System.out.println("등록");
				System.out.println("이름 주소 연락처 입력");
				String str = sc.nextLine();
				String[] data = str.split(" ");
				Member member = new Member(data[0], data[1], data[2]);
				if (mgr.addMem(member)) {
					System.out.println("등록완료");
				} else {
					System.out.println("등록실패");
				}
			} else if (menu == 2) {
				System.out.println("이름 주소 연락처 입력");
				String str = sc.nextLine();
				String[] data = str.split(" ");
				Member member = new Member(data[0], data[1], data[2]);
				if (mgr.editMem(member)) {
					System.out.println("변경성공");
				} else {
					System.out.println("변경실패");
				}

			} else if (menu == 3) {
				System.out.println("이름 입력");
				String str = sc.nextLine();
				if (mgr.delMem(str)) {
					System.out.println("삭제성공");
				} else {
					System.out.println("삭제실패");
				}

			} else if (menu == 4) {
				List<Member> list = mgr.list();
				for (Member member : list) {
					System.out.println(member.toString());
				}
			} else if (menu == 5) {
				System.out.println("종료");
				mgr.save();
				run = false;
			} else {
				System.out.println("없는 메뉴");
			}
		}
		System.out.println("end of prog.");
		sc.close();
	} // end of main.
}
