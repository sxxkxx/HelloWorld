package co.san.example.ajaxmember.map;

import java.util.List;

import co.san.example.ajaxmember.service.MembersVO;

public interface MembersMapper {
	public int insert(MembersVO vo);
	
	public int update(MembersVO vo);

	public int delete(int mbrId);

	public List<MembersVO> list();
}
