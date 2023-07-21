package co.yedam.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import co.yedam.friend.Friend;

public class ArrayListExe2 {

	public static void main(String[] args) {
		List<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("son","7777"));
//		friends.add(new Friend("kim","3333"));
		Friend friend = new Friend("kim","3333");
		friends.add(friend);
		friends.remove(friend); //오브젝트 값으로도 삭제가능.
		
		System.out.println(friends.size());
		
		List<String> list = new Vector<>(); // ArrayList 클래스
		
		list.add("lee");
		list.add("hong");
		list.remove(0);
	}

}
