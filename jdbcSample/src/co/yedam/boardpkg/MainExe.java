package co.yedam.boardpkg;

import java.util.Scanner;

interface Menu {
	int ADD = 1, EDIT = 2, DEL = 3, LIST = 4, INFO = 5, EXIT = 6;
}

public class MainExe {
	public static void menuPrint() {
		System.out.println("1.등록 2.수정 3.삭제 4.목록 5.개인정보 6.종료");
		System.out.print("선택>> ");
	}

	public static void main(String[] args) {

		BoardService svc = new BoardDAO(); // BoardDAO, BoardApp

		Scanner scn = new Scanner(System.in);
		boolean run = true;

		System.out.print("ID 입력>> ");
		String id = scn.nextLine();
		System.out.print("PW 입력>> ");
		String pw = scn.nextLine();
		if (svc.login(id, pw)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("ID PW 재확인");
		}
		while (run) {

			menuPrint();
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case Menu.ADD:
				System.out.println("등록");

				int no = svc.getNextBoardNo();
				System.out.print("제목 입력>> ");
				String title = scn.nextLine();
				System.out.print("내용 입력>> ");
				String content = scn.nextLine();
				System.out.print("날짜 입력>> ");
				String date = scn.nextLine();
				Board bd;
				if (date.isEmpty()) { // 날짜 미입력시 오늘날짜 입력
					bd = new Board(no, title, content, id); // board class 생성자 참조
				} else {
					bd = new Board(no, title, content, id, date);
				}
				if (svc.addBoard(bd)) {
					System.out.println("등록 완료");
				} else {
					System.out.println("등록 실패");
				}
				break;
			case Menu.EDIT:
				System.out.println("수정");
				System.out.print("글번호 입력>> ");
				no = Integer.parseInt(scn.nextLine());
				System.out.print("제목 입력>> ");
				title = scn.nextLine();
				System.out.print("내용 입력>> ");
				content = scn.nextLine();
				System.out.println(no + title + content + id);

				if (svc.editBoard(new Board(no, title, content, id))) {
					System.out.println("수정완료");
				} else {
					System.out.println("권한없음");
				}
				break;
			case Menu.DEL:
				System.out.println("삭제");
				System.out.print("글번호 입력>> ");
				no = Integer.parseInt(scn.nextLine());
				if (svc.delBoard(no, id)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("권한 부족");
				}
				break;
			case Menu.LIST:
				for (Board brd : svc.boardList()) {
					System.out.println(brd.toString());
				}
				break;
			case Menu.INFO:
				System.out.println("PW 변경");
				System.out.print("PW 입력>> ");
				String pw2 = scn.nextLine();
				if (pw.equals(pw2)) {
					System.out.print("New PW 입력>> ");
					String newPw = scn.nextLine();
					System.out.print("New PW 확인 입력>> ");
					String newPw2 = scn.nextLine();
					if (newPw2.equals(newPw)) {
						if (svc.modInfo(new User(id, "ㅇ", newPw))) {
							System.out.println("PW 변경완료");
						} else {
							System.out.println("PW 변경실패");
						}
					} else {
						System.out.println("New PW 불일치");
					}
				} else {
					System.out.println("PW 불일치");
				}
				break;
			case Menu.EXIT:
				run = false;
				System.out.println("ㅂㅂ");
			}
		}
		System.out.println("end of prog.");
		scn.close();
	}
}
