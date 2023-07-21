package co.yedam.collect;

import java.util.ArrayList;
import java.util.List;

import co.yedam.collect.board.Board;
import co.yedam.friend.Friend;

public class ArrayListExe {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); // <타입>: 변수를 선언하는 시점에 담을 수 있는 타입 지정.
		list.add("lee");
		list.add("son");
		list.add("kim");
		for (int i = 0; i < 15; i++) {
			list.add(String.valueOf(i));
		}
//		list.add(19);
//		list.add(new Friend("son", "7777-7777"));

		String obj = list.get(0); // if 배열 : list[0];
		list.set(0, "hwang"); // if 배열 : list[0] = "hwang";
		System.out.println(list.size());
		list.remove(0); // if 배열 : list[0] = null;
		System.out.println(list.size());
		obj = list.get(14);
		System.out.printf(obj);
		System.out.println();
		
//		list.clear();
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("[%d]의 위치값 %s \n",i,list.get(i));
		}
//		Integer num = (Integer) list.get(1);
//		System.out.println(obj + ", " + num);
		System.out.println();
		
		Board bd= new Board(1,obj, obj, obj);
		
		List<Board> bds = new ArrayList<>();
		
		bds.add(bd); 
		
		
		for (int i = 0; i < 15; i++) {
			bds.get((i)).setBoardNo(i+1);
			System.out.println(bds.get((i)).getBoardNo()) ;
		}
		
	}

}
