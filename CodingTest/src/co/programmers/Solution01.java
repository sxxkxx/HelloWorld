package co.programmers;

public class Solution01 {

	public static void main(String[] args) {
//		solution("100","123450");
System.out.println(Character.getNumericValue("100".charAt(1)));
	}
	public static String solution(String X, String Y) {
		String temp = null;
		for (int i = 0; i < X.length(); i++) {
			for (int j = 0; j < Y.length(); j++) {
				if (Character.getNumericValue(X.charAt(i)) == Character.getNumericValue(X.charAt(j))) {
					temp += X.charAt(j);
				}
			}
		}

//		int a = (int) (Math.random() * 300 + 3);
//		System.out.println(a);
		String answer = "";
//        return answer;
		return "";
	}
}
