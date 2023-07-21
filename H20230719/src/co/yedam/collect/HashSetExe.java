package co.yedam.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExe {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();

		set.add("Apple");
		set.add("Banana");
		set.add("Cherry");
		set.add("Apple"); // 중복값 추가 X

		// 반복문.
		Iterator<String> iter = set.iterator(); // 반복자 반환. 인덱스 대신사용.
		while (iter.hasNext()) { // 있으면 true; 없으면 false; 반환.
			String str = iter.next(); //
			System.out.println(str);
		}

		// 확장 for.
		for (String fruit : set) {
			System.out.println(fruit);
		}

		set.remove("Apple");
		set.clear(); // 전체삭제

		if (set.isEmpty()) { // isEmpty : 비어있는지확인.
			System.out.println("set 비어있음");
		}

		// 크기.
		System.out.println("크기는 " + set.size());

		Set<Integer> lotto = new HashSet<>();
		// 1 ~ 10 임의의 번호를 lotto에 저장.

		while (lotto.size() < 6) {
			int temp = (int) (Math.random() * 45) + 1;
			System.out.println(temp);
			lotto.add(temp);
		}
		System.out.println(lotto);
	}

}
