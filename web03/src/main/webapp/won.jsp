<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><% 
    String won = request.getParameter("won");
	
	
	int won2 = Integer.parseInt(won);
	double dollar = won2 * 0.0075;
	%> <%=dollar%>