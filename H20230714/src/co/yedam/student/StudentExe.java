package co.yedam.student;

public class StudentExe {

	public static void main(String[] args) {
		// 학생번호, 학생이름, 점수.
		Student std1 = new Student(); // 인스턴스
		std1.setStudentNo(100);
		std1.setStudentName("홍길동");
		std1.setScore(80);

//		System.out.println(std1.studentNo);
//		System.out.println(std1.studentName);
//		System.out.println(std1.score);

		Student std2 = new Student();

		std2.setStudentNo(110);
		std2.setStudentName("홍홍홍");
		std2.setScore(85);

//		System.out.println(std2.studentNo);
//		System.out.println(std2.studentName);
//		System.out.println(std2.score);

		Student[] students = { std1, std2 };
		students = new Student[5];
		students[0] = std1;
		students[1] = std2;

//		System.out.println(students);

		// 120 박길동 90 => std3

		Student std3 = new Student();

		std3.setStudentNo(120);
		std3.setStudentName("박박박");
		std3.setScore(90);

		students[2] = std3;

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				// 4, 5번째 null값
				System.out.println(students[i].getStudentName());
			}
		}

		// 홍길동의 점수, 학번, 이름 출력

		String searchName = "홍길동";

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				// 4, 5번째 null값
				if (students[i].getStudentName().equals(searchName)) {
					System.out.printf("학생번호: %d\n학생이름: %s\n학생점수: %d\n", students[i].getStudentNo(), students[i].getStudentName(),
							students[i].getScore());
					System.out.println();
				}
			}
		}

		// 최고득점학생

		int maxScore = 0;
		// max값을 담기위한 변수
		Student maxStd = new Student();
		// 최고점 학생 정보를 담기위한 인스턴스

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getScore() > maxScore) {
					maxScore = students[i].getScore();
					maxStd = students[i];
				}
			}
		}
		System.out.printf("최고점수를 가진학생\n학생번호: %d\n학생이름: %s\n학생점수: %d", maxStd.getStudentNo(), maxStd.getStudentName(),
				maxStd.getScore());
		System.out.println();

		// 학생총점, 평균점수 구하기

		int sum = 0;
		double avg = 0;
		int cnt = 0; // 학생수 카운트

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				sum += students[i].getScore();
				cnt++;
			}
		}
		avg = sum / cnt;
		System.out.printf("\n합계점수: %d\n평균점수: %.1f", sum, avg);

	} // end of main.

}
