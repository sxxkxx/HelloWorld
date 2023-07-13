package co.yedam;

import java.util.Scanner;

public class PrintStreamExe3 {

	public static void main(String[] args) {
		// 사용자 3개 숫자(정수) 입력
		// max 계산, 평균계산 => 최대값은 90이고 평균은 85입니다.
	
		Scanner scn = new Scanner(System.in);
		int max = 0, sum = 0, avg = 0;
		
			System.out.println("value >>");
			String val1 = scn.nextLine();
			sum = sum + Integer.parseInt(val1);
			if(Integer.parseInt(val1) > max) {
				max = Integer.parseInt(val1);
			}
			System.out.println("value >>");
			String val2 = scn.nextLine();
			sum = sum + Integer.parseInt(val2);
			if(Integer.parseInt(val2) > max) {
				max = Integer.parseInt(val2);
			}
			System.out.println("value >>");
			String val3 = scn.nextLine();
			sum = sum + Integer.parseInt(val3);
			if(Integer.parseInt(val3) > max) {
				max = Integer.parseInt(val3);
			}
			

		avg = sum / 3;
		
		System.out.printf("최대값은 %d, 평균은 %d", max, avg,"입니다.");
	}

}
