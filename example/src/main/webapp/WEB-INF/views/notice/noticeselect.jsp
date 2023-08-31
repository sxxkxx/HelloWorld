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
	<div class="reply">
		<h3>댓글 목록</h3>
		<div>
			<div class="col-lg-6">
				<div class="card mb-4" style="display: none">
					<div class="card-header py-3">
						<div class="cheader">
							<span class="replyId">12</span> <span class="replyer">작성자</span>
							<span class="replyDate">12</span>
						</div>
					</div>
					<div class="card-body">내용</div>
				</div>
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
				let temp = $('div.card.mb-4').eq(0).clone();
				temp.css('display', 'block');

				temp.find('span.replyId').text(data[i].replyId);
				temp.find('span.replyer').text(data[i].replyer);
				temp.find('span.replyDate').text(data[i].replyDate);
				temp.find('div.card-body').text(data[i].reply);
				$('div.col-lg-6').append(temp);
			}

		})
	</script>
</body>
</html>