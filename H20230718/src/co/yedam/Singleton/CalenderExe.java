package co.yedam.Singleton;

import java.util.Calendar;
import java.util.Scanner;

public class CalenderExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("input(번호 이름 성적)>>> ");
		String str;

		// 7 son 87 enter.
		String no = scn.next();
		String name = scn.next();
		String score = scn.next();
		System.out.println("번호: " + no + ", 이름: " + name + ", 성적: " + score);

//		str = scn.nextLine();
//		System.out.println(str);

//		while (true) {
//			if(scn.hasNext()) {
//			str = scn.next();
//			System.out.println(str);
//			continue;
//			}
//			break;
//		}

//		showCal(2023, 8);

	}

	public static void showCal(int year, int month) {
		System.out.println(Calendar.YEAR);
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);

		System.out.println(cal.get(Calendar.YEAR) + "년");
		System.out.println((cal.get(Calendar.MONTH) + 1) + "월");
		System.out.println(cal.get(Calendar.DATE) + "일");
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + "요일");
		System.out.println("말일 " + cal.getActualMaximum(Calendar.DATE) + "일");
		System.out.println();
		System.out.println();
		// coding here.. 달력만들기

		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		System.out.println(month + "월");
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
		for (int i = 0; i < cal.get(Calendar.DAY_OF_WEEK) - 1; i++) {
			System.out.printf("%4s", "");
		}
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			if ((cal.get(Calendar.DAY_OF_WEEK) + i - 1) % 7 == 0) {
				System.out.println();
			}
		}

	}

}
