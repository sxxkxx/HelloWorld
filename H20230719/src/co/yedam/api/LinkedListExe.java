package co.yedam.api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		List<String> lnk = new LinkedList<String>();

		long start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			list.add(0, String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList 작업시간" + (end - start));

		long start2 = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			lnk.add(0, String.valueOf(i));
		}
		long end2 = System.currentTimeMillis();
		System.out.println("LinkedList 작업시간" + (end2 - start2));
	}

}
