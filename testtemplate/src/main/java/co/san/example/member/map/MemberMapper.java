package co.san.example.member.map;

import java.util.HashMap;
import java.util.List;

import co.san.example.member.service.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	List<HashMap<String, Object>> memberJoinSelect();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}