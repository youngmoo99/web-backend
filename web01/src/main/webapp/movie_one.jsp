
<%@page import="db_connect.movieVO"%>
<%@page import="db_connect.movieDAO"%>
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
    
  	String movienumber = request.getParameter("movieid"); // <input name ="id">, 외부에서 입력한 데이터타입(String)
  	
  	movieDAO dao = new movieDAO();
    movieVO bag = dao.select(movienumber);
  
	String moviename = bag.getMoviename();
	String runningtime = bag.getRunningtime();
	String genre = bag.getGenre();
	String screenDate = bag.getScreenDate();
	String img = bag.getImg();

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
  <h2><%=movienumber %>위 영화 정보</h2>
           
  <table class="table table-dark">
    <thead>
      <tr>
        <th>항목</th>
        <th>정보</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>영화이름</td>
        <td><%=moviename %></td>
      </tr>
      <tr>
        <td>상영시간</td>
        <td><%=runningtime %></td>
      </tr>
      <tr>
        <td>장르</td>
        <td><%=genre %></td>
      
      </tr>
      <tr>
        <td>개봉일</td>
        <td><%=screenDate %></td>
      
      </tr>
       <tr>
        <td>포스터</td>
        <td><img src="./img/<%=img%>"></td>
      
      </tr>
    </tbody>
  </table>
</div>

<br>
<hr>
<a href="movie.html">앞페이지로 가기</a>
<br>
<br>
<a href="http://localhost:9999/web01/movie_list.jsp?">전체 영화 리스트</a>
</body>
</html>