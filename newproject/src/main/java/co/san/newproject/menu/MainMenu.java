package co.san.newproject.menu;

import java.util.Scanner;
import java.util.Set;

import co.san.newproject.product.service.ProductService;
import co.san.newproject.product.service.ProductVO;
import co.san.newproject.product.serviceImpl.ProductServiceImpl;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
	private ProductService ps = new ProductServiceImpl();

	private void mainTitle() {
		System.out.println("==== 제품 관리 =======");
		System.out.println("==== 1.제품 등록 =====");
		System.out.println("==== 2.제품 수정 =====");
		System.out.println("==== 3.제품 삭제 =====");
		System.out.println("==== 4.제품 입고 =====");
		System.out.println("==== 5.제품 출고 =====");
		System.out.println("==== 6.입출고 내역 ====");
		System.out.println("==== 7.제품 관리 종료 ==");
		System.out.println("==== 메뉴 번호 입력 ====");
	}

	public void run() {
		boolean b = false;
		do {
			mainTitle();
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				productInsert();
				break;
			case 2:
				productUpdate();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:
				System.out.println("=====작업 종료=====");
				b = true;
				break;
			}

		} while (!b);
		sc.close();
	}

	private void productInsert() {
		System.out.println("제품 등록");
		ProductVO product = new ProductVO();
		System.out.println("제품번호 입력");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("제조사 입력");
		String maker = sc.nextLine();
		System.out.println("제품명 입력");
		String name = sc.nextLine();
		System.out.println("제품가격 입력");
		int price = Integer.parseInt(sc.nextLine());

		product.setProductNumber(no);
		product.setProductMaker(maker);
		product.setProductName(name);
		product.setProductPrice(price);
		if (ps.productInsert(product) != 0) {
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 실패");
		}

	}

	private void productUpdate() {
		System.out.println("제품 수정");
		ProductVO product = new ProductVO();
		System.out.println("제품번호 입력");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("제품가격 입력");
		int price = Integer.parseInt(sc.nextLine());
		product.setProductPrice(price);
		product.setProductNumber(no);
		if (ps.productUpdate(product) != 0) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
	}

	private void productDelete() {

	}

	private void productStore() {

	}

	private void productRelease() {

	}

}