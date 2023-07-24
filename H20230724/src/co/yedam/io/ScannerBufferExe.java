package co.yedam.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

// 이름/주소/연락처 -> 3건입력. c:/temp/address2/txt 저장
public class ScannerBufferExe {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		FileWriter fw = new FileWriter("c:/temp/address2.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		String str = "";

		while (true) {
			System.out.println("이름 주소 연락처");
			System.out.print("입력 >> ");
			str = sc.nextLine();
			if (str.equals("종료")) {
				break;
			}
			bw.write(str + "\n");
		}
		System.out.println("종료");
		bw.flush();
		bw.close();
		fw.close();

	}

}
