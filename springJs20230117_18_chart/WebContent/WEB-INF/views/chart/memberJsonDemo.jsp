<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 17. / Kosmo -->
<article>
	<header>
		<h1>회원찾기</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>

	<div id="container">
		<div id="row">
			<button id="listBtn">Click</button>
			<div class="row justify-content-center">
				<table class="table">
					<thead>
						<tr>
							<td>num</td>
							<td>ID</td>
							<td>Name</td>
							<td>Age</td>
							<td>Gender</td>
						</tr>
					</thead>
					<tbody id="target">

					</tbody>

				</table>
			</div>
		</div>
	</div>
</article>

<script>
	//회원 전체를 출력하는 
	//JQuery 시작
	$(function() {
		//alert("Test");
		$('#listBtn').click(
				function() {
					$.ajaxSetup({ //ajax 캐시 삭제
						cache : false
					});
					$.ajax({
						url : "../memberlistView",
						success : function(jsonData) {
							$('#target').html(""); //비우기
							console.log(jsonData);
							//[{…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}]
							//배열형태로 나옴
							//
							
							$.each(jsonData, function(member,v) {
								//배열안에 {…} 객체하나
								console.log(member);
								console.log(v);
								
								let tags = "<tr>"; //멤버하나 당 <tr~/tr>
								$.each(v, function(key, val) {
									//{}객체안에 데이터 => num : 20
									console.log(key + " : " + val);
									
									//null값 제외
									if(val !== null)
									tags += "<td>" + val + "</td>";
								});
								tags += "</tr>";
								$('#target').append(tags);
							});
								
						}
					});
				});
	});
</script>
