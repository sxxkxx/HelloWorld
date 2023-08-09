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
			<h1>게시글 목록</h1>
		</div>

		<div>
			<form id="searchfrm">
				<select id="key" name="key">
					<option value="title">제목</option>
					<option value="subject">내용</option>
					<option value="writer">작성자</option>
				</select>&nbsp;&nbsp; <input type="text" id="val" name="val">
				<button type="button" onclick="searchList()">검색</button>
			</form>
		</div>
		<br>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="70">글번호</th>
						<th width="300">제목</th>
						<th width="100">작성자</th>
						<th width="100">작성일</th>
						<th width="300">첨부파일</th>
						<th width="70">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty notices}">
						<c:forEach items="${notices}" var="n">
							<tr onmouseover="this.style.background='#fcecae'"
								onmouseout="this.style.background='#FFFFFF'"
								onclick="selectNotice(${n.noticeId})">
								<td align="center">${n.noticeId}</td>
								<td align="center">${n.noticeTitle}</td>
								<td align="center">${n.noticeWriter}</td>
								<td align="center">${n.noticeDate}</td>
								<td align="center">${n.noticeAttech}</td>
								<td align="center">${n.noticeHit}</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="">
						<tr>
							<td colspan="6">데이터가 존재하지 않습니다.</td>
						</tr>
					</c:if>
				</tbody>


			</table>
		</div>
		<br>
		<div>
			<c:if test="${not empty id}">
				<button type="button" onclick="location.href='noticeform.do'">글작성</button>
			</c:if>
		</div>
	</div>
	<div>
		<form id="form" action="noticeselect.do" method="get">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</div>
	<script type="text/javascript">
	function selectNotice(n) {
		document.getElementById("noticeId").value = n;
		document.getElementById("form").submit();
	}
	
	function searchList() {
		// ajax를 이용해서 검색결과를 화면에 출력
		let key = document.getElementById("key").value;
		let val = document.getElementById("val").value;
		let payload = "key=" + key + "&val="+val;
		let url = "ajaxnoticesearch.do";
		
		fetch(url, {
			method:"POST",
			headers:{"content-Type": "application/x-www-form-urlencoded",},
			body: payload
		}).then(response => response.json())
		  .then(json => htmlConvert(json));
	}
	
	function htmlConvert(datas) {
		document.querySelector('tbody').remove();
		const tbody = document.createElement('tbody');
		// tbody에 data 추가
		tbody.innerHTML = datas.map(data => htmlView(data)).join('');
		
		// table tbody 추가
		document.querySelector('table').appendChild(tbody);
	}
	
	function htmlView(data) {
		return `
				<tr onmouseover="this.style.background='#fcecae'"
					onmouseout="this.style.background='#FFFFFF'"
					onclick="selectNotice(\${data.noticeId})">
			
					<td align="center">\${data.noticeId}</td>
					<td>\${data.noticeTitle}</td>
					<td align="center">\${data.noticeWriter}</td>
					<td align="center">\${data.noticeDate}</td>
					<td>\${data.noticeAttech}</td>
					<td align="center">\${data.noticeHit}</td>
				</tr>
		`
		
	}
	</script>

</body>
</html>