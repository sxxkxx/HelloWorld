package co.san.example.member.service;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();
	List<HashMap<String, Object>> memberJoinSelect();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
