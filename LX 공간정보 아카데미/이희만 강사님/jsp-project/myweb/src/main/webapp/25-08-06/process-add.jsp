
<%@page import="userIfo.UserIO"%>
<%@page import="userIfo.User"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
	클라이언트가 전송한 데이터를 추출한다.
	파일에 저장한다.
	저장되었음을 알린다.
 --%>
 <%
 	String firstName = request.getParameter("firstName");
 	/*
 	PrintWriter record = new PrintWriter(new FileWriter("c:/lx/jsp-project/myjsp/list.txt", true));
 	record.println(firstName);
 	record.close();
 	*/
 	String lastName = request.getParameter("lastName");
 	String email = request.getParameter("email");
 	User user = new User(firstName, lastName, email);
 	UserIO userIO = new UserIO();
 	userIO.addUser(user, "c:/lx/jsp-project/myweb/list.txt");
 %>
사용자정보를 저장하였습니다.

</body>
</html>