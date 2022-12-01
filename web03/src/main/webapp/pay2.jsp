<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String money = request.getParameter("money");
    String email = request.getParameter("email");
    String user = request.getParameter("user");
    String tel = request.getParameter("tel");
    
    %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>결제 </title>
<!-- jQuery -->
<script type="text/javascript"
   src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
   src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>

결제금액은 : <%=money %>원 <br>
이메일 : <%=email %> <br>
구매자 이름 : <%=user%> <br>
구매자 전화번호 : <%=tel %> <br>
</body>
</html>