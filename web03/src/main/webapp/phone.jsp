<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String tel = request.getParameter("tel");
    
    String tel2 = tel.substring(0,3);
    
    String result = "";
    if(tel2.equals("010")){
    	result ="1111";
    }else if(tel2.equals("011")){
    	result = "2222";
    }else{
    	result ="3333";
    }
    
    Random r = new Random();
    int no = r.nextInt(90) + 10;
    result = result + no;
  %> <%=result%>