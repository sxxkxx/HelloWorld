package co.yedam;

import java.io.IOException;

public class PrintStreamExe {

	public static void main(String[] args) {
		
		try {
			while (true) {
				System.out.print("value>>");
				int result = System.in.read(); // Enter :13, 10
				
				if(result != 13 && result !=10) {
					System.out.println("결과: " + result);
					System.in.read(); //입력스트림값을 일고 해당 키 반환
					System.in.read();
					}
				if(result == 113) {
					break;
					}
			
				}
			System.out.print("끝");
			}		catch (IOException e) {
					e.printStackTrace();
				}
		}

}
