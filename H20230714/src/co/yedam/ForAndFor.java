package co.yedam;

public class ForAndFor {

	public static void main(String[] args) {
		practice3();
	} //end of main
	
	public static void practice3() {
		boolean run = true;
		
		while(run) {
//			int n1 = (int)(Math.random()* 6 + 1);
//			int n2 = (int)(Math.random()* 6 + 1);
//			if(n1+n2 == 5) {
//				System.out.printf("(%d, %d)",n1,n2);
//				run=false;
//			}
//			
//		}
		
	}// end of practice3
	
	public static void practice4() {
		
	}// end of practice4
	
	public static void forAndfor() {
		for (int j=1;j<=9;j++) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", j, i, j * i);
			}
			System.out.println();
		}
	}
}
