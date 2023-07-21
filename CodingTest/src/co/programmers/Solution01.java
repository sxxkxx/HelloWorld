package co.programmers;

public class Solution01 {

	public static void main(String[] args) {
//		String result = solution("100","123450");
//		System.out.println(result);
		System.out.println(Character.getNumericValue("100".charAt(1))+20);
		String X = "100";
		String Y = "123450";
		String temp = "";
			System.out.println(Y.charAt(5));
		System.out.println(X.charAt(1) == Y.charAt(5));
		
		for (int i = 0; i < X.length(); i++) {
			for (int j = 0; j < Y.length(); j++) {
				if (X.charAt(i) == X.charAt(j)) {
					temp += String.valueOf(X.charAt(j));
					System.out.println("="+temp);
				}
			}
		}
		
	}

	public static String solution(String X, String Y) {
		String temp = null;
		for (int i = 0; i < X.length(); i++) {
			for (int j = 0; j < Y.length(); j++) {
				if (X.charAt(i) == X.charAt(j)) {
					temp += String.valueOf(X.charAt(j)) ;
				}
			}
		}

		String answer = temp;
		return answer;

	}
}
