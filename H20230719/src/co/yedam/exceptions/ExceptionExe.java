package co.yedam.exceptions;

import java.util.Scanner;

public class ExceptionExe {

	public static void main(String[] args) {

		// NullPointException.
		Scanner sc = new Scanner(System.in);
		String str = null;
		str = "kim";
		int age = 0;
		// try 블럭에서 예외가 발생하면
		// catch 블럭에 정의된 코드실행.
		try {
			System.out.println(str.toString());
			age = Integer.parseInt("열살");
			System.out.println("이름: " + str + ", 나이: " + age);
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("예외 발생.");

//		}catch (NumberFormatException n) {
//			System.out.println("Format 예외 발생");
		} finally { // finally : 에러와 상관없이 무조건 실행해야하는 부분
			sc.close(); // 리소스 반환. 
		}

		try {
			Class cls = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			exceptionMethod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("종료");
	}

	public static void exceptionMethod() throws ClassNotFoundException {
		// 예외처리책임을 메소드를 호출한 영역으로 넘김.(여기서는 Main Class.)
		Class cls = Class.forName("java.lang.String");
	}

}
