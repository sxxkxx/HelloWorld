package co.san.newproject.product.service;

import lombok.Data;

@Data
public class ProductVO {
	private int productNumber;
	private String productMaker;
	private String productName;
	private int productPrice;
	private int productQuantity;

	public String toString() {
		System.out.print("제품번호: " + productNumber);
		System.out.print(", 제품명: " + productName);
		System.out.print(", 제품가격: " + productPrice);
		System.out.println(", 재고수량: " + productQuantity);
		return null;
	}

}
