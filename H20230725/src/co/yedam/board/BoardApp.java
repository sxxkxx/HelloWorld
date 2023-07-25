package co.yedam.board;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.product.Product;
import co.yedam.product.SalesManagement;

public class BoardApp {
	List<User> users = new ArrayList<>();
	List<Board> boards = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public BoardApp() {
		uReadFromFile();
		bReadFromFile();
	}

	private String getNextNo() {
		int no = 0;
		for (int i = 0; i < boards.size(); i++) {
			if (Integer.parseInt(boards.get(i).getNo()) > no) {
				no = Integer.parseInt(boards.get(i).getNo());
			}
		}
		return "" + (no + 1);
	}

	public String login(String id, String pw) {
		int ox = 0;

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				return users.get(i).getName() + "님 환영합니다.";

			}
		}

		return "ID PW 재입력";
	}

	public void printMenu() {
		System.out.println("1.등록 2.수정 3.삭제 4.목록 5.종료 8.로그아웃 9.개인정보수정");
		System.out.print("선택>> ");
	}

	public void addBoard(String id) {
		String no = getNextNo();
		System.out.println("제목 입력>> ");
		String title = sc.nextLine();
		System.out.print("내용 입력 >> ");
		String content = sc.nextLine();
		System.out.print("날짜 입력 >> ");
		String date = sc.nextLine();

		Board bd = null;

		if (date.isEmpty()) {
			bd = new Board(no, title, content, id, date);
		} else {
			bd = new Board(no, title, content, id);
		}
		if (boards.add(bd)) {
			System.out.println(no + "번 게시글 등록완료");
		}

	}

	public void editBoard(String no, String id) {
		int ox = 0;
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getNo().equals(no) && boards.get(i).getId().equals(id)) {
				System.out.print("제목 입력>> ");
				String title = sc.nextLine();
				System.out.print("내용 입력>> ");
				String content = sc.nextLine();
				boards.get(i).setTitle(title);
				boards.get(i).setContent(content);
				System.out.println("수정완료");
				ox = 1;
			}
		}
		if (ox == 0) {
			System.out.println("수정권한없음");
		}

	}

	public void delBoard(String no, String id) {
		int ox = 0;
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getNo().equals(no) && boards.get(i).getId().equals(id)) {
				boards.remove(i);
				System.out.println("삭제완료");
				ox = 1;
			}
		}
		if (ox == 0) {
			System.out.println("삭제권한없음");
		}
	}

	public void listBoard() {
		int ox = 0;
		for (int i = 0; i < boards.size(); i++) {

			System.out.printf("번호 : %s, 제목: %s, 내용: %s, 작성자: %s, 작성일: %s\n", boards.get(i).getNo(),
					boards.get(i).getTitle(), boards.get(i).getContent(), boards.get(i).getId(),
					boards.get(i).getDate());
			ox = 1;
		}

	}

	public void uReadFromFile() {
		// 입력스트림. (객체)

		try {
			FileInputStream fis = new FileInputStream("c:/temp/userList.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				String str = br.readLine(); // 한문장씩 읽기.
				if (str == null) {
					System.out.println("불러오기완료");
					break;
				}
				String[] data = str.split(" ");
				User user = new User(data[0], data[1], data[2]);
				users.add(user);

			}
		} catch (Exception e) {
			System.out.println("불러오기실패");
			e.printStackTrace();
		}

	}

	public void bReadFromFile() {
		// 입력스트림. (객체)

		try {
			FileInputStream fis = new FileInputStream("c:/temp/boardList.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				String str = br.readLine(); // 한문장씩 읽기.
				if (str == null) {
					System.out.println("불러오기완료");
					break;
				}
				String[] data = str.split(" ");
				Board bd = new Board(data[0], data[1], data[2], data[3], data[4]);
				boards.add(bd);

			}
		} catch (Exception e) {
			System.out.println("불러오기실패");
			e.printStackTrace();
		}

	}
}
