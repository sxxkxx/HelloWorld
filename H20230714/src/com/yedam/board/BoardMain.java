package com.yedam.board;

import co.yedam.member.Member;

public class BoardMain {

	public static void main(String[] args) {
//		message("호우");
//		getMax(1, 20);
//		getMembername(new Member());

		int result = sum(1, 123);
		result = sum(new int [] {10,20,30});
		System.out.println("결과값은 " + result);

	}

	// 반환유형
	public static int sum() {
		int num1 = (int) (Math.random() * 10);
		int num2 = (int) (Math.random() * 10);

		return num1 + num2;
	}

	// 같은 변수명이지만 입력한 매개변수에 따라 결과값이 달라짐
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}

	public static int sum(int[] intAry) {
		int sum = 0;
		for (int i = 0; i < intAry.length; i++) {
			sum += intAry[i];
		}
		return sum;
	}

	// 매개변수
	public static void message(String name) {
		System.out.println("안녕하세요." + name);
	}

	public static void getMax(int num1, int num2) {
		if (num1 > num2) {
			System.out.println("큰 값은 " + num1);
		} else {
			System.out.println("큰 값은 " + num2);
		}

	}

	// 클래스 변수.
	public static void getMembername(Member member) {
		System.out.println("이름은 " + member.getMemberName());
	}
}
