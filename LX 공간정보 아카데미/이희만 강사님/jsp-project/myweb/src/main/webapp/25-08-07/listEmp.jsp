<%@page import="userIfo.EmpUtil"%>
<%@page import="userIfo.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	List<String> searchConditions = new ArrayList<String>();
	searchConditions.add("employee_id");
	searchConditions.add("first_name");
	searchConditions.add("department_id");
	String searchSelect = request.getParameter("searchSelect");
	Object searchInput = request.getParameter("searchInput");
	List<Emp> emplist = new ArrayList<Emp>();
	if (searchSelect != null && searchInput != null) {
		emplist = EmpUtil.getEmpListByEmpCondition(searchSelect, searchInput);
	} else {
		emplist = EmpUtil.getEmpList();
	}
%>
	<div>
		<h1>Employee 검색</h1>
	</div>
	<div>
		<select id="searchSelect">
<%			for (String searchCondition : searchConditions) {%>
			<option> <%=searchCondition %> </option>
<%			}%>			
		</select>
			<input id="searchInput">
			<input type="submit" id="searchButton" value="검색하기">
			<form action="listEmp.jsp">
				<input type="submit" value="전체보기">
			</form>
	</div>
	<div>
		<table cellspacing="5" border="1">
			<tbody>
				<% for (Emp emp : emplist) {%>
				<tr>
					<td><%= emp.getEmployee_id() %></td>
					<td><%= emp.getFirst_name() %></td>
					<td><%= emp.getSalary() %></td>
					<td><%= emp.getDepartment_id() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<script>
	let searchSelect = document.querySelector("#searchSelect");
	let searchInput = document.querySelector("#searchInput");
	let searchButton = document.querySelector("#searchButton");
	searchButton.addEventListener("click", listView);
	function listView() {
		let form = document.createElement("form");
		form.method = "get";
		form.action = "listEmp.jsp"
		
		let input1 = document.createElement("input");
		input1.type = "hidden";
		input1.name = "searchSelect"
		input1.value = searchSelect.value;
		form.appendChild(input1);
		
		let input2 = document.createElement("input");
		input2.type = "hidden";
		input2.name = "searchInput"
		input2.value = searchInput.value;
		form.appendChild(input2);
		
		document.body.appendChild(form);
		form.submit();
	}	
	
	</script>
</body>
</html>