package co.yedam.stringex;

public class ObjectExe {

	public static void main(String[] args) {
		String[] numbers = { "9802031234567", "0502033234567", "980203-1234567", "980203-2234567", "020203 1234567",
				"030203 2234567" };
		// 주민번호 뒷자리의 첫번째 값(성별:1,3 - 남 / 2,4 - 여)

		for (String num : numbers) {
			System.out.println();
//			System.out.println(checkGender1(num));
		}
		System.out.println(numbers[0].length() + " " + numbers[0].charAt(0) + " " + numbers[0].charAt(7));

	}
	

	static String checkGender(String no) {
		String result = "에러";
//		if (no.length() == 14) {
//			if (no.charAt(0) == 0) {
//				if (no.charAt(7) == 3) {
//					result = "남";
//				} else if (no.charAt(7) == 4) {
//					result = "여";
//				}
//			} else if (no.charAt(0) == 9) {
//				if (no.charAt(7) == 1) {
//					result = "남";
//				} else if (no.charAt(7) == 2) {
//					result = "여";
//				}
//			}
//		}else 
			if(no.length() == 13) {
			if (no.charAt(0) == 0) {
				if (no.charAt(6) == 3) {
					result = "남";
				} else if (no.charAt(6) == 4) {
					result = "여";
				}
			} else if (no.charAt(0) == 9) {
				if (no.charAt(6) == 1) {
					result = "남";
				} else if (no.charAt(6) == 2) {
					result = "여";
				}
			}
		}
		return result;
	}
}
