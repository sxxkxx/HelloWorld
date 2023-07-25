package co.yedam.product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductApp {
	Scanner sc = new Scanner(System.in);
	List<Product> productList = new ArrayList<>();
	List<SalesManagement> salesList = new ArrayList<>();
	List<PurchaseManagement> purchaseList = new ArrayList<>();

	ProductApp() {
		readFromFile();
	}

	public void printMenu() {
		System.out.println("1.상품등록 2.출고관리 3.입고관리 4.현재재고 5.종료");
		System.out.print("선택>> ");
	}

	private int getNextNo() {
		int no = 0;
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getNo() > no) {
				no = productList.get(i).getNo();
			}
		}
		return no + 1;
	}

	private int getSNextNo() {
		int no = 0;
		for (int i = 0; i < salesList.size(); i++) {
			if (salesList.get(i).getsNo() > no) {
				no = salesList.get(i).getsNo();
			}
		}
		return no + 1;
	}

	private int getPNextNo() {
		int no = 0;
		for (int i = 0; i < purchaseList.size(); i++) {
			if (purchaseList.get(i).getNo() > no) {
				no = purchaseList.get(i).getNo();
			}
		}
		return no + 1;
	}

	public void addPrd() {
		int no = getNextNo();
		System.out.println("상품 등록");
		System.out.print("제품명 입력 >> ");
		String product = sc.nextLine();
		System.out.print("가격 입력 >> ");
		int price = Integer.parseInt(sc.nextLine());

		Product prd = new Product(getNextNo(), product, price);

		if (productList.add(prd)) {
			System.out.println(no + "번 상품 등록완료");
		} else {
			System.out.println("등록실패");
		}

	}

	public void salesMgr(boolean stop) {
		sReadFromFile();
		stop = true;
		int sMenu = 0;
		while (stop) {
			while (true) {
				try {
					int ox = 0;
					System.out.println("1.출고내역 등록 2.출고내역 수정 3.출고내역 삭제 4.출고내역 조회 5.메인메뉴");
					System.out.print("선택>> ");
					sMenu = Integer.parseInt(sc.nextLine());
					if (sMenu == 1) {
						System.out.print("상품 코드 입력 >> ");
						int no = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < productList.size(); i++) {
							if (no == productList.get(i).getNo()) {
								System.out.print("출고 수량 입력>> ");
								int sQuantity = Integer.parseInt(sc.nextLine());
								System.out.print("날짜 입력>> ");
								String date = sc.nextLine();
								int sNo = getSNextNo();
								SalesManagement sMgr = null;
								ox = 1;
								if (date.isEmpty()) {
									sMgr = new SalesManagement(sNo, no, sQuantity);
								} else {
									sMgr = new SalesManagement(sNo, no, sQuantity, date);
								}
								if (productList.get(i).getStocks() - sQuantity >= 0) {
									if (salesList.add(sMgr)) {
										System.out.println("등록 완료");
										productList.get(i).setStocks(productList.get(i).getStocks() - sQuantity);

									} else {
										System.out.println("등록 실패");
										break;
									}
								} else {
									System.out.println("재고 부족");
									break;
								}
							}
						}
						if (ox == 0) {
							System.out.println("없는 상품");
						}
					} else if (sMenu == 2) {
						ox = 0;
						int cnt = 0;
						System.out.print("상품 코드 입력 >>");
						int no = Integer.parseInt(sc.nextLine());
						int stocks = 0;
						for (int i = 0; i < salesList.size(); i++) {
							if (no == salesList.get(i).getNo()) {
								System.out.println(salesList.get(i).toString());
								ox = 1;
							}

						}
						for (int i = 0; i < productList.size(); i++) {
							if (no == productList.get(i).getNo()) {
								cnt = i;
							}
						}
						if (ox == 0) {
							System.out.println("없는 제품");
							break;
						}

						ox = 2;
						System.out.println("수정할 출고 번호");
						System.out.print("입력>> ");
						int sNo = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < salesList.size(); i++) {
							if (no == salesList.get(i).getNo() && sNo == salesList.get(i).getsNo()) {
								System.out.print("출고 수량 입력>> ");
								int sQuantity = Integer.parseInt(sc.nextLine());
								stocks = salesList.get(i).getsQuantity() + productList.get(cnt).getStocks();
								if (stocks - sQuantity >= 0) {
									productList.get(cnt).setStocks(stocks - sQuantity);
									salesList.get(i).setsQuantity(sQuantity);
									System.out.println("수정 완료");
									ox = 3;
								} else {
									System.out.println("재고 없음");
									break;
								}

							}
						}
						if (ox == 2) {
							System.out.println("출고 번호 불일치");
						}
					} else if (sMenu == 3) {
						ox = 0;
						int cnt = 0;
						System.out.print("상품 코드 입력 >> ");
						int no = Integer.parseInt(sc.nextLine());
						int stocks = 0;
						for (int i = 0; i < salesList.size(); i++) {
							if (no == salesList.get(i).getNo()) {
								System.out.println(salesList.get(i).toString());
								ox = 1;
							}

						}
						for (int i = 0; i < productList.size(); i++) {
							if (no == productList.get(i).getNo()) {
								cnt = i;
							}
						}
						if (ox == 0) {
							System.out.println("없는 제품");
							break;
						}

						ox = 2;
						System.out.println("삭제 출고 번호");
						System.out.print("입력>> ");
						int sNo = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < salesList.size(); i++) {
							if (no == salesList.get(i).getNo() && sNo == salesList.get(i).getsNo()) {
								stocks = salesList.get(i).getsQuantity() + productList.get(cnt).getStocks();
								productList.get(cnt).setStocks(stocks);
								salesList.remove(i);
								System.out.println("삭제 완료");
								ox = 3;
							}

						}
						if (ox == 2) {
							System.out.println("출고 번호 불일치");
						}
					} else if (sMenu == 4) {
						ox = 0;
						System.out.print("상품 코드 입력 >> ");
						int no = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < salesList.size(); i++) {
							if (no == salesList.get(i).getNo()) {
								System.out.println(salesList.get(i).toString());
								ox = 1;
							}

						}
						if (ox == 0) {
							System.out.println("없는 제품");
						}
					} else if (sMenu == 5) {
						stop = false;
						storeToFile(salesList, "C:/temp/slist.db");
						storeToFile(productList, "c:/temp/prdlist.db");
						break;
					}

				} catch (NumberFormatException e) {
					System.out.println("숫자입력");
				}
			}
		}

	}

	public void purchaseMgr(boolean stop) {
		pReadFromFile();
		stop = true;
		int sMenu = 0;
		while (stop) {
			while (true) {
				try {
					int ox = 0;
					System.out.println("1.입고내역 등록 2.입고내역 수정 3.입고내역 삭제 4.입고내역 조회 5.메인메뉴");
					System.out.print("선택>> ");
					sMenu = Integer.parseInt(sc.nextLine());
					if (sMenu == 1) {
						System.out.print("상품 코드 입력 >> ");
						int no = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < productList.size(); i++) {
							if (no == productList.get(i).getNo()) {
								System.out.print("입고 수량 입력>> ");
								int pQuantity = Integer.parseInt(sc.nextLine());
								System.out.print("날짜 입력>> ");
								String date = sc.nextLine();
								int pNo = getPNextNo();
								PurchaseManagement pMgr = null;
								ox = 1;
								if (date.isEmpty()) {
									pMgr = new PurchaseManagement(pNo, no, pQuantity);
								} else {
									pMgr = new PurchaseManagement(pNo, no, pQuantity, date);
								}

								if (purchaseList.add(pMgr)) {
									System.out.println("등록 완료");
									productList.get(i).setStocks(productList.get(i).getStocks() + pQuantity);

								} else {
									System.out.println("등록 실패");
									break;
								}

							}
						}
						if (ox == 0) {
							System.out.println("없는 상품");
						}
					} else if (sMenu == 2) {
						ox = 0;
						int cnt = 0;
						System.out.print("상품 코드 입력 >>");
						int no = Integer.parseInt(sc.nextLine());
						int stocks = 0;
						for (int i = 0; i < purchaseList.size(); i++) {
							if (no == purchaseList.get(i).getNo()) {
								System.out.println(purchaseList.get(i).toString());
								ox = 1;
							}

						}
						for (int i = 0; i < productList.size(); i++) {
							if (no == productList.get(i).getNo()) {
								cnt = i;
							}
						}
						if (ox == 0) {
							System.out.println("없는 제품");
							continue;
						}

						ox = 2;
						System.out.println("수정할 입고 번호");
						System.out.print("입력>> ");
						int pNo = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < purchaseList.size(); i++) {
							if (no == purchaseList.get(i).getNo() && pNo == purchaseList.get(i).getpNo()) {
								System.out.print("입고 수량 입력>> ");
								int pQuantity = Integer.parseInt(sc.nextLine());
								stocks = productList.get(cnt).getStocks() - purchaseList.get(i).getpQuantity();

								productList.get(cnt).setStocks(stocks + pQuantity);
								purchaseList.get(i).setpQuantity(pQuantity);
								System.out.println("수정 완료");
								ox = 3;

							}
						}
						if (ox == 2) {
							System.out.println("입고 번호 불일치");
						}
					} else if (sMenu == 3) {
						ox = 0;
						int cnt = 0;
						System.out.print("상품 코드 입력 >> ");
						int no = Integer.parseInt(sc.nextLine());
						int stocks = 0;
						for (int i = 0; i < purchaseList.size(); i++) {
							if (no == purchaseList.get(i).getNo()) {
								System.out.println(purchaseList.get(i).toString());
								ox = 1;
							}

						}
						for (int i = 0; i < productList.size(); i++) {
							if (no == productList.get(i).getNo()) {
								cnt = i;
							}
						}
						if (ox == 0) {
							System.out.println("없는 제품");
							continue;
						}

						ox = 2;
						System.out.println("삭제 입고 번호");
						System.out.print("입력>> ");
						int pNo = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < purchaseList.size(); i++) {
							if (no == purchaseList.get(i).getNo() && pNo == purchaseList.get(i).getpNo()) {
								stocks = productList.get(cnt).getStocks() - purchaseList.get(i).getpQuantity();
								productList.get(cnt).setStocks(stocks);
								purchaseList.remove(i);
								System.out.println("삭제 완료");
								ox = 3;
							}

						}
						if (ox == 2) {
							System.out.println("입고 번호 불일치");
						}
					} else if (sMenu == 4) {
						ox = 0;
						System.out.print("상품 코드 입력 >> ");
						int no = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < purchaseList.size(); i++) {
							if (no == purchaseList.get(i).getNo()) {
								System.out.println(purchaseList.get(i).toString());
								ox = 1;
							}

						}
						if (ox == 0) {
							System.out.println("없는 제품");
						}
					} else if (sMenu == 5) {
						stop = false;
						storeToFile(purchaseList, "C:/temp/plist.db");
						storeToFile(productList, "c:/temp/prdlist.db");
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("숫자 입력");
				}
			}
		}

	}

	public void invenInquiry() {
		int ox = 0;
		System.out.print("상품 코드 입력 >> ");
		int no = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < productList.size(); i++) {
			if (no == productList.get(i).getNo()) {
				System.out.println(productList.get(i).toString());
				ox = 1;
			}
		}
		if (ox == 0) {
			System.out.println("없는 상품");
		}
	}

	public void readFromFile() {
		// 입력스트림. (객체)
		FileInputStream fis;

		try {

			fis = new FileInputStream("C:/temp/prdlist.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			productList = (List<Product>) ois.readObject();
			ois.close();
			fis.close();

			System.out.println("불러오기 완료");
		} catch (Exception e) {
			System.out.println("불러오기 실패");
			e.printStackTrace();
		}

	}

	public void sReadFromFile() {
		// 입력스트림. (객체)
		FileInputStream fis;

		try {

			fis = new FileInputStream("C:/temp/slist.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			salesList = (List<SalesManagement>) ois.readObject();
			ois.close();
			fis.close();

			System.out.println("불러오기 완료");
		} catch (Exception e) {
			System.out.println("불러오기 실패");
			e.printStackTrace();
		}

	}

	public void pReadFromFile() {
		// 입력스트림. (객체)
		FileInputStream fis;

		try {

			fis = new FileInputStream("C:/temp/plist.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			purchaseList = (List<PurchaseManagement>) ois.readObject();
			ois.close();
			fis.close();

			System.out.println("불러오기 완료");
		} catch (Exception e) {
			System.out.println("불러오기 실패");
			e.printStackTrace();
		}

	}

	public void storeToFile(List list, String path) {
		// 출력스트림. (객체)
		FileOutputStream fos;

		try {
			fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();

			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
