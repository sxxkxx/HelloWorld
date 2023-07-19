package co.yedam.friend;

public class AdderessAppExe {

	public static void main(String[] args) {

		Friend[] friends = new Friend[10];
						
		// friends배열에 Friend 클래스의 인스턴스 대입.
		friends[0] = new Friend("son", "7777-7777");
		friends[1] = new UniFriend("kim", "3333-3333", "뮌헨대", "수비학과");
		friends[2] = new CompFriend("lee", "1919-1919", "파리사", "미드부서");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].showInfo()); //메소드 재정의
			}
		}
	}

}
