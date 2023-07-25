package co.yedam.board;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardApp {
	List<User> users = new ArrayList<>();
	List<Board> boards = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public BoardApp() {
		uReadFromFile();
		bReadFromFile();
	}

	private String getNextNo() { // 게시글 번호 자동 부여
		int no = 0;
		for (int i = 0; i < boards.size(); i++) {
			if (Integer.parseInt(boards.get(i).getNo()) > no) {
				no = Integer.parseInt(boards.get(i).getNo());
			}
		}
		return "" + (no + 1);
	}

	public String login(String id, String pw) {

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

	public void addBoard(String id) { // 게시글 등록.
		String no = getNextNo();
		System.out.println("제목 입력>> ");
		String title = sc.nextLine();
		System.out.print("내용 입력 >> ");
		String content = sc.nextLine();
		System.out.print("날짜 입력 >> ");
		String date = sc.nextLine();

		Board bd = null;

		if (date.isEmpty()) { // 날짜 미입력시 오늘날짜 입력
			bd = new Board(no, title, content, id, date); // board class 생성자 참조
		} else {
			bd = new Board(no, title, content, id);
		}
		if (boards.add(bd)) {
			System.out.println(no + "번 게시글 등록완료");
		}

	}

	public void editBoard(String no, String id) { // 게시글 수정. 게시글 번호와 id일치 확인.
		int ox = 0; // 일치하면 1 불일치면 0
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
			System.out.println("수정권한없음"); // 게시글 번호와 id 불일치 메시지출력.
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

	public void changeInfo(String id, String pw) {
		int ox = 0;
		int cnt = 0;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				System.out.println("PW 변경");
				ox = 1;

			}
		}

		if (ox == 0) {
			System.out.println("PW 잘못입력");
		} else {
			while (true) {
				System.out.print("새 PW 입력>> ");
				String nPw = sc.nextLine();
				System.out.print("새 PW 다시 입력>> ");
				String nPwChk = sc.nextLine();
				if (nPw.equals(nPwChk)) {
					users.get(cnt).setPw(nPw);
					System.out.println("변경 완료");
					break;
				} else {
					System.out.println("PW 불일치");
				}
			}
		}
	}

	public void uReadFromFile() {
		// 입력스트림. (객체)

		try {
			FileInputStream fis = new FileInputStream("/Users/sankim/Downloads/userList.txt");
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
//			FileInputStream fis = new FileInputStream("c:/temp/boardList.txt");
			FileInputStream fis = new FileInputStream("/Users/sankim/Downloads/boardList.txt");
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

	public void bWriteFile() {

		try {
			FileWriter fw = new FileWriter("/Users/sankim/Downloads/boardList.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			String str = "";

			for (int i = 0; i < boards.size(); i++) {
				str = boards.get(i).getNo() + " " + boards.get(i).getTitle() + " " + boards.get(i).getContent() + " "
						+ boards.get(i).getId() + " " + boards.get(i).getDate();
				bw.write(str + "\n");
			}

			System.out.println("저장 완료");
			bw.flush();
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("저장 실패");
		}

	}

	public void uWriteFile() {

		try {
			FileWriter fw = new FileWriter("/Users/sankim/Downloads/userList.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			String str = "";

			for (int i = 0; i < users.size(); i++) {
				str = users.get(i).getId() + " " + users.get(i).getName() + " " + users.get(i).getPw();
				bw.write(str + "\n");
			}

			System.out.println("저장 완료");
			bw.flush();
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("저장 실패");
		}

	}
}
