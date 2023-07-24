package co.yedam.collect.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		// 로그인처리 => 기능 사용.

		// 1.등록 2.목록 3.상세조회 4.삭제 9.종료

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		boolean logout = true;
		UserApp app = new UserApp();
		BoardApp bApp = new BoardApp();

		System.out.println();

		while (run) {
			logout = true;
			System.out.println("id pw 입력");
			System.out.print("id >> ");
			String id = sc.nextLine();
			if (app.idCheck(id)) {
				System.out.print("pw >> ");
				String pw = sc.nextLine();
				if (app.login(id, pw)) {
					System.out.println("로그인 성공");

					while (logout) {
						System.out.println("1.등록 2.목록 3.상세조회 4.삭제 5.수정 8.로그아웃 9.종료");
						int menu = Integer.parseInt(sc.nextLine());
						if (menu == 1) {
							System.out.println("게시글 등록");

							System.out.print("제목 >> ");
							String title = sc.nextLine();
							System.out.print("내용 >> ");
							String content = sc.nextLine();
							if (bApp.addBd(new Board(title, content, id))) {
								System.out.println("등록완료");
							}
						} else if (menu == 2) {
							System.out.println("게시글 목록");
							List<Board> list = new ArrayList<>(bApp.bdList());
							for (int i = 0; i < list.size(); i++) {
								System.out.printf("글번호: %d, 제목: %s , 작성자: %s \n", list.get((i)).getBoardNo(),
										list.get((i)).getTitle(), list.get((i)).getWriter());
							}
						} else if (menu == 3) {
							System.out.println("상세조회");

							System.out.print("글번호 >> ");
							int no = Integer.parseInt(sc.nextLine());

							if (bApp.getBd(no) == null) {
								System.out.println("게시글 없음");
							} else {
								System.out.print(bApp.getBd(no).toString());
							}

						} else if (menu == 4) {
							System.out.println("삭제");

							System.out.print("글번호 >> ");
							int no = Integer.parseInt(sc.nextLine());
							String delId = id;
							if (bApp.delBoard(no, delId)) {
								System.out.println("삭제완료");
							} else {
								System.out.println("없는 게시글이거나 삭제권한없음.");
							}
						} else if (menu == 5) {
							System.out.println("게시글 수정");

							System.out.print("글번호 >>");
							int no = Integer.parseInt(sc.nextLine());

							if (bApp.checkBoard(no, id)) {
								
								System.out.print("제목 >> ");
								String title = sc.nextLine();
								System.out.print("내용 >> ");
								String content = sc.nextLine();
																
								bApp.editBoard(no, id, title, content);
								System.out.println("수정완료");
								
							} else {
								System.out.println("없는 게시글이거나 수정권한없음.");
							}
						} else if (menu == 8) {
							logout = false;
							System.out.println("로그 아웃");
							continue;
						} else if (menu == 9) {
							
							logout = false;
							run = false;

							System.out.println("종료");
						} // end of while1
					}

				} else {
					System.out.println("pw 불일치");
				}
			} else {
				System.out.println("없는 id");
			}
		} // end of while1

	}

}
