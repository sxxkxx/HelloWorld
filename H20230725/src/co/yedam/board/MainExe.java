package co.yedam.board;

import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		boolean stop = true;
		BoardApp app = new BoardApp();

		while (run) {
			stop = true;
			System.out.print("ID 입력>> ");
			String id = sc.nextLine();
			System.out.print("PW 입력>> ");
			String pw = sc.nextLine();

			if (app.login(id, pw).equals("ID PW 재입력")) {
				System.out.println(app.login(id, pw));
			} else {
				System.out.println(app.login(id, pw));
				while (stop) {
					System.out.println();
					app.printMenu();
					int menu = Integer.parseInt(sc.nextLine());
					switch (menu) {
					case 1:
						app.addBoard(id);
						break;
					case 2:
						System.out.println("글번호 입력>> ");
						String no = sc.nextLine();
						app.editBoard(no, id);
						no = "";
						break;
					case 3:
						System.out.println("글번호 입력>> ");
						no = sc.nextLine();
						app.delBoard(no, id);
						no = "";
						break;
					case 4:
						app.listBoard();
						break;
					case 5:
						run = false;
						stop = false;
						break;
					case 8:
						stop = false;
						System.out.println("로그 아웃");
						break;
					case 9:
					default:
						System.out.println("다시 선택");
						
					}
				}
			}

		}
		System.out.println("끝");

	}

}
