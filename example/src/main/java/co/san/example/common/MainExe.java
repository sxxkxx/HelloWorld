package co.san.example.common;

import co.san.example.notice.service.ReplyService;
import co.san.example.notice.service.ReplyVO;
import co.san.example.notice.serviceImpl.ReplyServiceImpl;

public class MainExe {
	public static void main(String[] args) {
		ReplyService service = new ReplyServiceImpl();

		ReplyVO reply = new ReplyVO();
		reply.setNoticeId(7);
		reply.setReply("매퍼테스트");
		reply.setReplyer("son");
		reply.setReplyId(31);

		reply = service.getReply(1);
		System.out.println(reply);
		
		service.replyList(7).forEach((vo) -> {
			System.out.println(vo);
		});

	}
}
