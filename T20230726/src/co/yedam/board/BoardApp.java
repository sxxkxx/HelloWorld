package co.yedam.board;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class BoardApp {
	List<Board> bds = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	BoardApp() {
		readFromFile();

	}

	public int getNextNo() {
		int no = 0;
		for (int i = 0; i < bds.size(); i++) {
			if (bds.get(i).getNo() > no) {
				no = bds.get(i).getNo();
			}
		}
		return no + 1;
	}

	boolean register(Board bd) {
		if (bds.add(bd)) {
			return true;
		}
		return false;
	}

	boolean modify(int no, String Title, String content) {
		for (Board bd : bds) {

			if (bd.getNo() == no) {
				bd.setTitle(Title);
				bd.setContent(content);

				return true;
			}
		}
		return false;
	}

	Board search(int no) {
		for (Board bd : bds) {
			if (bd.getNo() == no) {
				return bd;
			}
		}
		return null;
	}

	boolean remove(int no) {
		for (int i = 0; i < bds.size(); i++) {
			if (bds.get(i).getNo() == no) {
				bds.remove(i);
				return true;
			}
		}
		return false;

	}

	public List<Board> list() {

		return bds;
	}

	public void readFromFile() {
		// 입력스트림. (객체)
		FileInputStream fis;

		try {
//			fis = new FileInputStream("C:/temp/memos.db"); // 파일 읽을 경로 지정
			fis = new FileInputStream("/Users/sankim/Downloads/boardList.db"); // 파일 읽을 경로 지정
			ObjectInputStream ois = new ObjectInputStream(fis);
			bds = (List<Board>) ois.readObject(); //list 생성한거랑 같이
			ois.close();
			fis.close();
			
			System.out.println("불러오기 완료");
		} catch (Exception e) {
			System.out.println("불러오기 실패");
			e.printStackTrace();
		}

	}

	public void storeToFile() {
		// 출력스트림. (객체)
		FileOutputStream fos;

		try {
//			fos = new FileOutputStream("C:/temp/memos.db");
			fos = new FileOutputStream("/Users/sankim/Downloads/boardList.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bds);
			oos.close();
			fos.close();

			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
