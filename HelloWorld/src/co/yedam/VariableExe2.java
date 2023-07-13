package co.yedam;

public class VariableExe2 {
	public static void  main(String[] args) {
		// 실수형
		double num1 = 1.2;//8byte
		double num2 = 1.2;
		
		System.out.println(Double.MAX_VALUE);
		
		double result= num1 + num2;
		System.out.println(result);
		
		float num3 = 1.2F; // 4byte
		float num4 = 1.2F; 
		result = num3 + num4;
		System.out.println(result);
		System.out.println(Float.MAX_VALUE);
		
		// byte < short < int < long < float < double
		byte n1 = 10;
		short n2 = n1; // 작은범위의 변수타입 -> 큰범위의 변수타입
		int n3 = 128;
		n1 = (byte) n3;
		System.out.println("n1: " + n1);
		
		// boolean
		boolean trueOrFalse = true;
		trueOrFalse = false;
		
		trueOrFalse = 10 > 5;
		
	}
}
