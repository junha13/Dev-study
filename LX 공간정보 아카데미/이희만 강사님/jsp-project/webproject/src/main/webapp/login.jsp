<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="menu.do" method="">   <!-- login_action으로 보내서 세션에 저장해야됨  -->
			<span>id : </span><input type="text" name="id"><br>
			<span>pw : </span><input type="password" name="pw">
			<button type="submit">로그인</button>
		</form>
	</div>
	<div>
		<a href="signUp.do">회원가입</a>
	</div>
</body>
</html>