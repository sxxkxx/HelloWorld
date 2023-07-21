package co.yedam.collect;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExe {

	public static void main(String[] args) {
		Map<String, String> users = new Hashtable<String, String>();

//		users.put("son", "7777");
//		users.put("kim", "3333");
//		users.put("lee", "1919");
//		users.put("hwang", "1111");

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("id pw 입력");
			System.out.print("id >>");
			String id = sc.nextLine();

			if (users.containsKey(id)) {
				System.out.print("pw >>");
				String pw = sc.nextLine();
				if (users.get(id).equals(pw)) {
					System.out.println("로그인 성공");
					run = false;
				} else {
					System.out.println("pw 불일치");
				}
			} else {
				System.out.println("없는 id");
			}
		} // end of while.

	}// end of main.

}
