<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</body>
</html>