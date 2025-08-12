<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.html"></jsp:include>
<body>
<h1>main.jsp</h1>

<%
	String action = request.getParameter("action");
	out.println(action + "<br/>"); // type은 JspWriter타입임
%>
<%= action %>
<p>This is [include test]</p>
<jsp:forward page="emp_list.jsp"></jsp:forward> <%--현재 페이지에 emp.jsp의 결과를 띄워주는 거임 ㄸㄸㄷ 개이득 url그대로임 ㄸ--%>
<%@ include file="footer.jsp" %>
</body>
</html>