package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectExe {

	public static void main(String[] args) throws Exception {

		Member member = new Member("son", "london", "7777");
		FileOutputStream fos = new FileOutputStream("c:/temp/members.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(member);
		oos.flush();
		oos.close();
		fos.flush();
		fos.close();

		FileInputStream fis = new FileInputStream("c:/temp/members.db");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Member mem = (Member) ois.readObject();
		ois.close();
		fis.close();

		System.out.println("실행완료");
	}

	public void read() throws Exception {
		FileInputStream fis = new FileInputStream("C:/temp/members.db");
		ObjectInputStream ois = new ObjectInputStream(fis);

		List<Member> list = (List<Member>) ois.readObject();
		for (Member member : list) {
			System.out.println(member);
		}
		ois.close();
		fis.close();

	}

	public void write() throws Exception {
		// 스트림 -> 컬렉션.
		// 객체 -> 바이트 : 직렬화.
		List<Member> members = new ArrayList<>();
		members.add(new Member("bruno", "manchester", "8888"));

		FileOutputStream fos = new FileOutputStream("C:/temp/members.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(members);
		oos.flush();
		oos.close();
		fos.flush();
		fos.close();
	}
}
