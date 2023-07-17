package com.yedam.board;

public class Board {
	// 글번호, 글제목, 글내용, 작성자
	int boardNo;
	String boardTitle;
	String boardText;
	String writter;
	int page;

	public Board(int boardNo, String boardTitle, String boardText, String writter) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardText = boardText;
		this.writter = writter;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardText() {
		return boardText;
	}

	public void setBoardText(String boardText) {
		this.boardText = boardText;
	}

	public String getWritter() {
		return writter;
	}

	public void setWritter(String writter) {
		this.writter = writter;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String showList() {
		return "글번호 : " + boardNo + ", 글제목 : " + boardTitle + ", 작성자 : " + writter;
	}

	public String showFullList() {
		return "글번호 : " + boardNo + ", 글제목 : " + boardTitle + "\n글내용 : " + boardText + ", 작성자 : " + writter;
	}
}
