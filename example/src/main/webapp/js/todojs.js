/**
 * 
 */


class Todo {



	// 댓글 목록
	todoList(callback) {
		$.ajax({
			url: 'AjaxTodoList.do',
			success: function(data) {
				callback(data);
			}
		})
	}
	// 댓글 등록. 파라미터 : 게시글번호, 댓글내용, 작성자
	addTodo(param, callback) {
		//$.post('AjaxReplyAdd.do', param, function(data) {
		//	callback(data);
		//})

		$.ajax({
			url: 'AjaxTodoinsert.do',
			data: param,
			success: function(data) {
				callback(data);
			}
		})
	}
	// 댓글 단건 조회
	
	todoEdit(param = { todoNo, complete }, callback, errorcall) {
		//$.getJSON('AjaxReplySearch.do?rno=' + replyId, function(data) {
		//	callback(data);
		//})
		$.ajax({
			url: 'AjaxTodoEdit.do',
			data: param,
			success: function(data) {
				callback(data);
			},
			error: function(err) {
				errorcall(err)
			}
		})
	}
	todoRemove(param ={todoNo}, callback) {
		//$.getJSON('AjaxReplySearch.do?rno=' + replyId, function(data) {
		//	callback(data);
		//})
		$.ajax({
			url: 'AjaxTodoRemove.do',
			data: param,
			success: function(data) {
				callback(data);
			}
		})
	}
	// 문자열 -> 날짜 포맷으로 변경.
	displayDateTime(dateStr) {
		var mils = Date.parse(dateStr);
		var today = new Date(mils);
		var yyyy = today.getFullYear();
		var mm = "0" + (today.getMonth() + 1);
		var dd = "0" + today.getDate();
		var hh = "0" + today.getHours();
		var mi = "0" + today.getMinutes();
		var ss = "0" + today.getSeconds();

		return yyyy + "-" + mm.slice(-2) + "-" + dd.slice(-2) + " " + hh.slice(-2) + ":" + mi.slice(-2) + ":" + ss.slice(-2);

	}


}