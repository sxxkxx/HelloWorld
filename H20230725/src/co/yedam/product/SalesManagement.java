package co.yedam.product;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesManagement implements Serializable{
	int sNo;
	int no;
	int sQuantity;
	String date;

	public SalesManagement(int sNo, int no, int sQuantity, String date) {
		this.sNo = sNo;
		this.no = no;
		this.sQuantity = sQuantity;
		this.date = date;
	}

	public SalesManagement(int sNo, int no, int sQuantity) {
		this.sNo = sNo;
		this.no = no;
		this.sQuantity = sQuantity;
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		this.date = sdf.format(today);
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getsQuantity() {
		return sQuantity;
	}

	public void setsQuantity(int sQuantity) {
		this.sQuantity = sQuantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "출고번호: " + sNo + ", 상품코드: " + no + ", 출고수량: " + sQuantity + ", 출고일: " + date;
	}
}
