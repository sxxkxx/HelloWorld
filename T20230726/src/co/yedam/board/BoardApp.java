package co.yedam.board;

import java.io.BufferedReader;
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
		read();

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

	public void read() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/temp/boardList.db");
			ObjectInputStream ois = new ObjectInputStream(fis);

			List<Board> bds = (List<Board>) ois.readObject();

			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void write() {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("C:/temp/boardList.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < bds.size(); i++) {
				oos.writeObject(bds.get(i));
			}
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
