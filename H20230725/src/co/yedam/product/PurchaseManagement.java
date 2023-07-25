package co.yedam.product;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseManagement implements Serializable {
	int pNo;
	int no;
	int pQuantity;
	String date;

	public PurchaseManagement(int pNo, int no, int pQuantity, String date) {
		this.pNo = pNo;
		this.no = no;
		this.pQuantity = pQuantity;
		this.date = date;
	}

	public PurchaseManagement(int pNo, int no, int pQuantity) {
		this.pNo = pNo;
		this.no = no;
		this.pQuantity = pQuantity;
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		this.date = sdf.format(today);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "입고번호: " + pNo + ", 상품코드: " + no + ", 출고수량: " + pQuantity + ", 출고일: " + date;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
}
