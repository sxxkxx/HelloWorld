package co.san.miniprj.member.service;

import lombok.Data;

@Data
public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String memberTel;
	private String memberAddr;

	@Override
	public String toString() {
		System.out.print(memberId + " ");
		System.out.print(memberName + " ");
		if (memberPw != null) {
			System.out.print(memberPw + " ");
		}
		System.out.print(memberAge + " ");
		System.out.print(memberGender + " ");
		System.out.print(memberTel + " ");
		System.out.println(memberAddr);
		return null;
	}
}
