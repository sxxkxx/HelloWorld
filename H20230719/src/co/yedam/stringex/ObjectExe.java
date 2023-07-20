package co.yedam.stringex;

public class ObjectExe {

	public static void main(String[] args) {
		String[] numbers = { "9802031234567", "0502033234567", "980203-1234567", "980203-2234567", "020203 1234567",
				"030203 2234567" };
		// 주민번호 뒷자리의 첫번째 값(성별:1,3 - 남 / 2,4 - 여)

		for (String num : numbers) {
			System.out.print(num + ": ");
			System.out.println();
			System.out.print(Integer.parseInt(num.substring(0, 2)));
			System.out.print("-" + Integer.parseInt(num.substring(num.length() - 7, num.length() - 6)) + "-");
			System.out.println(checkGender(num));
			System.out.println();
		}
	}

	// 성별체크 1
	static String checkGender(String no) {
		if (no.length() == 14) {					// 주민번호 자리수 확인
			if (no.charAt(0) == '0') {				// 앞 첫번째 자리 0
				if (no.charAt(7) == '3') {			// 뒤 첫번째 자리 3
					return "남";						// 남자.
				} else if (no.charAt(7) == '4') {	// 뒤 첫번째 자리 4
					return "여";						// 여자.
				}
			} else if (no.charAt(0) == '9') {		// 앞 첫번째 자리 9
				if (no.charAt(7) == '1') {			// 뒤 첫번째 자리 1
					return "남";						// 남자
				} else if (no.charAt(7) == '2') {	// 뒤 첫번째 자리 2
					return "여";						// 여자
				}
			}
		} else if (no.length() == 13) {				// 주민번호 자리수 확인
			if (no.charAt(0) == '0') {				// 앞 첫번째 자리 0
				if (no.charAt(6) == '3') {			// 뒤 첫번째 자리 3
					return "남";						// 남자
				} else if (no.charAt(6) == '4') {	// 뒤 첫번째 자리 4
					return "여";						// 여자
				}
			} else if (no.charAt(0) == '9') {		// 앞 첫번째 자리 0
				if (no.charAt(6) == '1') {			// 뒤 첫번째 자리 1
					return "남";						// 남자
				} else if (no.charAt(6) == '2') {	// 뒤 첫번째 자리 2
					return "여";						// 여자
				}
			}
		}
		return "에러";								
	} // end of checkGender.

	static String checkGender1(String no) {
		int gender = Integer.parseInt(no.substring(no.length() - 7, no.length() - 6));
		// 주민번호 뒤 첫번째자리값(뒤에서 7번째부터, 뒤에서6번째까지)을 정수로 저장 (990101-1000000 => 1)  
		
		int birth = Integer.parseInt(no.substring(0, 2)); 
		// 주민번호 앞 두자리값(0번부터, 2자리)을 정수로 저장 (990101-1000000 => 99)

		if (birth > 23) {				// 출생년도가 1924년 ~ 1999년 
			if (gender == 1) {			// 주민번호 뒤 첫번째자리값 = 1
				return "남자";			// 남자
			} else if (gender == 2) {	// 주민번호 뒤 첫번째자리값 = 2
				return "여자";			// 여자
			}
		} else if (birth <= 23) {		// 출생년도가 2000년 ~ 2023년
			if (gender == 3) {			// 주민번호 뒤 첫번째자리값 = 3
				return "남자";			// 남자
			} else if (gender == 4) {	// 주민번호 뒤 첫번째자리값 = 4
				return "여자";			// 여자
			}
		}
		return "에러";
	}
}
