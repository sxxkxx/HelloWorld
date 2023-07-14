package co.yedam;

public class LoopExample {
	static int value = 76800;
	static int nam = value;
	static int jang = 0;
	static String result = value + "원 은 ";
	
	static int oman = 0;
	static int man = 0;
	static int ochun = 0;
	static int chun = 0;
	static int obaek = 0;
	static int baek = 0;
	static boolean run = true;

	public static void main(String[] args) {
		money2();
	}// end of main

	public static void money() {
		// 76800원 > 5만 1, 만원 2, 5천 1, 1천 1, 500 1, 100 3
		

		while (run) {
			// 5만단위 계산
			if (value >= 50000) {
				oman = value / 50000;
				nam = value - (50000 * oman); // 나머지값
			}
			if (nam >= 10000) {
				man = nam / 10000;
				nam = nam - (10000 * man);
			}
			if (nam >= 5000) {
				ochun = nam / 5000;
				nam = nam - (5000 * ochun);
			}
			if (nam >= 1000) {
				chun = nam / 1000;
				nam = nam - (1000 * chun);
			}
			if (value >= 500) {
				obaek = nam / 500;
				nam = nam - (500 * obaek);
			}
			if (nam >= 100) {
				baek = nam / 100;
				run = false;
			}

			System.out.printf("%d원은, 5만원 %d장, 만원 %d장, 5천원 %d장, 천원 %d장, 5백원 %d개, 백원 %d개", value, oman, man, ochun, chun,
					obaek, baek);
		}
	}
	public static void money2(){
		int [] hal = {50000,10000,5000,1000,500,100};
		
		for (int i = 0; i < hal.length ; i++) {
						jang = nam / i;
				nam = value - (i * jang);
				result += i + "원" + jang + "장";
			}
		System.out.println(result);
		}
//		System.out.println(result);
//		return;
	}
