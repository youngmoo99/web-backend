<%@page import="db_connect.MemberVO"%>
<%@page import="db_connect.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1.데이터를 받아서, 2.sql문을 만들어서, 3.결과를 html로 만들어야 하는 페이지  -->
    <!--java코드 처리 부분 + html로 만들어진 부분(jsp)  -->
    <!--1. 데이터를 받자  -->
    <%
    //자바코드를 일부 넣는 부분, 작은 프로그램의 일부분(let,릿) 
    // 자바코드를 그냥 스크립트쓰듯이 쓰면 됨. 
    //스크립트릿(scriptlet)
    //HttpRequestServlet request = new HttpRequestServlet(); 내장된 객체
    // 미리 reqeust라는 이름의 객체를 만들어서 제공
    
  	String id = request.getParameter("id"); // <input name ="id">, 외부에서 입력한 데이터타입(String)
  	String pw = request.getParameter("pw");
  	String name = request.getParameter("name");
  	String tel = request.getParameter("tel");
  	
  	
  	MemberVO bag = new MemberVO();
  	bag.setId(id);
  	bag.setPw(pw);
  	bag.setName(name);
  	bag.setTel(tel);
  	
  	MemberDAO dao = new MemberDAO();
  	dao.insert(bag);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background: orange;
}
</style>
</head>
<body>
회원가입이 잘 되었습니다.<hr>
회원가입 정보<hr>
아이디 : <%= id%> <br> <!-- 램에 있는 값 브라우저에 표현해줘. 표현식 -->
비밀번호 : <%= pw%> <br>
이름 : <%= name%> <br>
전화번호 : <%= tel%> <br>
</body>
</html>