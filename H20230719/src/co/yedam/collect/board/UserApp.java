package co.yedam.collect.board;

import java.util.Hashtable;
import java.util.Map;

public class UserApp {
	Map<String, String> users = new Hashtable<String, String>();

	UserApp() {
		users.put("son", "7777");
		users.put("lee", "1919");
		users.put("kim", "3333");
	}

	boolean idCheck(String id) {
		if (users.containsKey(id)) {
			return true;
		}
		return false;
	}

	boolean login(String id, String pw) {
		if (users.get(id).equals(pw)) {
			return true;
		}
		return false;
	}
}
