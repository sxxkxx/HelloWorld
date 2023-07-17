package co.yedam.student;

// 복합적인 구조의 데이터.
public class Student {
	// 필드.
	private int studentNo; // private => 타 클래스에서 접근불가
	private String studentName;
	private int score;

	// 메소드(함수기능)
	// 메소드의 네이밍 룰(Naming rule) : 두 단어의 조합이면 두번째 단어의 첫번째 글자는 대문자로 표기. =>setStudentNo
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentName(String sn) {
		studentName = sn;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setScore(int score) {
		if (score < 0) {
			this.score = 0;
		} else {
			this.score = score;
		}
	}

	public int getScore() {
		return score;
	}
}
