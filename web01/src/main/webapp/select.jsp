
<%@page import="db_connect.gasifanDAO"%>
<%@page import="db_connect.GasifanVO"%>
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
    
  	String id = request.getParameter("id2"); // <input name ="id">, 외부에서 입력한 데이터타입(String)
  	
  	MemberDAO dao = new MemberDAO();
    MemberVO bag = dao.one(id);
  
	
	String pw = bag.getPw();
	String name = bag.getName();
	String tel = bag.getTel();
	
 
    %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
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
<h1>검색 결과창</h1>
<hr>
<div class="container">
  <h2><%=id %>아이디의 조회 결과</h2>
           
  <table class="table table-dark">
    <thead>
      <tr>
        <th>항목</th>
        <th>값</th>
        
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>id</td>
        <td><%=id %></td>
      </tr>
      <tr>
        <td>제목</td>
        <td><%=pw %></td>
      </tr>
      <tr>
        <td>내용</td>
        <td><%=name %></td>
      
      </tr>
      <tr>
        <td>작성자</td>
        <td><%=tel %></td>
      
      </tr>
    </tbody>
  </table>
</div>

<br>
<hr>
<a href="member.html">앞페이지로 가기</a>
<a href="login.html">로그인페이지로 가기</a>
</body>
</html>