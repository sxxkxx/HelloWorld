package co.san.example.notice.service;

import java.util.List;

public interface ReplyService {
	public boolean addReply(ReplyVO vo);

	public boolean editReply(ReplyVO vo);

	public boolean deleteReply(int replyId);

	public ReplyVO getReply(int replyId);

	public List<ReplyVO> replyList(int noticeId);

}
