
<%@page import="db_connect.movieVO"%>
<%@page import="db_connect.movieDAO"%>
<%@page import="java.util.ArrayList"%>
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
    movieDAO dao = new movieDAO();
    ArrayList<movieVO> list = dao.list();
    
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
background: pink;
}

</style>
</head>
<body>
<h1>검색 결과창</h1>
<hr>
<h3>상영중인 영화 개수 <%=list.size() %>개 </h3>
<div class="container">
 <h2>전체 게시물 조회 결과</h2>
   <table class="table tabl-bordered">
  <thead>
      <tr>
        <th>영화순위</th>
        <th>영화제목</th>
        <th>상영시간</th>  
        <th>장르</th>
        <th>개봉일</th>
        <th>포스터</th>
      </tr>
    </thead>
    <tbody>
<%
	for(movieVO bag: list){
		%>
      
      <tr> 
      <td><%=bag.getMovienumber() %>
        <td><%=bag.getMoviename() %></td>
        <td><%= bag.getRunningtime() %></td>
        <td><%= bag.getGenre() %></td>
        <td><%= bag.getScreenDate() %></td>
      <td>
      <a href="http://localhost:9999/web01/movie_one.jsp?movieid=<%=bag.getMovienumber()%>"><img src="./img/<%=bag.getImg()%>">
      </a>
      </td>
      </tr>
     
      <%
	}

%>
    </tbody>
  </table>
  </div>
<br>
<hr>
<a href="movie.html">앞페이지로 가기</a>
</body>
</html>