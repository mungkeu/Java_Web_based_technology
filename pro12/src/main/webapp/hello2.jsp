<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 주석문
	/*주석문*/
	String name = "user";
	public String getName(){ return name; }
%>
<% String age=request.getParameter("age"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 연습</title>
</head>
<body>
	<!-- HTML 주석문 -->
	<%-- 
		JSP 페이지에 대한 주석문
		<%=Integer.parseInt(age)+10 %>살입니다.</h1> 
	--%>
</html>