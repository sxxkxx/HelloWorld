package co.yedam.memo;

public class MemoApp {
	Memo[] memos;
	int cnt = 0;

	private static MemoApp instance = new MemoApp();

	public static MemoApp getInstance() {
		return instance;
	}

	private MemoApp() {
		memos = new Memo[10];
	}

	 void addMemo(Memo memoCnt) {
		
		memos[cnt++] = memoCnt;
		;
	}

	boolean checkMemoNum(int no) {
		for (int i = 0; i < memos.length; i++) {
			if (memos[i] != null && no == memos[i].memoNo) {
				return true;
			}
		}
		return false;
	}

	void editMemo(int no, String content) {
		for (int i = 0; i < memos.length; i++) {
			if (no == memos[i].memoNo) {
				memos[i].memoContent = content;
			}
		}

	}

	int findMemo(int no) {
		int cnt = 0;
		for (int i = 0; i < memos.length; i++) {
			if (no == memos[i].memoNo) {
				cnt = i;
			}
		}
		return cnt;
	}
}
