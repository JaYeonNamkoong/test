<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<p>아이디 : ${dto.id}

<p>이름 :${dto.name}
</p>
<p>성별 :${dto.gender}
</p>
<p>나이 :${dto.age}
</p>
<p><input type="button" value="Home" onclick="location='main.kosmo?cmd=index'">
</p>
</body>
</html>