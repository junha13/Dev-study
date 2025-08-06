<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
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
	Map<String, String> menuList = new HashMap<String, String>();
	menuList.put("Jajangmyeon", "짜장면");
	menuList.put("Jjamppong", "짬뽕");
	menuList.put("KkanpungShrimp", "탕수육");
%>
<% 
	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("Name");
	String userEmail = request.getParameter("emailAdress");
	String[] hobbyList = request.getParameterValues("hobby");
	String menu = request. getParameter("lunchMenu");
	String lunch = "";

%>
당신의 이름은 <%=userName%> 이군요~! <br>
이메일은 <%=userEmail %> 이군요~! <br>
취미로는 
<% 
	if (hobbyList != null) {
		for(String hobby : hobbyList) {
			System.out.println(hobby);
			if (hobbyList.length > 1) {
				out.print(hobby + ", "); 
			} else {
				out.print(hobby); 
			} 
		}
		out.print("이군요 ~! <br>"); 
	}
%>
점심으로는 
<%
	if (menuList.containsKey(menu)) {
	lunch = menuList.get(menu);
	out.print(lunch);
	}
%>
을 드시려 하는군요~! <br>

<%  // 모든 정보 다 빼는거같은데

	Enumeration paramList = request.getParameterNames();
	while(paramList.hasMoreElements()) {
		String param = (String) paramList.nextElement();
		String value = request.getParameter(param);
		out.print(param + "=" + value + "<br/>");
	}
%>
</p>

</body>
</html>

