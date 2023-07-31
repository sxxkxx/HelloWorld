package co.san.newproject.inventory.service;

import java.sql.Date;
import java.time.LocalDate;


import lombok.Data;

@Data
public class InventoryVO {
	private int inventoryNumber;
	private int productNumber;
	private String inventoryStatus;
	private int inventoryQuantity;
	private Date inventoryDate;

//	private LocalDate inventoryDate;

	@Override
	public String toString() {
		System.out.print("관리번호: " + inventoryNumber);
		System.out.print(", 제품번호: " + productNumber);
		System.out.print(", " + inventoryStatus + "수량: " + inventoryQuantity);
		System.out.println(", " + inventoryStatus + "날짜: " + inventoryDate);
		return null;
	}
}
