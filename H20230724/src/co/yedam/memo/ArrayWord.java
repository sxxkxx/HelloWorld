package co.yedam.memo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ArrayWord {

	public static void main(String[] args) {
		boolean run = true;
		List<String> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		FileReader fr;
		try {
			fr = new FileReader("c:/temp/wordAry.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
				list.add(str);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String a = "";

		for (int i = 0; i < 5; i++) {

			list1.add(list.get((int) (Math.random() * 100) + 1));

		}

		while (run) {
			for (int i = 0; i < 5; i++) {
				System.out.println(list1.get(i));

			}
		}

	} // end of main.

}
