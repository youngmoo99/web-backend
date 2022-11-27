<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String[] id_list = {"100","101","102"};
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(String s: id_list){// s="100", s="101",s="102"
%>
<a href ="http://localhost:9999/web01/product_one.jsp?id=<%= s%>"><%=s %>인 사람의 정보</a>
	<% 
	}
	%>		
	



</body>
</html>