package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufExe {

	public static void main(String[] args) throws Exception {

		// 입력스트림.
		InputStream is = new FileInputStream("C:/Temp/111.jpg");
		OutputStream os = new FileOutputStream("C:/Temp/111_cpy.jpg");

		System.out.println("start");
		byte[] buf = new byte[100];
		while (true) {
			int data = is.read(buf);
			os.write(buf);
			if (data == -1) {
				break;
			}
		}
		System.out.println("end");
		is.close();
		os.flush();
		os.close();

	}

}
