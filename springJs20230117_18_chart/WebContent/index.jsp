<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>index</h1>

<script>
	//함수만들기 미리보기
	function deviceCheck() {
		//userAgent : mozilla/5.0 (windows nt 10.0; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/108.0.0.0 safari/537.36
		//userAgent : mozilla/5.0 (linux; android 8.0.0; sm-g955u build/r16nw) applewebkit/537.36 (khtml, like gecko) chrome/87.0.4280.141 mobile safari/537.36
		//userAgent : mozilla/5.0 (iphone; cpu iphone os 13_2_3 like mac os x) applewebkit/605.1.15 (khtml, like gecko) version/13.0.3 mobile/15e148 safari/604.1
		var userAgent = navigator.userAgent.toLowerCase(); //대소문자 변환
		//alert(userAgent);
		//console.log("userAgent : "+userAgent);

		//indexOf() => 찾지못하면 -1
		console.log("indexOf() => "+userAgent.indexOf('android'));
		if(userAgent.indexOf('android') > -1 || userAgent.indexOf('iphone') > -1){
			console.log("mobile");
			location="mobile/";
		}else{
			console.log("PC");
			location="web/";
		}
	}
	deviceCheck(); //메서드 호출
	
	
</script>

</body>
</html>

