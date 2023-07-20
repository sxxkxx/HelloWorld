package co.yedam.api;

public class Member {
	int memNo;
	String memName;

	public Member(int memNo, String memName) {
		this.memNo = memNo;
		this.memName = memName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member m2 = (Member) obj;
//			return this.memNo == m2.memNo && this.memName.equals(m2.memName);
			return this.memName.equals(m2.memName);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memName=" + memName + "]";
	}

	@Override
	public int hashCode() {
//		return this.memNo;
		return this.memName.hashCode();
	}

}
