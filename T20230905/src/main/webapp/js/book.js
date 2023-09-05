/**
 * 
 */


class Book {




	bookList(callback) {
		$.ajax({
			url: 'AjaxBookList.do',
			success: function(data) {
				callback(data);
			}	
		})
	}

	addBook(param, callback) {


		$.ajax({
			url: 'AjaxBookinsert.do',
			data: param,
			success: function(data) {
				callback(data);
			}
		})
	}
	// 댓글 단건 조회

	editBook(param = { todoNo, complete }, callback, errorcall) {
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
	removeBook(param = { bkCode }, callback) {

		$.ajax({
			url: 'AjaxBookRemove.do',
			data: param,
			success: function(data) {
				callback(data);
			}
		})
	}


}