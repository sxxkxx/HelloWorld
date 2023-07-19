package co.yedam;

public class Ex03 {

	public static void main(String[] args) {
		int[] ary = new int[10];
		int max = 0;
		int min = 10;

		for (int i = 0; i < ary.length; i++) {
			ary[i] = (int) (Math.random() * 10);
		}
		for (int i = 0; i < ary.length; i++) {
			if (min > ary[i]) {
				min = ary[i];
			} else if (max < ary[i]) {
				max = ary[i];
			}
		}
		System.out.printf("최소값: %d, 최대값: %d", min, max);

	} // end of main.

	
}
