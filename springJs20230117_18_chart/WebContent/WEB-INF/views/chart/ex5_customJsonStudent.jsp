<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 2023. 1. 17. / Kosmo -->
<article>
<head>
<meta charset="EUC-KR">
<title></title>

<!-- Load c3.css -->
<link href="../resources/css/c3.css" rel="stylesheet">

<!-- Load d3.js and c3.js -->
<script src="../resources/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="../resources/js/c3.min.js"></script>

<style></style>

</head>
<body>

<div id="chart"></div>

<script>
//서버측 json을 파싱한 가상데이터
const student = [];
student.push({name: '구름', kor: 87, eng: 98, math: 88, scien: 90});
student.push({name: '별이', kor: 92, eng: 98, math: 96, scien: 88});
student.push({name: '겨울', kor: 76, eng: 96, math: 94, scien: 86});
student.push({name: '바다', kor: 98, eng: 52, math: 98, scien: 92});
console.log(student);

//bar차트 제작
// => 데이터에서 사용자의 이름을 X축:category ***(axis.x.categories)
var chart = c3.generate({
	bindto : '#chart',
	//data.json
	data : {
	    json:student,
	    keys: {
	        // x: 'name', // it's possible to specify 'x' when category axis
	        value: ['kor', 'eng', 'math', 'scien']
	    },
	    type: "bar"
	},
	axis : {
        x: {
            type: 'category',
            categories: [student[0].name, student[1].name, student[2].name, student[3].name]
        }		
	}
	
});
    

</script>

</body>
</article>