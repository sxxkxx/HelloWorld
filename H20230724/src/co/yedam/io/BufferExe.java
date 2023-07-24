package co.yedam.io;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferExe {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Temp\\jdk.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("C:\\Temp\\jdk_cp.exe");
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		int data = 0;

//		while (true) {
//			System.out.println("시작");
//			data = bis.read();
//			bos.write(data);
//			if (data == -1) {
//				break;
//			}
//			
//			
//		}

		while ((data = bis.read()) != -1) {
			System.out.println("시작");
			bos.write(data);

		}
		System.out.println("종료.");
		bos.flush();
		bos.close();
		fos.close();
		bis.close();
		fis.close();

	}
}
