package co.yedam.friend;
// 친구의 연락처 관리 app

//일반 정보 : 이름, 연락처.
// 회사 정보 : (회사, 부서), 학교 정보 : (학교, 전공)
//System.out.println() : 콘솔출력 x

public class AddressApp {
	int cntNum = 0;

	Friend[] friends = new Friend[10]; // 저장공간.

	// 추가. addFriend()
	public boolean addFriend(Friend friend) {
		for (int i = 0; i < friends.length; i++) {
			if (i > friends.length) {
				return false;
			}
		}
		friends[cntNum++] = friend;
		return true;
	}

	// 조회. findFriend() : 친구이름 중복x
	public Friend findFriend(String name) {
		for (int i = 0; i < 1; i++) {
			if (friends[i].getName().equals(name)) {
				return friends[i];
			}
		}
		return null;
	}

	// 수정. editFriend() : 연락처 수정.
	public boolean editFriend(String name, String phone) {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);
				return false;
			}
		}
		return true;
	}

	// 삭제. delFriend() : 삭제
	public boolean delFriend(String name) {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				friends[i] = null;
				return false;
			}
		}
		return true;
	}

	// 목록 friendList(): 친구목록
	public Friend[] friendList() {
		return friends;
	}

}
