<%@page import="java.util.Date"%> <!-- import -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
this is jsp! <br/> 
여기는 32번 PC입니다 오늘도 열심히 ! 의미있게 화이팅! <br/>
<%
	String user = request.getParameter("name");
	if(user==null) {
		user = "Guest";
	}
%>
Hello!~ <%= user %>
time : <%= new Date() %> <!-- 생성자 -->
<a href="http://www.naver.com">dd</a>
<form action="http://www.naver.com">
	<input type="submit">naver
</form>
</body>
</html>