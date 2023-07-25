package co.yedam.board;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable {
	String no;
	String title;
	String content;
	String id;
	String date;

	public Board(String no, String title, String content, String id, String date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.id = id;
		this.date = date;
	}

	public Board(String no, String title, String content, String id) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.id = id;
		this.date = date;
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		this.date = sdf.format(today);
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
