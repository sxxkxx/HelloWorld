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
