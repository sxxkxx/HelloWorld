<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>

<title>Page Title</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>


</head>

<body>
	<select name="sidos" id="centerList">
	</select>
	<button type="button" name="delBtn">선택삭제</button>
	<h3>센터목록</h3>
	<table border="1">
		<thead>
			<tr>
				<th>시도ID</th>
				<th>센터명</th>
				<th>연락처</th>
				<th>주소</th>
				<th><input type="checkbox" id="allChk"></th>
			</tr>
		</thead>
		<tbody id="list">

		</tbody>

	</table>
	<div id="map" style="width: 100%; height: 350px;"></div>
	<p>
		<em>지도를 클릭해주세요!</em>
	</p>
	<div id="clickLatlng"></div>


	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f3fe15ee742e9ad357cf621bee55dd7e"></script>
	<script>
	
		$(function map(){
		let lat = '${param.lat }';
		let lng = '${param.lng }';
		let centerName;
									
			console.log(centerName);
	
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center : new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
				level : 3
			// 지도의 확대 레벨
			};
	
			var map = new kakao.maps.Map(mapContainer, mapOption);
	
			// 마커가 표시될 위치입니다 
			var markerPosition = new kakao.maps.LatLng(lat, lng);
	
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				position : markerPosition
			});
	
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
	
			var iwContent = '<div style="padding:5px" id="iwdiv">${param.centerName }<br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			
			iwPosition = new kakao.maps.LatLng(lat, lng); //인포윈도우 표시 위치입니다
			
	
			// 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({
				position : iwPosition,
				content : iwContent
			});
	
			// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
			infowindow.open(map, marker);
		});
	</script>
	<script>
		$("#allChk").click(function () {
			if ($("#allChk").is(":checked")) {
				$("input[name=checkbox]").prop("checked", true);
			} else {
				$("input[name=checkbox]").prop("checked", false);
			}
		});

		$("input[name=checkbox]").click(function () {
			var totalArr = $("input[name=checkbox]").length;
			var checked = $("input[name=checkbox]:checked").length;

			if (totalArr != ckecked) {
				$("#allChk").prop("checked", false);
			} else {
				$("#allChk").prop("checked", true);
			}
		});

		let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=f%2B1BG0nR1vPCT3SKespY22FAWxgKapsV6T6ZsRYoJQVvnv9kgCW1cUVOUYV%2FbkX%2FA4FfFhtJRXBSBMtq%2FrrBug%3D%3D`;
		let totalData = [];
		fetch(url)
			.then(resolve => resolve.json())
			.then(centerInit)
			.catch(console.log);

		function centerInit(json) {
			console.log(json.data); // data:284건
			let aryData = json.data;
			totalData = json.data;
			let sidos = [];
			aryData.forEach(function (elem, idx) {
				if (sidos.indexOf(elem.sido) == -1) {
					sidos.push(elem.sido);
				}
			})
			sidos.forEach(sido => {
				let opt = document.createElement('option');
				opt.innerText = sido;
				document.querySelector('select[name=sidos]').appendChild(opt);
			})

			// 조건 검색. 
			aryData.forEach((center, idx) => {
				if (idx < 5) {
					document.querySelector('#list').appendChild(makecenterInfo(center));
				}
			})
		}

		function makecenterInfo(center = {}) {
			const fields = ['id', 'centerName', 'phoneNumber', 'address'];
			const tr = document.createElement('tr');
			fields.forEach(field => {
				const td = document.createElement('td');
				if (field == 'id') {
					let ref = document.createElement('a');
					ref.setAttribute('href', '#')
					ref.setAttribute('onclick', 'map.jsp?lat=' + center.lat + '&lng=' + center.lng + '&centerName=' + center.centerName.substr(5))
					console.log(center.centerName.substr(5));
					ref.innerText = center[field];
					td.appendChild(ref);
				} else {
					td.innerText = center[field];
				}
				tr.appendChild(td);
			})
			// checkbox.
			const td = document.createElement('td');
			const chk = document.createElement('input');
			chk.setAttribute('type', 'checkbox');
			chk.setAttribute('name', 'checkbox');
			td.appendChild(chk);
			tr.appendChild(td);

			return tr;
		}

		// 시도리스트에 선택 이벤트.
		document.querySelector('select[name=sidos]').addEventListener('change', centerList);

		function centerList(e) {
			let searchSido = e.target.value;
			// filter : 반환값이 true인 항목을 새로운 배열에 저장.
			const filterAry = totalData.filter(center => center.sido == searchSido)
			document.querySelector('#list').innerHTML = ''; // 기존테이블 제거.
			filterAry.forEach((center, idx) => {
				console.log(center.lat + ' ' + center.lng)
				document.querySelector('#list').appendChild(makecenterInfo(center));
			})

		}
		// 선택 삭제 이벤트.
		/*document.querySelector('button[name=delBtn]').addEventListener('click',delSelectredTr);
		function delSelectredTr(){
			document.querySelectorAll('#list tr input:checked').forEach(input =>{
				input.parentElement.parentElement.remove();
			})
		}*/

		$("[name='delBtn']").on('click', function () {
			$('td>input:checkbox').each(function (index) {
				if ($(this).is(":checked")) {
					$(this).parent().parent().remove();
				}
			})
		})
	</script>
</body>

</html>