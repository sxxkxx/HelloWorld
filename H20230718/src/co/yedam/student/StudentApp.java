package co.yedam.student;

/*
 *  학생의 정보 등록, 등록된 학생의 목록 출력, 성적의 합계, 최고점수 계산
 */
public class StudentApp {
	// 필드.
	Student[] students;
	int studentNum = 0;

	// 생성자.
	StudentApp() {
		students = new Student[2];
	}

	// 메소드.
	boolean addStudent(Student std) {
		if (studentNum >= 2) { // 배열에 등록할 공간 부족 => 실패.
			return false;
		}
		students[studentNum++] = std;
		return true;
	}

	Student[] studentList() {
		// for (int i = 0; i < studentNum; i++) {
//			System.out.printf("학생번호 : %s, 이름 : %s, 점수 : %d, 키 : %.1f\n", students[i].stdNo, students[i].stdName,
//					students[i].score, students[i].height);
//		}
		return students;
	}

	int sumScore() {
		int sum = 0;
		for (int i = 0; i < studentNum; i++) {
			sum += students[i].score;
		}
//		System.out.println("합계점수 : " + sum);
		return sum;
	}

	int maxPrint() {
		int max = 0;
		for (int i = 0; i < studentNum; i++) {
			if (max < students[i].score) {
				max = students[i].score;
			}
		}
//		System.out.println("최고점수 : " + max);
		return max;
	}

}
