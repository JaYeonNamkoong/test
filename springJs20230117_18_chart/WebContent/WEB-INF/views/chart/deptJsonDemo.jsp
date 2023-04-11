<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 17. / Kosmo -->
<article>
	<header>
		<h1>deptJsonDemo.jsp</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>

	<div id="container">
		<div id="row">
			<input type="text" id="id" name="id">

			<hr>
			<button id="jsonAjaxTest">Click</button>
			<div id="target" class="row justify-content-center">Target!</div>
		</div>
	</div>


</article>

<script>
	//JQuery 시작
	$(function() {
		//alert("Test");
		$('#jsonAjaxTest').click(
				function() {
					//alert("Test");
					alert("Test" + $('#id').val());

					$.ajaxSetup({ //ajax 캐시 삭제
						cache : false
					});
					$.ajax({
						//url : "../deptJsonView1",
						url : "../deptJsonView1?id="+$('#id').val(),
						success : function(jsonData) {
							$('#target').html(""); //비우기
							console.log(jsonData);
							console.log(Object.keys(jsonData));
							console.log(typeof (jsonData));
							//json데이터를 JQuery반복자를 사용해서 출력하기
							//JQuery.each(collection,callback)
							$.each(jsonData, function(k, v) {
								console.log(k + " : " + v);
								//append : +=과 같음
								$('#target').append(
										"<p>" + k + " : " + v + "</p>");
							});
							//target>p : target의 자식인 p태그 선택
							//.css(name, value) : css를 동적으로 적용
							$('#target>p').css("background", "orange").css(
									"text-align", "center").css("color",
									"#ffffff")
						}
					});
				});
	});
</script>
