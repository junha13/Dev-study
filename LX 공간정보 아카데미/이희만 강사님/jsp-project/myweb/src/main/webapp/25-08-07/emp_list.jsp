<%@page import="userIfo.Emp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="userIfo.EmpUtil"%>
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
클라이언트로부터 전송된 데이터를 추출한다.

 --%>
<%
String jobID = request.getParameter("jobId");
List<Emp> empList = new ArrayList<Emp>();
empList = EmpUtil.getEmpIfoListByJobId(jobID);
	for (Emp emp : empList) {
%>
	<%= emp.toString() %> <br>
<% 
	}
%>

</body>
</html>