package co.yedam.memo;

import java.util.Scanner;

public class MemoAppExe {

	public static void main(String[] args) {
		boolean run = true;
		MemoApp app = MemoApp.getInstance();

		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("1.등록 2.수정 3.삭제 4.목록 5.조회 6.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {

				System.out.println("글번호 내용 작성시간 입력");
				String no = scn.next();
				String content = scn.next();
				String date = scn.next();
				scn.nextLine();
				app.addMemo(new Memo(no, content, date));
				System.out.println(app.memos[0].memoNo + app.memos[0].memoContent + app.memos[0].memoDate);
//				if (app.addMemo(new Memo(no, content, date)) == 1) {
//					System.out.println("등록실패");
//				}else {
//				System.out.printf("글번호 : %d, 내용 : %s, 작성일 : %s", no, content, date);
//				System.out.println();
//				System.out.println("등록완료");
//				}
			} else if (menu == 2) {
				System.out.print("글번호 입력>> ");
				String no = scn.nextLine();
				if (app.checkMemoNum(no) == 0) {
					System.out.println("없는 번호");
				} else {
					System.out.println("신규내용입력");
					String content = scn.nextLine();
					app.editMemo(no, content);
					System.out.println("수정완료");
				}

			} else if (menu == 3) {
				System.out.print("글번호 입력>> ");
				String no = scn.nextLine();
				if (app.checkMemoNum(no) == 0) {
					System.out.println("없는 번호");
				} else {
					app.delMemo(no);
					System.out.println("삭제완료");
				}
			} else if (menu == 4) {
				Memo[] ary = app.memoList();
				for (int i = 0; i < ary.length; i++) {
					System.out.printf("글번호 : %s, 내용 : %s, 작성일 : %s\n", ary[i].memoNo, ary[i].memoContent,
							ary[i].memoDate);
				}

			} else if (menu == 5) {
				System.out.print("글번호 입력>> ");
				String no = scn.nextLine();
				if (app.checkMemoNum(no) == 0) {
					System.out.println("없는 번호");
				} else {
					int memNum = app.findMemo(no);
					System.out.println(no);
					System.out.println(memNum);
					System.out.printf("글번호 : %s, 내용 : %s, 작성일 : %s\n", app.memos[memNum].memoNo,
							app.memos[memNum].memoContent, app.memos[memNum].memoDate);
				}
			} else if (menu == 6) {
				run = false;
				System.out.println("종료");
			}

		}

	} // end of main
}
