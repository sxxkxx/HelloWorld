package co.yedam.member;

import java.util.Scanner;

public class MemberExe {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Member[] members = new Member[10];

		// 초기 데이터 저장.
		Member m1 = new Member();
		Member m2 = new Member();
		m1.setMemberNo(3);
		m1.setMemberName("kim");
		m1.setPhone("010-3333-3333");
		m1.setGender(Gender.MEN);
		m1.setAddress("뮌헨");

		m2.setMemberNo(7);
		m2.setMemberName("ji");
		m2.setPhone("010-7777-7777");
		m2.setGender(Gender.WOMEN);
		m2.setAddress("런던");

		members[0] = m1;
		members[1] = m2;

		Member m3 = new Member();
		members[2] = m3;

		Member m4 = new Member(19, "varan", "010-1919-1919", Gender.MEN, "맨체스터");
		members[3] = m4;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.상세 6.남자회원목록 7.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("등록기능.");
				System.out.printf("회원번호입력>> ");
				int mNo = Integer.parseInt(scn.nextLine());
				System.out.printf("회원이름입력>> ");
				String mName = scn.nextLine();
				System.out.printf("연락처입력>> ");
				String phone = scn.nextLine();
				System.out.printf("성별입력>> ");

				// 남, 남자 statrsWith()
				Gender gender = null;
				String temp = scn.nextLine();
				if (temp.startsWith("남")) {
					gender = Gender.MEN;
				} else if (temp.startsWith("여")) {
					gender = Gender.WOMEN;
				}
				System.out.printf("주소입력>> ");
				String addr = scn.nextLine();

				Member member = new Member(); // 인스턴스

				member.setMemberNo(mNo);
				member.setMemberName(mName);
				member.setPhone(phone);
				member.setGender(gender);
				member.setAddress(addr);

				// members 멤버인스턴스 10개 저장. (초기값 = null)
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = member; // 배열의 빈 공간에 값을 저장.
						break; // 한 건 저장 후 반복문 종료.
					}
				}

			} else if (menu == 2) {
				System.out.println("목록기능.");
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null) {
						System.out.println(members[i].showInfo());
					}
				}
			} else if (menu == 3) {
				System.out.println("수정기능.");

				System.out.printf("회원번호입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean itup = true;
				for (int i = 0; i < members.length; i++) {
					// 배열의 값 null 여부 체크
					if (members[i] != null && members[i].getMemberNo() == no) {
						System.out.printf("새로운연락처입력>> ");
						String phone = scn.nextLine();
						members[i].setPhone(phone);
						System.out.println("회원정보가 변경되었습이다.");
						itup = false;
					}
				}
				if (itup == true) {
					System.out.println("등록되지않은 회원입니다.");
				}
			} else if (menu == 4) {
				System.out.println("삭제기능.");
				System.out.printf("회원번호입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean itup = true;
				for (int i = 0; i < members.length; i++) {
					// 배열의 값 null 여부 체크
					if (members[i] != null && members[i].getMemberNo() == no) {
						members[i] = null;
						System.out.println("삭제되었습니다.");
						itup = false;
					}
				}
				if (itup == true) {
					System.out.println("등록되지않은 회원입니다.");
				}
			} else if (menu == 5) {
				System.out.println("상세보기.");
				System.out.printf("회원번호입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				for (int i = 0; i < members.length; i++) {
					// 배열의 값 null 여부 체크
					if (members[i] != null && members[i].getMemberNo() == no) {
						System.out.println(members[i].detailInfo());
					}
				}
			} else if (menu == 6) {
				System.out.println("남자회원목록.");
				for (int i = 0; i < members.length; i++) {
					// 배열의 값 null 여부 체크
					if (members[i] != null && members[i].getGender() == Gender.MEN) {
						System.out.println(members[i].showInfo());
					}
				}
			} else if (menu == 7) {
				System.out.println("종료합니다.");
				run = false;
			}

		}
		System.out.println("end of prog.");

	} // end of main;

}
