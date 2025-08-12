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
	List<String> jobList = EmpUtil.getJobList();  
%>
<form action="emp_list.jsp" method="get">
	<select id="jobId" name="jobId">
		<% for(String JobId :jobList) { %>
		<option value="<%=JobId%>"><%=JobId%></option>
		<%} %>
	</select>
	<input type="submit" value="해당직무직원목록조회">  

</form>
	<script type="text/javascript">
		/*
		 1. select 태그를 참조한다
		 2. select 태그의 선택이 변경되면 함수가 실행되게 한다/
		 */

		// let jobId = document.getElementById("jobId");
		let jobId = document.querySelector("#jobId"); // css선택자 - #jobId     ★★★★(# id, . class, tag이름은 그냥 씀)
		//jobId.onchange = handleJobId; // handleJobId 함수임 handleJobId()로 넣으면 새로고침할때마다 실행(alert가 뜸)됨
		jobId.addEventListner("change", handelJobId);
		function handleJobId() {
			alert(jobId.value);
		}
	
		// let = document.querySelector(input);
	</script>

</body>
</html>