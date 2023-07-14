package co.yedam.reference;

public class IntArrayExe {

	public static void main(String[] args) {
		int[] intAry = { 10, 20, 30 }; // 선언과 동시 값 입력
		intAry = new int[] { 10, 20, 30 }; // 정수형 배열 3개값 입력
		intAry = new int[5]; // 정수형 배열 공간 5개크기.

		intAry[0] = 15;
		intAry[intAry.length - 1] = 55;
//		System.out.println(intAry[intAry.length -1]);

		int sum = 0;

		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
			sum += intAry[i];
		}
		System.out.println(sum);
		// 확장 for : for(int 변수 : 배열이름){}
		for (int num : intAry) {
			System.out.println(num);
			sum += num;
		}
		System.out.println(sum);

		// 정수를 저장할 수 있는 배열 scores.
		// 학생1 ~ 학생5: 80, 85, 77, 93, 100
		// 학생점수의 합과 평균

		int[] scores = { 80, 85, 77, 93, 100 };
		int sum1 = 0;
		int avg = 0;
		for (int num : scores) {
			sum1 += num;
		}
		avg = sum1/scores.length;
		System.out.printf("총합은 %d점, 평균은 %d점입니다.",sum1,avg);
		
	}

}
