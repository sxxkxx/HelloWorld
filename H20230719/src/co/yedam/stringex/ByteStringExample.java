package co.yedam.stringex;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ByteStringExample {
	public static void main(String[] args) throws Exception {

		// 바이트배열을 문자열로 변환
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);

		// 바이트 배열을 문자열로 변환
//		byte[] bytes2 = new byte[100];
//
//		System.out.println("입력: ");
//		int readByteNo = System.in.read(bytes2);
//
//		String str = new String(bytes, 0, readByteNo - 2);
//		System.out.println(str);

		// 문자추출
		String ssn = "111111-1111111";
		char sex = ssn.charAt(7);
		switch (sex) {
		case '1':
		case '2':
			System.out.println("남");
			break;
		case '3':
		case '4':
			System.out.println("여");
			break;
		}

		// 문자열 비교
		String strVar1 = new String("son");
		String strVar2 = "son";
		if (strVar2 == strVar1) {
			System.out.println("같은 객체 참조");
		} else {
			System.out.println("다른 객체 참조");
		}

		if (strVar1.equals(strVar2)) {
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");
		}

		// 바이트 배열로 변환
		String str0 = "안녕하세요";
		byte[] bytes1 = str0.getBytes();
		System.out.println("bytes1.length " + bytes1.length);
		String str01 = new String(bytes1);
		System.out.println("bytes1->String: " + str01);

		try {

			byte[] bytes2 = str0.getBytes("EUC-KR");
			System.out.println("bytes2.length " + bytes2.length);
			String str02 = new String(bytes2);
			System.out.println("bytes2->String: " + str02);

			byte[] bytes3 = str0.getBytes("UTF-8");
			System.out.println("bytes3.length " + bytes3.length);
			String str03 = new String(bytes3);
			System.out.println("bytes3->String: " + str03);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 문자열 포함여부 조사
		String subject = "자바 프로그래밍";

		int location = subject.indexOf("프로그래밍");
		System.out.println(location);

		if (subject.indexOf("자바") != -1) {
			System.out.println("자바관련책ㅇ");
		} else {
			System.out.println("자바관련ㄴ");
		}
		
		
	} // end of main.

}
