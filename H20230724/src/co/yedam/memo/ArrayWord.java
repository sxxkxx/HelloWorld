package co.yedam.memo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		List<String> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("4");
		list2.add("5");
		
		FileReader fr;
		try {
//			fr = new FileReader("/Users/sankim/git/HelloWorld/H20230724/src/temp/wordAry.txt");
			fr = new FileReader("C:\\Temp/wordAry.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
				if (str.equals("")) {
					continue;
				}
//				str = str.split(".",2)[1];
//				str = str.substring(str.indexOf(".") + 1, str.length());
				str = str.replace("\"","");
				str = str.replace(",","");
				str = str.trim();
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
			for (int i = 0; i < list1.size(); i++) {
				System.out.println(list1.get(i));

			}
			System.out.print("입력>> ");
			String str = sc.nextLine();

			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).equals(str)) {
					list1.remove(i);
					System.out.println("삭제완료");
				}
			}
			if(list1.size()==0) {
				System.out.println("end of prog.");
				break;
			}

		}

	} // end of main.

}
