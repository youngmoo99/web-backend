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
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	String price = request.getParameter("price");
	String company = request.getParameter("company");
	String img = request.getParameter("img");
	
ProductVO bag = new ProductVO();
bag.setID(id);
bag.setNAME(name);
bag.setCONTENT(content);
bag.setPRICE(Integer.parseInt(price));
bag.setCOMPANY(company);
bag.setIMG(img);


ProductDAO dao =new ProductDAO();
dao.update(bag);
	
  
  
  %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시물 수정 정보 확인</h3>
<hr>
<%= id%>님의 수정 정보 <br>
이름 : <%= name%> <br>
내용 : <%= content%> <br>
가격 : <%= price%> <br>
회사 : <%= company%> <br>
이미지 : <%= img%> <br>

<hr>
<a href="product_update.html"><button>상품등록페이지</button>
</a>
<a href="product.html"><button>첫페이지</button></a>

</body>
</html>