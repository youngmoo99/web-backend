<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><% 
    String dollar = request.getParameter("dollar");
	
	int dollar2 = Integer.parseInt(dollar);
	double won = dollar2 * 1324.95;
	 
	%> <%=won %>
