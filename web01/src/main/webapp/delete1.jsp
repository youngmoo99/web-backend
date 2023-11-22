
<%@page import="db_connect.gasifanDAO"%>
<%@page import="db_connect.GasifanVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1.데이터를 받아서, 2.sql문을 만들어서, 3.결과를 html로 만들어야 하는 페이지  -->
    <!--java코드 처리 부분 + html로 만들어진 부분(jsp)  -->
    <!--1. 데이터를 받자  -->
    <%
    //자바코드를 일부 넣는 부분, 작은 프로그램의 일부분(let,릿) 
    // 자바코드를 그냥 스크립트쓰듯이 쓰면 됨. 
    // 스크립트릿(scriptlet)
    //HttpRequestServlet request = new HttpRequestServlet(); 내장된 객체
    //  미리 reqeust라는 이름의 객체를 만들어서 제공
    
  String id = request.getParameter("id3"); // <input name ="id">, 외부에서 입력한 데이터타입(String)
  gasifanDAO dao = new gasifanDAO();
  dao.delete(id);
  	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
hr{
background: blue;
height : 5px;
}

body{
background: orange;
}
</style>
</head>
<body>
<h1><%= id%>의 게시판 삭제가 완료되었습니다</h1>
<hr>
<a href="bbs.html">앞페이지로 가기</a>
</body>
</html>
