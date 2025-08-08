<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String action = request.getParameter("action");
	out.println(action + "<br/>"); // type은 JspWriter타입임
%>
<%= action %>

<h1>emp_list</h1>


</body>
</html>