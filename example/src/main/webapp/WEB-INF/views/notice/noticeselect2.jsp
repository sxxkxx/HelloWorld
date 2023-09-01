<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="sb/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->

<link href="sb/css/sb-admin-2.min.css" rel="stylesheet">
<link href="sb/css/bootstrap.min.css" rel="stylesheet">
<style>
.chader {
	display: flex;
	width: 200px;
}
</style>
</head>
<body>
	<div align="center">
		<div>
			<table border="1">
				<tr>
					<th width="80">작성자</th>
					<td align="center" width="100">${n.noticeWriter}</td>
					<th width="80">작성일자</th>
					<td align="center" width="150">${n.noticeDate}</td>
					<th width="70">조회수</th>
					<td align="center" width="70">${n.noticeHit}</td>

				</tr>
				<tr>

					<th>제목</th>
					<td colspan="5">${n.noticeTitle}</td>
				</tr>
				<tr height="200">
					<th>내용</th>
					<td colspan="5">${n.noticeSubject}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="5">${n.noticeAttech}</td>
				</tr>

			</table>
			<br>
			<div>
				<c:if test="${name eq n.noticeWriter}">
					<button type="button" onclick="noticeUpdate('E')">수정</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="noticeUpdate('D')">삭제</button>
					&nbsp;&nbsp;&nbsp;
			</c:if>
				<button type="button" onclick="location.href='noticelist.do'">목록</button>
			</div>
		</div>
	</div>
	<div>
		<form id="frm" method="post">
			<input type="hidden" id="noticeId" name="noticeId"
				value="${n.noticeId}">
		</form>
	</div>
	<!-- 댓글부분. -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i>Reply
					<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New
						Reply</button>
				</div>
				<div class="panel-body">
					<ul class="chat">
						<li class="left clearfix" data-rno="12" style="display: none;">
							<div>
								<div class="header">
									<strong class="primary-font">user00</strong> <small
										class="pull-right text-muted">2023-03-05 13:13</small>
								</div>
								<p>Good job!</p>
							</div>
						</li>
					</ul>
				</div>
				<div class="panel-footer"></div>
			</div>
		</div>
	</div>
	<!-- end -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Reply Modal</h4>
				</div>
				<div class="modal-body">
					<div class='form-group'>
						<label>Reply</label> <input class='form-control' name='reply'
							placeholder='New Reply!!!!'>
					</div>
					<div class='form-group'>
						<label>Replyer</label> <input class='form-control' name='replyer'
							 placeholder='Replyer'>
					</div>
					<div class='form-group' style="display: none;">
						<label>Reply Date</label> <input class='form-control'
							name='replyDate' value='replyDate'>
					</div>
				</div>
				<div class="modal-footer">
					<button id='modalModBtn' type="button" class="btn btn-warning"
						data-dismiss="modal">Modify</button>
					<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
					<button id='modalRegisterBtn' type="button" class="btn btn-default">Register</button>
					<button id='modalCloseBtn' type="button" data-dismiss="modal"
						class="btn btn-default">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function noticeUpdate(str) {
			if (str == 'E') {
				document.getElementById("frm").action = "noticeeditform.do";
			} else {
				document.getElementById("frm").action = "noticedelete.do";
			}

			document.getElementById("frm").submit();
		}
	</script>
	<script src="js/replyjs.js"></script>
	<script type="text/javascript">
		var noticeId = '<c:out value= "${n.noticeId}"/>';
		console.log('notice:', noticeId);

		var reply = new Reply();
		reply.replyList(noticeId, function(data) {
			console.log(data)

			for (let i = 0; i < data.length; i++) {
				let temp = $('.chat>li').eq(0).clone();
				temp.css('display', 'block');

				temp.attr('data-rno', data[i].replyId);
				temp.find('strong').text(data[i].replyer);
				temp.find('small').text(
						reply.displayDateTime(data[i].replyDate));
				temp.find('p').text(data[i].reply);
				
				$('.chat').append(temp);
			}

		})
		// 댓글 등록 화면
						
		$('#addReplyBtn').on('click',function(){
			//수정, 삭제 버튼
			$('input[name=reply]').val(null);
			$('input[name=replyer]').val(null);
			$('#modalRegisterBtn').show();
			$('#modalModBtn').hide();
			$('#modalRemoveBtn').hide();
			$('.modal').modal('show');
		})
		
		// 댓글 등록 처리.
		$('#modalRegisterBtn').on('click',function(){
			var content = $('input[name=reply]').val();
			var replyer = $('input[name=replyer]').val();
			var param = {noticeId, reply:content, replyer}
			
			reply.replyAdd(param, function(data){
				console.log(data);
				
				let temp = $('.chat > li').eq(0).clone();
				temp.css('display', 'block');
	
				temp.attr('data-rno', data.data.replyId);
				temp.find('strong').text(data.data.replyer);
				temp.find('small').text(
						reply.displayDateTime(data.data.replyDate));
				temp.find('p').text(data.data.reply);
				$('.chat').prepend(temp);
				$('.modal').modal('hide');
			});
		});
		
		// 수정, 삭제 화면.
		$('.chat').on('click','li',function(){
			$('#modalModBtn').show();
			$('#modalRemoveBtn').show();
			$('#modalRegisterBtn').hide();
			$('.modal').modal('show');
			
			var rno = $(this).attr('data-rno');
			rno = $(this).data('rno');
			var el = $(this);
			//data-rno = 1
			reply.replySearch(rno, function(data){
				console.log(data);
			$('input[name=reply]').val(data.reply);
			$('input[name=replyer]').val(data.replyer);
			
			})
			$('#modalModBtn').on('click',function(){
				var replyId = rno;
				var content = $('input[name=reply]').val();
				var replyer = $('input[name=replyer]').val();
				var param = {replyId, reply:content, replyer};
				
				
				
				reply.replyEdit(param, function(data){
					
				el.find('strong').text(data.data.replyer);
				el.find('p').text(data.data.reply);
				$('.modal').modal('hide');
				})
			})
			$('#modalRemoveBtn').on('click',function(){
				var replyId = rno;
				var param = {replyId};
				reply.replyRemove(param, function(data){
					console.log(data);
				el.remove();
				$('.modal').modal('hide');
				})
			})
		})
		
		
	</script>
</body>
</html>