package co.yedam.board;

import java.util.Date;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		// 1. 추가 2. 수정 3. 조회 4.삭제 5.조회 6.종료
		BoardApp app = new BoardApp();
		Scanner sc = new Scanner(System.in);
		boolean run = true;

		while (run) {

			System.out.println("1. 추가 2. 수정 3. 조회 4.삭제 5.조회 6.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.println("제목 입력>> ");
				String title = sc.nextLine();
				System.out.println("내용 입력>> ");
				String content = sc.nextLine();
				System.out.println("작성자 입력>> ");
				String writer = sc.nextLine();
				int no = app.getNextNo();
				if (app.register(new Board(no, title, content, writer))) {
					System.out.println("등록완료");
				} else {
					System.out.println("등록실패");
				}
				break;
			case 2:
				System.out.println("글번호 입력");
				no = Integer.parseInt(sc.nextLine());
				System.out.println("제목 입력>> ");
				title = sc.nextLine();
				System.out.println("내용 입력>> ");
				content = sc.nextLine();
				if (app.modify(no, title, content)) {
					System.out.println("수정완료");
				} else {
					System.out.println("글 없음");
				}
				break;
			case 3:
				System.out.println("조회");
				System.out.println("글번호 입력");
				no = Integer.parseInt(sc.nextLine());
				if (app.search(no) != null) {
					System.out.println(app.search(no).toString());
				} else {
					System.out.println("글 없음");
				}

				break;
			case 4:
				System.out.println("삭제");
				System.out.println("글번호 입력");
				no = Integer.parseInt(sc.nextLine());
				if (app.remove(no)) {
					System.out.println("삭제완료");
				} else {
					System.out.println("글 없음");
				}
				break;
			case 5:
				System.out.println("목록");
				for (int i = 0; i < app.bds.size(); i++) {
					System.out.println(app.list().get(i).toString());
				}

				break;
			case 6:
				app.read();
				run = false;
				break;
			default:
				System.out.println("없는 메뉴");
			}

		}
		System.out.println("끝!");

	}

}
