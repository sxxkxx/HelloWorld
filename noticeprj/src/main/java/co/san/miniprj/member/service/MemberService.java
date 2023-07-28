package co.san.miniprj.member.service;

import java.util.List;

public interface MemberService { // CRUD.
	List<MemberVO> memberSelectList(); // 멤버 전체 조회.
	MemberVO memberSelect(MemberVO vo); // 멤버 한명 조회.
	int memberInsert(MemberVO vo); // 멤버 등록.
	int memberDelete(MemberVO vo); // 멤버 등록.
	int memberUpdate(MemberVO vo); // 멤버 등록.
	
}
