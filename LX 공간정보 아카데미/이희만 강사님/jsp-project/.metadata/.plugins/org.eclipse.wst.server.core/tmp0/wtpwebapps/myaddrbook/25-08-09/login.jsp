<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login</h1>
<form action="login_action.jsp" method="get">
	id : <input name="id"><br>
	pw : <input name="pw"><br>
	<input type="submit" value="로그인">
	
	
	<!-- 사용자가 이전에 했던 정보들을 세션이 저장해두는거임 -->
</form>
</body>
</html>