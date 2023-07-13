package co.yedam;

public class OperatorExe {

	public static void main(String[] args) {
		int sum = 0;
		sum += 1;
		sum += 1;
		sum += 1;
		
		System.out.println(sum);
		
		boolean result = false;
		
		result = 3 == 1 || 2 % 3 == 2;
		
		System.out.println(result);
		
		String str = "";
		if (sum % 2 == 0) {
			str = "짝수입니다.";
		} else {
			str = "홀수입니다.";
		}
		
		str = (sum % 2 == 0) ? "짝수입니다." : "홀수입니다."; // 삼항연산자 
		System.out.println(str);
	}

}
