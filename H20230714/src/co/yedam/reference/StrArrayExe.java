package co.yedam.reference;

import java.util.Scanner;

public class StrArrayExe {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String[] strAry = new String[3]; // 크기가 3인 배열 생성
		int[] scores = new int[3];

		for (String str : strAry) {
			System.out.println(str);
		}

		for (int i = 0; i < strAry.length; i++) {
			System.out.printf("이름>> ");
			strAry[i] = scn.nextLine();
			System.out.printf("점수>> ");
			scores[i] = Integer.parseInt(scn.nextLine());
		}
		
//		System.out.println("검색하고 싶은 학생의 이름을 입력>>> ");
//		String searchName = scn.nextLine();
		// 최고점수를 구하고, 학생 이름 출력
		int maxScore = 0;
		String maxName = "";
		
		// 전체목록을 출력.
		for (int i = 0; i < strAry.length; i++) {
//			if(strAry[i].equals(searchName)) {   // XXXX.euqals(BBBB) 문자열 비교
//			System.out.printf("이름은 %s, 점수는 %d \n", strAry[i], scores[i]);
//			}
			if(maxScore < scores[i]) {
				maxScore = scores[i];
				maxName = strAry[i];
			}
		}
		System.out.printf("최고득점자 이름은 %s, 점수는 %d \n", maxName, maxScore);

	}

}
