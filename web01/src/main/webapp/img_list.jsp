<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String[] img_list ={
    	"1.png",
    	"2.png",
    	"3.png",
    	"4.png",
    	"5.png"
    };
    String[] id_list = {"100","101","102"};
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<table class="table-dark table-striped">
			<tr>
				<th>이름</th>
				<th>사진</th>

			</tr>
			<%
	for(String s: img_list){// s="100", s="101",s="102"
%>
<tr>
<td><%=s%></td>
<td><a href ="http://localhost:9999/web01/product_one.jsp?id=111<%= s%>"><img src="./img/<%= s%>"></a>
</td>
</tr>

	<% 
	}
	%>		
		</table>

</body>
</html>