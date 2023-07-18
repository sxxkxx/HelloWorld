package co.yedam.student;

public class StudentExe {

	public static void main(String[] args) {
		Student s1 = new Student(); // heap 영역에 인스턴스 생성.
		s1.stdName = "son";

		Student s2 = new Student();
		s2.stdName = "lee";
		s2.stdNo = "23-0019";

		// 전체 필드를 초기화하는 생성자.
		Student s3 = new Student("23-0003", "kim", 80, 189.7);
		System.out.println(s3.showInfo());

		System.out.println(s1);
		System.out.println(s2);

		System.out.println(s1 == s2); // 주소값은 항상 다름.
		System.out.println(s1.stdName.equals(s2.stdName)); // 필드의 값은 메소드를 통해 비교.

	} // end of main.

}
