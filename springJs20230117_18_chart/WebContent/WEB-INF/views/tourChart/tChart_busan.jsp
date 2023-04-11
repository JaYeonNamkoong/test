<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 17. / Kosmo -->
<article>

	<!-- Load c3.css -->
	<link href="../resources/css/c3.css" rel="stylesheet">

	<!-- Load d3.js and c3.js -->
	<script src="../resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
	<script src="../resources/js/c3.min.js"></script>


	<header>
		<h1>연령대 별 여행지(부산) 선호도</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
	<div id="chart"></div>

	</div>

</article>

<script>
$.ajaxSetup({
	cache : false
});
$.ajax({
	url : "../tourChartJson?num=22",
	success : function(jsondata){
		$('#chart').html(""); //비우기
		console.log(jsondata);
		//====================================
		var chart = c3.generate({
			bindto : '#chart',
			data : {
				json : [jsondata[1]], //1번지
				keys : {
					value : Object.keys(jsondata[1]),
				},
				type : 'donut'
			},
			donut : {
				title : jsondata[0].sub, //0번지
			},
		});
		//====================================
	},
	error : function(e) {
		console.log("error:" + e);
	}	
});


</script>
