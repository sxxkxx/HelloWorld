package com.yedam.board;

import java.util.Scanner;

public class BoardExe {

	static Scanner scn = new Scanner(System.in);
	static Board[] boards = new Board[20];

	private static void init() {

		Board b1 = new Board(1, "가", "가", "son");
		Board b2 = new Board(2, "나", "나", "kim");
		Board b3 = new Board(3, "나", "나", "kang");
		Board b4 = new Board(4, "나", "나", "lee");
		Board b5 = new Board(5, "나", "나", "park");
		Board b6 = new Board(6, "나", "나", "na");
		Board b7 = new Board(7, "나", "나", "pi");
		Board b8 = new Board(8, "나", "나", "lim");
		Board b9 = new Board(9, "나", "나", "ryu");
		Board b10 = new Board(10, "나", "나", "gwak");
		Board b11 = new Board(11, "나", "나", "hwang");
		Board b12 = new Board(12, "가", "가", "shin");

		boards[0] = b1;
		boards[1] = b2;
		boards[2] = b3;
		boards[3] = b4;
		boards[4] = b5;
		boards[5] = b6;
		boards[6] = b7;
		boards[7] = b8;
		boards[8] = b9;
		boards[9] = b10;
		boards[10] = b11;
		boards[11] = b12;
	}

	private static void addBoard() {

		System.out.println("게시글 작성");
		System.out.print("글번호 입력 >> ");
		int bNo = Integer.parseInt(scn.nextLine());
		System.out.print("글제목 입력 >> ");
		String bName = scn.nextLine();
		System.out.print("글내용 입력 >> ");
		String bText = scn.nextLine();
		System.out.print("작성자 입력 >> ");
		String writter = scn.nextLine();

		Board board = new Board(bNo, bName, bText, writter);

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				break;
			}
		}
	} // end of addBoard;

	private static void list() {
		System.out.println("게시글 목록");
		int cnt = 0;
		String pageNo = "페이지 ";
		int page = 0;
		// 전체글수를 카운트해서 페이지값 입력
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				cnt++;
				if (cnt % 5 == 0) {
					boards[i].setPage(cnt / 5);
				} else {
					boards[i].setPage(cnt / 5 + 1);
				}
			}
		}
		// 위에서 입력된 페이지 목록을 화면에 출력
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && page < boards[i].getPage()) {
				page = boards[i].getPage();
				pageNo += page + ", ";
			}
		}
		System.out.println(pageNo);
		boolean ox = true;
		System.out.println("페이지 번호를 입력 >> ");
		int pNo = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < boards.length; i++) {
			// 배열의 값 null 여부 체크
			if (boards[i] != null && boards[i].getPage() == pNo) {
				System.out.println(boards[i].showList());

				ox = false;
			}
		}
		if (ox == true) {
			System.out.println("없는 페이지 번호 입니다.");
		}
		System.out.println("현재 페이지 / 전체 페이지 " + pNo + " / " + page);

	} // end of list;

	private static void editBoard() {
		System.out.println("게시글 수정");
		System.out.print("수정할 글번호를 입력 >> ");
		boolean ox = true;
		int bNo = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bNo) {
				System.out.println("새로운 내용을 입력 >> ");
				String nText = scn.nextLine();
				boards[i].setBoardText(nText);
				ox = false;
				break;
			}
		}
		if (ox == true) {
			System.out.println("등록되지않은 글번호 입니다.");
		}

	} // end of editBoard

	private static void delBoard() {
		System.out.println("게시글 삭제");
		System.out.print("삭제할 글번호를 입력 >> ");
		boolean ox = true;
		int bNo = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bNo) {
				boards[i] = null;
				ox = false;
				break;
			}
		}
		if (ox == true) {
			System.out.println("등록되지않은 글번호 입니다.");
		}
	} // end of delBoard

	private static void getBoard() {
		System.out.println("상세 내용 보기");
		System.out.print("글번호를 입력 >> ");
		boolean ox = true;
		int bNo = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bNo) {
				System.out.println(boards[i].showFullList());
				ox = false;
				break;
			}
		}
		if (ox == true) {
			System.out.println("등록되지않은 글번호 입니다.");
		}
	} // end of getBoard

	public static void main(String[] args) {
		// 글번호, 글제목, 글내용, 작성자

		// 초기값;

		init();

		boolean run = true;

		while (run) {
			System.out.println("1.작성, 2.목록, 3.수정, 4.삭제, 5.상세보기, 6.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				addBoard();
			} else if (menu == 2) {
				list();
			} else if (menu == 3) {
				editBoard();
			} else if (menu == 4) {
				delBoard();
			} else if (menu == 5) {
				getBoard();
			} else if (menu == 6) {
				System.out.println("end of prog.");
				run = false;
			}

		}

	} // end of main

}
