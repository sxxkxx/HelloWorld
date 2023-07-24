package co.programmers;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

//		System.out.println(solution(9, 91));
//		System.out.println(solution(89, 8));
	}

	public int solution(int n) {
		int a1 = 0;
		int a2 = 0;
		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (n % 2 == 0) {
				a2 += i * i;

			} else {

				a1 += i;
			}

		}
		return answer;

	}
}
