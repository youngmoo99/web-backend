<%@page import="db_connect.ProductVO"%>
<%@page import="db_connect.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--
1.입력
2. 처리(db처리 - dao, vo)
3. 출력(브라우저로 출력, html)
  -->
  <!-- 1. product_insert.html에서 입력해서 넘긴 값을 받아야함 -->
  <%
  String id = request.getParameter("id"); // <input name ="id">, 외부에서 입력한 데이터타입(String)
  ProductDAO dao = new ProductDAO();
  dao.delete(id);
  	
  
  %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시물 삭제 확인</h3>
<hr>
<%= id%>의 삭제가 완료되었습니다. <br>


<hr>
<a href="product_delete.html"><button>상품삭제페이지</button>
</a>
<a href="product.html"><button>첫페이지</button></a>

</body>
</html>