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

	int addMemo(Memo memoCnt) {
		int ox = 0;
		if (cnt < 10) {
			ox = 1;
		}
		memos[cnt++] = memoCnt;
		return ox;
	}

	int checkMemoNum(String no) {
		for (int i = 0; i < memos.length; i++) {
			if (memos[i].memoNo.equals(no)) {
				return 1;
			}
		}
		return 0;
	}

	void editMemo(String no, String content) {
		for (int i = 0; i < memos.length; i++) {
			if (memos[i] != null && memos[i].memoNo.equals(no)) {
				memos[i].setMemoContent(content);
			}
		}

	}

	void delMemo(String no) {
		for (int i = 0; i < memos.length; i++) {
			if (memos[i] != null && memos[i].memoNo.equals(no)) {
				memos[i] = null;
			}
		}
	}

	Memo[] memoList() {
		return memos;
	}

	int findMemo(String no) {
		int cnt = 0;
		for (int i = 0; i < memos.length; i++) {
			if (memos[i] != null && memos[i].memoNo.equals(no)) {
				cnt = i;
			}
		}
		return cnt;
	}

}
