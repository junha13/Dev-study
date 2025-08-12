<%@page import="java.util.List"%>
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
<%
	// job_id_list를 출력한다.
	// 하지만 job_id는 DB에 있고 이를 가져오려면 DB연결이 필요함  (그리고 그런 DB연결은 별도의 클래스로 분리되는게 매우매우 적절하다)
	
	List<String> jobList = EmpUtil.getJobList();  
	// Job_ID List를 가져오는 메서드 (목록 리턴, 리턴타입은 무엇일까 (String 타입의 리스트로 받아오고), 매개변수는 무엇일까(딱히 없어도 됨 사용자가 원하는 걸 보면 되니까))
	
	for(String jobId : jobList) {	
%>		
	<a href="emp_list.jsp?jobId=<%=jobId%>"><%=jobId%></a><br/>
	
<%
	}

%>

job list size : <%= jobList.size() %>


<form action="emp_list.jsp" method="get">
	<select name="jobId">
		<% for(String JobId :jobList) { %>
		<option value="<%=JobId%>"><%=JobId%></option>
		<%} %>
	</select>
	<input type="submit" value="부서원보기">  
	<!-- 사용자 관점에서는 jobId를 선택했을 때 js를 코딩하느것이 더 적절하다. -->
	<!-- EventHandler (select가 변경됐을때)  -->
</form>

</body>
</html>