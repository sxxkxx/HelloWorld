package co.yedam.stringex;

import java.io.UnsupportedEncodingException;

public class StringGetBytes {

	public static void main(String[] args) {
		String str0 = "안녕하세요";
		byte[] bytes1 = str0.getBytes();
		System.out.println("bytes1.length " + bytes1.length);
		String str01 = new String(bytes1);
		System.out.println("bytes1->String: " + str01);

		try {
			byte[] bytes2 = str0.getBytes("EUC-KR");
			System.out.println("bytes1.length " + bytes2.length);
			String str02 = new String(bytes1);
			System.out.println("bytes1->String: " + str02);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

		}
	}

}
