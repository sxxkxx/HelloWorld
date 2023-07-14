package co.yedam;

import java.util.Scanner;

public class ArrayPraticeExe {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0; // 학생수
		int[] scores = null; // 학생 점수를 저장하기 위한 배열
		int maxScore = 0;
		int sum = 0;
		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.println("선택>> ");
			int selectNo = Integer.parseInt(scn.nextLine());
			if (selectNo == 1) {
				System.out.print("학생수>> ");
				studentNum = Integer.parseInt(scn.nextLine());
				scores = new int[studentNum];
				System.out.printf("학생수는 %d명 입니다.\n",studentNum);
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("%d번 학생의 점수는>> ", i + 1);
					int stuscore = Integer.parseInt(scn.nextLine());
					scores[i] = stuscore;
				}
			} else if (selectNo == 3) {
				for (int num : scores) {
					System.out.println(num);
				}
			} else if (selectNo == 4) {
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (scores[i] > maxScore) {
						maxScore = scores[i];
					}
				}
				int avg = sum / scores.length;
				System.out.printf("최고 점수: %d\n평균 점수: %d", maxScore, avg);
				System.out.println();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("end of prog.");
	} // end of main

} // end of class
