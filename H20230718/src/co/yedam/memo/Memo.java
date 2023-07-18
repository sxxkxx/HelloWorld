package co.yedam.memo;

public class Memo {
	
	private static Memo instance = new Memo();
	// 글번호 내용 등록날짜
	int memoNo;
	String memoContent;
	String memoDate;

	private Memo() {

	}

	private Memo(int memoNo, String memoContent, String memoDate) {
		super();
		this.memoNo = memoNo;
		this.memoContent = memoContent;
		this.memoDate = memoDate;
	}
	
	public static Memo getInstance(int no, String content, String date) {
		return instance;
	}

	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}
	
	
	
}
