package co.yedam.memo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {
	Scanner sc = new Scanner(System.in);
	List<Memo> memoStorage = new ArrayList<>();

	public MemoManager() {
		readFromFile();
	}

	public void printMenu() {
		System.out.println("1.등록 2.검색 3.삭제 4.종료");
		System.out.print("선택>> ");
	}

	private int getNextNo() {
		int no = 0;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() > no) {
				no = memoStorage.get(i).getNo();
			}
		}
		return no + 1;
	}

	public void inputData() {
		int no = getNextNo();
		System.out.print("날짜>> ");
		String date = sc.nextLine();
		System.out.print("내용>> ");
		String content = sc.nextLine();

		Memo memo = null;
		if (date.isEmpty()) {
			memo = new Memo(no, content);
		} else {
			memo = new Memo(no, date, content);
		}
		if (memoStorage.add(memo)) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록실패");
		}

	}

	public void searchData() {
		System.out.println("날짜형식 YY-MM-DD");
		System.out.print("날짜입력>> ");
		String date = sc.nextLine();
		int a = 0;
		// 입력된 날짜의 메모를 출력.
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getDate().equals(date)) {
				System.out.println(memoStorage.get(i).toString());
				a = 1;
			}

		}
		if (a == 0) {
			System.out.println("메모 없음");
		}
	}

	public void deleteData() {
		System.out.print("번호>> ");
		int no = Integer.parseInt(sc.nextLine());
		int a = 0;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() == no) {
				memoStorage.remove(i);
				System.out.println("삭제 완료");
				a = 1;
			}
		}
		if (a == 0) {
			System.out.println("없는 번호");
		}
	}

	public void storeToFile() {
		// 출력스트림. (객체)
		FileOutputStream fos;

		try {
			fos = new FileOutputStream("C:/temp/memos.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(memoStorage);
			oos.close();
			fos.close();

			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void readFromFile() {
		// 입력스트림. (객체)
		FileInputStream fis;

		try {
			fis = new FileInputStream("C:/temp/memos.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			memoStorage = (List<Memo>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀\r\n" + "⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀\r\n" + "⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄\r\n"
					+ "⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇\r\n" + "⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷\r\n"
					+ "⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃\r\n" + "⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀\r\n"
					+ "⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀\r\n" + "⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁");
			System.out.println("           불러오기 완료");
		} catch (Exception e) {
			System.out.println("불러오기 실패");
			e.printStackTrace();
		}

	}
}
