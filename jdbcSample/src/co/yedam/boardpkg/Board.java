package co.yedam.boardpkg;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private int brdNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate;

	public Board(int brdNo, String title, String content, String writer, String writeDate) {
		super();
		this.brdNo = brdNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public Board(int brdNo, String title, String content, String writer) {
		super();
		this.brdNo = brdNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		Date today = new Date(); // 날짜 미입력시 오늘날짜 입력.
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		this.writeDate = sdf.format(today);
	}

	public Board() {

	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "글번호: " + brdNo + ", 제목: " + title + ", 내용: " + content + ", 작성자: " + writer + ", 날짜:" + writeDate;
	}

}
