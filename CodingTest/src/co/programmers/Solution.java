package co.programmers;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		System.out.println(solution(9));
//		System.out.println(solution(89, 8));
	}

	public static int solution(int n) {
		int answer = 0;
		if (n % 2 == 0) {
			for (int i = n; i > 1; i = i - 2) {
				answer += i * i;
			}
		} else {
			for (int i = n; i > 0; i = i - 2) {
				answer += i;
			}
		}
		return answer;
	}
}
