<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 17. / Kosmo -->
<article>

	<!-- Load c3.css -->
	<link href="../resources/css/c3.css" rel="stylesheet">

	<!-- Load d3.js and c3.js -->
	<script src="../resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
	<script src="../resources/js/c3.min.js"></script>


	<div id="chart"></div>

	<script>
		let jsondata = {
				'비가 옵니다':500,
				'안옵니다':200,
				'모릅니다':666,
				'태풍이 옵니다':54,
				'관심없음':120
		};
		console.dir(jsondata);
		//console.log(typeof(jsondata));
		//console.log(jsondata);
		
		var chart = c3.generate({
			bindto : '#chart',
			data : {
				/*
				 columns: [
				 ['비가 옵니다', 500],
				 ['안옵니다', 200],
				 ['모릅니다', 666],
				 ['태풍이 옵니다', 54],
				 ['관심없음', 120]
				 ],
				 */
				json : [jsondata],
				keys: { // x: 'name', // it's possible to specify 'x' when category axis
			        value: Object.keys(jsondata),
			    },
				type : 'donut',
				onclick : function(d, i) {
					console.log("onclick", d, i);
				},
				onmouseover : function(d, i) {
					console.log("onmouseover", d, i);
				},
				onmouseout : function(d, i) {
					console.log("onmouseout", d, i);
				}
			},
			donut : {
				title : "날씨 설문조사 내용"
			}
		});
	</script>

</article>