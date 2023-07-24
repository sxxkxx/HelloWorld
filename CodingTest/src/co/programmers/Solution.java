<<<<<<< HEAD
package co.programmers;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n % 2 == 0) {
			System.out.println(n + " is even");
		} else {
			System.out.println(n + " is odd");
		}
	}
}
=======
package co.programmers;

public class Solution {

	public static void main(String[] args) {
//		solution(1,12);
		String aa = "";
		String bb = "";
		int answer = 0;
		if(Integer.parseInt(aa+bb)<Integer.parseInt(bb+aa)) {
			answer = Integer.parseInt(bb+aa);
		}else {
			answer = Integer.parseInt(aa+bb);
		}
		System.out.println(answer);
		
	}

	public static int solution(int a, int b) {
		String aa = a+"";
		String bb = b+"";
		int answer = 0;
		if(Integer.parseInt(aa)+Integer.parseInt(bb)<Integer.parseInt(bb)+Integer.parseInt(aa)) {
			answer = Integer.parseInt(bb)+Integer.parseInt(aa);
		}else {
			answer = Integer.parseInt(aa)+Integer.parseInt(bb);
		}
		return answer;
	}
}
>>>>>>> branch 'master' of https://github.com/sxxkxx/HelloWorld.git
