package co.yedam.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {

	int no;
	String product;
	int price;
	int stocks;

	Product(int no, String product, int price) {
		this.no = no;
		this.product = product;
		this.price = price;
		stocks = 0;
	}

	@Override
	public String toString() {
		return "상품코드: " + no + ", 제품명: " + product + ", 재고수량: " + stocks;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

}
