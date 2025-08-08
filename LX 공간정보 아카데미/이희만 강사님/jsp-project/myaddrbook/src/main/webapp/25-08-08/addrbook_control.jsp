<%@page import="addrbook.AddrBookVO"%>
<%@page import="java.util.List"%>
<%@page import="addrbook.AddrBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
    <jsp:useBean id="ab" class="addrbook.AddrBookVO"></jsp:useBean>
	<jsp:setProperty property="*" name="ab"></jsp:setProperty>
<%--  // 모든 property를 이름이 ab인걸로 생성됨--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 왜 다이렉트로 요청했을때 안되는지 action이 null이라서


	request.setCharacterEncoding("utf-8");
	// client의 요구(action 참조)에 다라 처리한다.
	// insert, update, delete, list
	String action = request.getParameter("action");  // 이건 이름으로 값 가져오는거
	System.out.println("action = " + action);
	String forwardPage = "addrbook_list.jsp";
	AddrBookDAO dao = new AddrBookDAO();
	if("insert".equals(action)) {
		// insert 처리 - DAO의 insertDB호출 DAO.insert();
		dao.insertDB(ab);
		response.sendRedirect("addrbook_control.jsp?action=list");
		// List<AddrBookVO> list = dao.getDBList();
		// request.setAttribute("data:, list")
		
		// 목록이 출력될 수 있도록 한다.
		// forwardPage를 설정한다.
	} else if("edit".equals(action)) {
		// 1. 클라이언트가 전송한 데이터 중에서 방명록 id를 추출한다.
		String abIdStr = request.getParameter("ab_id");
		// 2. DB에서 해당 방명록 정보를 조회한다. (해당 방명록 화면만 보여주는 거임)
		AddrBookVO vo = dao.getDB(Integer.parseInt(abIdStr));
		// 3. 방명록 정보를 리퀘스트에 넣드다. 
		
		forwardPage = "addrbook_edit_form.jsp";
		request.setAttribute("ab", vo);
		
		pageContext.forward(forwardPage);
	} else if("list".equals(action)) {
		//scope request에 data라는 이름으로 리스트를 넣어두어야 한다.
		List<AddrBookVO> list = dao.getDBList();
		request.setAttribute("data",list);
		pageContext.forward(forwardPage);
		//jsp에 꺼내서 출력한다.
	} else if ("delete".equals(action)) {
		String abIdStrr = request.getParameter("ab_id");
		System.out.println(abIdStrr);
		dao.deleteDB(Integer.parseInt(abIdStrr));
		response.sendRedirect("addrbook_control.jsp?action=list");
	} else {
		response.sendRedirect("addrbook_control.jsp?action=list");
	}
%>	
<%--<jsp:forward page="<%=forwardPage %>"></jsp:forward> --%>
</body>
</html>