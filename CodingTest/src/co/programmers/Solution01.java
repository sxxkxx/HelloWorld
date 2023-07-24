package co.programmers;

public class Solution01 {

	public static void main(String[] args) {

		String X = "100";
		String Y = "2345";

		System.out.println(solution2("0", "2"));
		System.out.println(solution2("100", "203045"));
		System.out.println(solution2("100", "123450"));
		System.out.println(solution2("12321", "42531"));
		System.out.println(solution2("5525", "1255"));
		System.out.println(solution2("340098732458923094572034570923405923750923745092340570237502398475023750230985620397850239845732094578203985702375897593284750623493",
				"1312973324956234978562934765092345093240598085620135987230459620356023750982730596230756023589273506230859672309586723098459032753583203"));

	} // end of main.

	public static String solution2(String X, String Y) {
		if (X.length() < 3 || Y.length() < 3 || X.charAt(0) == '0' || Y.charAt(0) == '0') {
			return "-1";
		}
		char[] XAry = X.toCharArray();
		char[] YAry = Y.toCharArray();
		String check = "";
		char temp = ' ';
		String temp2 = "";
		String answer = "";
		for (int i = 0; i < XAry.length; i++) {
			for (int j = 0; j < YAry.length; j++) {
				if (XAry[i] == YAry[j]) {
					check += String.valueOf(X.charAt(i));
					YAry[j] = ' ';
					break;
				}
			}
		}
		if (check.equals("")) {
			return "-1";
		}
		char[] ary = check.toCharArray();
		char max = ' ';

		for (int i = 0; i < ary.length - 1; i++) {

			for (int j = i + 1; j < ary.length; j++) {
				if (ary[i] < ary[j]) {
					max = ary[j];
					ary[j] = ary[i];
					ary[i] = max;
				}
			}
			if (i == ary.length - 2) {
				temp2 += String.valueOf(ary[i]);
				temp2 += String.valueOf(ary[i + 1]);
				break;
			}
			temp2 += String.valueOf(ary[i]);
		}
		if (temp2.charAt(0) == '0') {
			return "0";
		}
		answer = temp2;
		return answer;

	}
}
