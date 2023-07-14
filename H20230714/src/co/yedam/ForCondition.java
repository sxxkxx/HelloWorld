package co.yedam;

public class ForCondition {

	public static void main(String[] args) {
		showCalender(7);

	} // end of main()

	public static void showCalender(int month) {
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" }; // 배열 안에 문자열 삽입
		System.out.println(month + "월");
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println(); // 줄 바꿈

		// 1일의 위치 지정 (공백)
		int pos = getfirstDay(month);
		for (int i = 0; i < pos; i++) {
			System.out.printf("%4s", "");
		}
		int lastDate = getLastDate(month);
		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + pos) % 7 == 0) {
				System.out.println();
			}
		}
	} // end of showCalender
		// 월 정보를 입력하면 해당 월의 마지막날짜를 반환.

	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			lastDate = 31;
			break;
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;

		}
		return lastDate;
	} // end of getLastDate

	public static int getLastDate2(int month) {
		int lastDate2 = 31;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			lastDate2 = 31;
		} else if (month == 2) {
			lastDate2 = 28;
		} else {
			lastDate2 = 30;
		}
		return lastDate2;
	} // end of getLastDate2

	public static int getfirstDay(int month) {
		int pos = 1;
		switch (month) {
		case 1:
		case 10:
			pos = 0;
			break;
		case 3:
		case 11:
			pos = 3;
			break;
		case 5:
			pos = 1;
			break;
		case 4:
		case 7:
			pos = 6;
			break;
		case 8:
		case 2:
			pos = 2;
			break;
		case 6:
			pos = 4;
			break;
		case 9:
		case 12:
			pos = 5;
		}
		return pos;
	}// end of getfirstDay
}
