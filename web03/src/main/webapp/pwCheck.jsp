<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String pw = request.getParameter("pw");
    String pw2 = request.getParameter("pw2");
    String result = "비밀번호가 다릅니다";
    
    if(pw.equals(pw2)){
    	result = "비밀번호가 일치합니다";
    }
  
    %><%=result%>