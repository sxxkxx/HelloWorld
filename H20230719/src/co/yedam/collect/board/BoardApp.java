package co.yedam.collect.board;

import java.util.ArrayList;
import java.util.List;

public class BoardApp {

	int cnt = 0; // 게시글 번호 자동부여
	// 게시글저장. 컬렉션이용
	List<Board> bds = new ArrayList<>();

	boolean addBd(Board bd) {

		bds.add(bd);
		bd.setBoardNo(++cnt); // 게시글 번호 자동부여
		return true;
	}

	List<Board> bdList() {
		return bds;
	}

	Board getBd(int boardNo) {
		for (int i = 0; i < bds.size(); i++) {
			bds.get((i)).getBoardNo();
			if (boardNo == bds.get((i)).getBoardNo()) {
				return bds.get(i);
			}
		}
		return null;
	}

	boolean checkBoard(int boardNo, String id) {
		for (int i = 0; i < bds.size(); i++) {
			bds.get(i).getBoardNo();
			if (boardNo == bds.get(i).getBoardNo() && bds.get(i).getWriter().equals(id)) {
				return true;
			}
		}
		return false;
	}

	void editBoard(int boardNo, String id, String title, String content) {
		for (int i = 0; i < bds.size(); i++) {
			bds.get((i)).getBoardNo();
			if (boardNo == bds.get((i)).getBoardNo() && bds.get((i)).getWriter().equals(id)) {
				bds.get((i)).setTitle(title);
				bds.get((i)).setContent(content);
			}
		}

	}

	boolean delBoard(int boardNo, String id) {
		for (int i = 0; i < bds.size(); i++) {
			bds.get(i).getBoardNo();
			if (boardNo == bds.get(i).getBoardNo() && bds.get(i).getWriter().equals(id)) {
				bds.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean addBd(String title, String content, String id) {
		// TODO Auto-generated method stub
		return false;
	}
}
