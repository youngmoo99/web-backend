<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String id = request.getParameter("id");
    String[] list = {"hong", "root", "admin"};
    String result = "가입 가능한 아이디 입니다.";
    
    for(String s:list ){
    	if(s.equals(id)){
    		result ="이미 사용중 입니다.";
    	}
    }
    %><%=result%>