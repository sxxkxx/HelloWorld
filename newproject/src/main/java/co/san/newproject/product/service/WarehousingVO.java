package co.san.newproject.product.service;

import java.util.Date;

public class WarehousingVO {
	private int warehousingNumber;
	private int productNumber;
	private String warehousingStatus;
	private int warehousingQuatity;
	private Date warehousingDate;

	@Override
	public String toString() {
		System.out.print("관리번호: " + warehousingNumber);
		System.out.print(", 제품번호: " + productNumber);
		System.out.print(", " + warehousingStatus + "수량: " + warehousingQuatity);
		System.out.println(", " + warehousingStatus + "날짜: " + warehousingDate);
		return null;
	}
}
