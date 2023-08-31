package co.san.example.ajaxmember.map;

import java.util.List;

import co.san.example.ajaxmember.service.MembersVO;
import co.san.example.notice.service.ReplyVO;

public interface MembersMapper {
	public int insert(MembersVO vo);
	
	public int update(MembersVO vo);

	public int delete(int replyId);
	public ReplyVO select(int replyId);
	public List<MembersVO> list();
}
