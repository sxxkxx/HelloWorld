package co.yedam.student;

import java.util.Scanner;

public class StudentAppExe {

	public static void main(String[] args) {

		boolean run = true;
		Scanner scn = new Scanner(System.in);

		StudentApp app = new StudentApp();

		// 메뉴: 1.등록 2.목록 3.합계 4.최고점 5.종료
		// 기능 구현
		while (run) {
			System.out.println("1.등록 2.목록 3.합계 4.최고점 5.종료");
			System.out.print("선택 >> ");

			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("학생정보입력");
				System.out.print("학생번호 입력 >> ");
				String sNo = scn.nextLine();
				System.out.print("학생이름 입력 >> ");
				String sName = scn.nextLine();
				System.out.print("학생점수 입력 >> ");
				int score = Integer.parseInt(scn.nextLine());
				System.out.print("학생키 입력 >> ");
				double height = Double.parseDouble(scn.nextLine());

				if (app.addStudent(new Student(sNo, sName, score, height))) {
					System.out.println("등록 ㅇㅇ");
				} else {
					System.out.println("등록 ㄴㄴ");
				}

			} else if (menu == 2) {
				System.out.println("학생목록");
				Student[] ary = app.studentList();
				for (int i = 0; i < ary.length; i++) {
					if (ary[i] != null) {
						System.out.printf("학생번호 : %s, 이름 : %s, 점수 : %d, 키 : %.1f\n", ary[i].stdNo, ary[i].stdName,
								ary[i].score, ary[i].height);
					}
				}

			} else if (menu == 3) {
				System.out.println("합계점수");
				int sum = app.sumScore();
				System.out.println("합계점수 : " + sum);

			} else if (menu == 4) {
				System.out.println("최고점수");
				int max = app.maxPrint();
				System.out.println("최고점수 : " + max);

			} else if (menu == 5) {
				System.out.println("end of prog.");
				run = false;
			}

		}

	} // end of main.

}
