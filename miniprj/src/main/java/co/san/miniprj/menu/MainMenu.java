package co.san.miniprj.menu;

import java.util.List;
import java.util.Scanner;

import co.san.miniprj.member.service.MemberService;
import co.san.miniprj.member.service.MemberVO;
import co.san.miniprj.member.serviceImpl.MemberServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService ms = new MemberServiceImpl(); // DB.

	private void mainTitle() {
		System.out.println("==== 회원관리 ====");
		System.out.println("= 1.전체회원 조회 =");
		System.out.println("= 2.회원한명 조회 =");
		System.out.println("= 3.회원정보 등록 =");
		System.out.println("= 4.회원정보 수정 =");
		System.out.println("= 5.회원정보 삭제 =");
		System.out.println("= 6.회원관리 종료 =");
		System.out.println("================");
		System.out.println("=원하는 번호를 입력=");
	}

	private void memberSelectList() {
		List<MemberVO> members = ms.memberSelectList();
		if (!members.isEmpty()) {
			for (MemberVO member : members) {
				member.toString();
			}
		} else {
			System.out.println("회원이 존재하지 않음");
		}
	}

	// 여기서 CRUD 메소드를 private으로 하나씩 만들어 간다.

	private void memberSelect() {
		MemberVO member = new MemberVO();
		System.out.println("==검색할 회원 ID 입력==");
		sc.nextLine();
		String id = sc.nextLine();
		member.setMemberId(id);
		member = ms.memberSelect(member);
		if (member.getMemberName() != null) {
			member.toString();
		} else {
			System.out.println("존재하지 않는 회원 입니다.");
		}
	}

	private void memberInsert() {
		System.out.println("동작");
		//이하 구현된 내용 있음.
	}

	public void run() {
		boolean b = false;
		do {
			mainTitle();
			int key = sc.nextInt();
			switch (key) {
			case 1:
				memberSelectList();
				break;
			case 2:
				memberSelect();
				break;
			case 3:
				memberInsert();
				break;
			case 4:
			case 5:
			case 6:
				System.out.println("=====작업 종료=====");
				b = true;
				break;
			}
		} while (!b);
		sc.close();
	}

}
