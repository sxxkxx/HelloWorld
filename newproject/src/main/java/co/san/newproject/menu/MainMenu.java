package co.san.newproject.menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import co.san.newproject.inventory.service.InventoryService;
import co.san.newproject.inventory.service.InventoryVO;
import co.san.newproject.inventory.serviceImpl.InventoryServiceImpl;
import co.san.newproject.product.service.ProductService;
import co.san.newproject.product.service.ProductVO;
import co.san.newproject.product.serviceImpl.ProductServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private ProductService ps = new ProductServiceImpl();
	private InventoryService is = new InventoryServiceImpl();

	// 메인 메뉴 출력
	private void mainTitle() {
		System.out.println();
		System.out.println("    ____                \r\n" + "  /\\  _`\\   /'\\_/`\\    \r\n"
				+ "  \\ \\ \\L\\ \\/\\      \\   \r\n" + "   \\ \\ ,__/\\ \\ \\__\\ \\  \r\n"
				+ "    \\ \\ \\/  \\ \\ \\_/\\ \\ \r\n" + "     \\ \\_\\   \\ \\_\\\\ \\_\\\r\n"
				+ "      \\/_/    \\/_/ \\/_/");
		System.out.println("========= 메인 메뉴 =========");
		System.out.println("======== 1.제품 관리 ========");
		System.out.println("======== 2.입출고 관리 ======");
		System.out.println("======== 3.종료 =============");
		System.out.println("========= 메뉴 선택 =========");
	}

	// 제품 관리 메뉴 출력
	private void productTitle() {
		System.out.println();
		System.out.println("========= 제품 관리 =========");
		System.out.println("======== 1.제품 등록 ========");
		System.out.println("======== 2.제품 삭제 ========");
		System.out.println("======== 3.제품 수정 ========");
		System.out.println("======== 4.제품 목록 ========");
		System.out.println("======== 5.메인 메뉴 ========");
		System.out.println("========= 메뉴 선택 =========");
	}

	// 입출고 관리 메뉴 출력
	private void inventoryTitle() {
		System.out.println();
		System.out.println("======== 입출고 관리 ========");
		System.out.println("======== 1.제품 입고 ========");
		System.out.println("======== 2.제품 출고 ========");
		System.out.println("======== 3.입출고 내역 ======");
		System.out.println("======== 4.재고 조회 ========");
		System.out.println("======== 5.메인 메뉴 ========");
		System.out.println("========= 메뉴 선택 =========");
	}

	// 프로그램 실행
	public void run() {
		boolean b = false;
		int key = 0;
		do {

			while (true) {
				try {
					mainTitle();
					System.out.print("숫자를 입력하세요>> ");
					key = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("숫자를 입력하세요!!!!");
				}

			}
			switch (key) {
			case 1:
				productManager();
				break;
			case 2:
				inventoryManager();
				break;
			case 3:
				System.out.println("                   __     \r\n" + "                  /\\ \\    \r\n"
						+ "   __     ___     \\_\\ \\   \r\n" + " /'__`\\ /' _ `\\   /'_` \\  \r\n"
						+ "/\\  __/ /\\ \\/\\ \\ /\\ \\L\\ \\ \r\n" + "\\ \\____\\\\ \\_\\ \\_\\\\ \\___,_\\\r\n"
						+ " \\/____/ \\/_/\\/_/ \\/__,_ /");
				System.out.println("========= 작업 종료 =========");
				b = true;
				break;
			default:
				System.out.println("========= 없는 메뉴 =========");
			}
		} while (!b);
		sc.close();
	}

	// 제품 관리 메뉴
	private void productManager() {
		boolean stop = false;
		int key = 0;
		do {
			while (true) {
				try {
					productTitle();
					System.out.print("숫자를 입력하세요>> ");
					key = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException e) {
					sc.nextLine();
					System.out.println("숫자를 입력하세요!!!!");
				}

			}
			switch (key) {
			case 1:
				productInsert();
				break;
			case 2:
				productDelete();
				break;
			case 3:
				productUpdate();
				break;
			case 4:
				productList();
				break;
			case 5:
				System.out.println("======= 제품 관리 종료 =======");
				stop = true;
				break;
			default:
				System.out.println("========= 없는 메뉴 =========");
			}

		} while (!stop);

	}

	// 입출고 관리 메뉴
	private void inventoryManager() {
		boolean stop = false;
		int key = 0;
		do {
			while (true) {
				try {
					inventoryTitle();
					System.out.print("숫자를 입력하세요>> ");
					key = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("숫자를 입력하세요!!!!");
				}

			}
			switch (key) {
			case 1:
				productStore();
				break;
			case 2:
				productRelease();
				break;
			case 3:
				inventoryHistory();
				break;
			case 4:
				inventoryInquiry();
				break;
			case 5:
				System.out.println("====== 입출고 관리 종료 =======");
				stop = true;
				break;
			default:
				System.out.println("========= 없는 메뉴 =========");
			}

		} while (!stop);
	}

	// 제품 등록
	private void productInsert() {
		System.out.println("제품 등록");
		ProductVO product = new ProductVO();
		int no = ps.getNextProductNumber(); // 제품번호를 자동으로 입력.
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

	// 제품 가격 수정
	private void productUpdate() {
		while (true) {
			try {
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
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요!!!!");
			}
		}
	}

	// 제품 삭제
	private void productDelete() {
		while (true) {
			try {
				System.out.println("제품 삭제");
				ProductVO product = new ProductVO();
				System.out.println("제품번호 입력");
				int no = Integer.parseInt(sc.nextLine());
				product.setProductNumber(no);
				if (ps.productDelete(product) != 0) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요!!!!");
			}
		}
	}

	// 제품 목록
	private void productList() {
		List<ProductVO> products = ps.productList();
		if (!products.isEmpty()) {
			for (ProductVO product : products) {
				product.toString();
			}
		} else {
			System.out.println("제품이 존재하지 않음");
		}
	}

	// 제품 입고
	private void productStore() {
		while (true) {
			try {
				System.out.println("제품 입고");
				ProductVO product = new ProductVO();
				System.out.println("제품번호 입력");
				int no = Integer.parseInt(sc.nextLine());
				System.out.println("입고수량 입력");
				int quantity = Integer.parseInt(sc.nextLine());
				System.out.println("입고날짜 입력 (YYMMDD)");
				String date = sc.nextLine();
				product.setProductQuantity(quantity);
				product.setProductNumber(no);

				// 재고가 입고되면 입고 내역 저장
				if (ps.productStore(product) != 0) {
					InventoryVO inventoryvo = new InventoryVO();
					inventoryvo.setInventoryNumber(is.getNextInventoryNumber());
					inventoryvo.setProductNumber(no);
					inventoryvo.setInventoryQuantity(quantity);
					inventoryvo.setInventoryDate(dateCheck(date)); // 입고일 미입력시 오늘 날짜 입력.

					is.inventoryStore(inventoryvo);
					System.out.println("입고 등록 완료");
				} else {
					System.out.println("입고 등록 실패");
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
			}
		}
	}

	// 제품 출고
	private void productRelease() {
		while (true) {
			try {
				System.out.println("제품 출고");
				ProductVO product = new ProductVO();
				System.out.println("제품번호 입력");
				int no = Integer.parseInt(sc.nextLine());
				System.out.println("출고수량 입력");
				int quantity = Integer.parseInt(sc.nextLine());
				System.out.println("출고날짜 입력 (YYMMDD)");
				String date = sc.nextLine();
				product.setProductQuantity(quantity);
				product.setProductNumber(no);

				// 재고가 출고되면 출고 내역 저장
				if (ps.productRelease(product) != 0) {
					InventoryVO inventoryvo = new InventoryVO();
					inventoryvo.setInventoryNumber(is.getNextInventoryNumber());
					inventoryvo.setProductNumber(no);
					inventoryvo.setInventoryQuantity(quantity);
					inventoryvo.setInventoryDate(dateCheck(date)); // 출고일 미입력시 오늘 날짜 입력.

					is.inventoryRelease(inventoryvo);
					System.out.println("출고 등록 완료");
				} else {
					System.out.println("재고 부족");
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요!!!!");
			}
		}
	}

	// 입출고 내역 조회
	private void inventoryHistory() {

		List<InventoryVO> inventoryHistory = is.inventoryHistory();
		if (!inventoryHistory.isEmpty()) {
			for (InventoryVO vo : inventoryHistory) {
				vo.toString();
			}
		} else {
			System.out.println("내역이 존재하지 않음");
		}
	}

	// 재고 조회
	private void inventoryInquiry() {
		List<ProductVO> products = is.inventoryInquiry();
		if (!products.isEmpty()) {
			for (ProductVO vo : products) {
				vo.toString2();
			}
		} else {
			System.out.println("내역이 존재하지 않음");
		}
	}

	// 입력날짜가 없으면, 오늘날짜입력
	private LocalDate dateCheck(String dateString) {
		LocalDate date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
		if (dateString.length() != 6) {
			date = LocalDate.now();
		} else {
			date = LocalDate.parse(dateString, formatter);
		}
		return date;
	}

}