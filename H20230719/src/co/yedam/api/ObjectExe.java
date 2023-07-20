package co.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {

	public static void main(String[] args) {

		Object obj1 = new Object();
		Object obj2 = new Object();
		boolean result = obj1.equals(obj2);
		System.out.println(result);

		Member mem1 = new Member(7, "son");
		Member mem2 = new Member(3, "kim");
		result = mem1.equals(mem2);
		System.out.println(result);

//		printRect();

		Set<Member> set = new HashSet<>();
		// 논리적으로 동등한 객체임을 판별할 때
		// hashCode, equals 정의.
		set.add(new Member(07, "son"));
		set.add(new Member(03, "kim"));
		set.add(new Member(19,"lee"));
		set.add(new Member(07, "son"));

		for (Member str : set) {
			System.out.println(str.toString());
		}
	}

	public static void printRect() {
		// 1
		// 2 3
		// 4 5 6
		// 7 8 9 10
		int a = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				a++;
				if (j == i) {
					System.out.printf("%3d\n", a);
				} else {
					System.out.printf("%3d", a);
				}
			}
		}
	}
}
