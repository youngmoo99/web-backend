<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String pw2 = request.getParameter("pw2");
    String name = request.getParameter("name");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    String country = request.getParameter("Country");
    String tel = request.getParameter("tel");
    String good = request.getParameter("good");
  String[] hobby= request.getParameterValues("hobby");
  String result ="";
  for(String s: hobby){
	  result = result+s + " ";
  }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버에서 받은 아이디 >> <%=id %> <br>
서버에서 받은 비밀번호 >> <%=pw %> <br>
서버에서 받은 이름 >> <%=name %><br>
서버에서 받은 생년월일 >> <%=year %>년 <%=month %>월 <%=day %>일  <br>
서버에서 받은 성별 >> <%=gender %><br>
서버에서 받은 휴대전화 >> <%=country %> <%=tel %><br>
서버에서 받은 관심사 >> <%=result %><br>
서버에서 받은 하고싶은말 >> <%=good %><br>


</body>
</html>
