package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExe {

	public static void main(String[] args) {
		try {
			write("문자열 보조 스트림 테스트");
			String str = read();
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write(String str) throws Exception {
		// 바이트 기반 스트림. -> 문자열 기반 스트림 변경 보조 스트림.
		FileOutputStream fos = new FileOutputStream("/Users/sankim/Downloads/aaa.txt");
		Writer writer = new OutputStreamWriter(fos);
		writer.write(str);
		writer.flush();
		writer.close();
	}

	public static String read() throws Exception {
		FileInputStream fis = new FileInputStream("/Users/sankim/Downloads/aaa.txt");
		Reader reader = new InputStreamReader(fis);
		char[] buf = new char[100];
		int chrNum = reader.read(buf); // 파일의 끝: -1, 읽은 문자크기 리턴
		System.out.println("chrnum: " + chrNum);
		String data = new String(buf, 0, chrNum); // 100보다 작을경우 입력한 크기만큼만 문자열로 생성.
		fis.close();
		reader.close();
		return data;
	}

}
