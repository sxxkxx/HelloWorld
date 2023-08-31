/**
 * 
 */


class Reply {

	notUse() {
		fetch('AjaxReplyList.do?noticeId=' + noticeId)
			.then(resolve => resolve.json())
			.then(json => {
				console.log(json);
			})
			.catch(console.log);
	}
	// 댓글 목록
	replyList(noticeId, callback) {
		$.getJSON('AjaxReplyList.do?noticeId=' + noticeId, function(data) {
			callback(data);
		})
	}
	// 댓글 등록. 파라미터 : 게시글번호, 댓글내용, 작성자
	replyAdd(param = {noticeId, reply, replyer},callback){
		$.post('',param,function(data){
			callback(data);
		})
	}
}