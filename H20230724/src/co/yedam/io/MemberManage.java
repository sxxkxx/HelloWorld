package co.yedam.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberManage {
	// 추가, 수정, 삭제, 목록, 저장
	List<Member> members = new ArrayList<>();

	MemberManage() {
//		try {
//			FileReader fr = new FileReader("c:/temp/members.txt");
//			BufferedReader br = new BufferedReader(fr);
//
//			while (true) {
//				String str = br.readLine();
//				if (str == null) {
//					break;
//				}
//				String[] data = str.split(" ");
//				members.add(new Member(data[0], data[1], data[2]));
//			}
//			System.out.println("              ⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀\r\n"
//					+ "등록완료 ⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀\r\n"
//					+ "⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀\r\n"
//					+ "⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄\r\n"
//					+ "⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇\r\n"
//					+ "⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷\r\n"
//					+ "⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃\r\n"
//					+ "⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀\r\n"
//					+ "⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀\r\n"
//					+ "⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/temp/members.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			members = (List<Member>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("           ⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀\r\n"
					+ "        ⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀\r\n"
					+ "⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄\r\n"
					+ "⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇\r\n"
					+ "⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷\r\n"
					+ "⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃\r\n"
					+ "⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀\r\n"
					+ "⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀\r\n"
					+ "⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	boolean addMem(Member member) {
		return members.add(member);
	}

	boolean editMem(Member member) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(member.getName())) {

				members.get(i).setAddr(member.getAddr());
				members.get(i).setPhone(member.getPhone());
				return true;
			}
		}
		return false;
	}

	boolean delMem(String name) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {
				members.remove(i);
				return true;
			}
		}
		return false;
	}

	List<Member> list() {
		return members;
	}

	void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/members.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(members);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void saveold() {
		try {
			FileWriter fw = new FileWriter("c:/temp/members.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (Member member : members) {
				String data = member.getName() + " " + member.getAddr() + " " + member.getPhone();

				bw.write(data + "\n");
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
