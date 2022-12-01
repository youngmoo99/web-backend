<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String money = request.getParameter("money");
	String choice = request.getParameter("choice");
	String account = "결제";
	
	int money2 = Integer.parseInt(money);
	int choice2 = Integer.parseInt(choice);
	
	if(choice2 == 1){
		money2 = money2 - 1000;
		account = "계좌이체";
	}else if (choice2 == 2){
		money2 = money2 + 1000;
		account = "신용카드";
	}
	else if (choice2 == 3){
		money2 = money2 + 500;
		account = "무통장입금";
	} 
	else if (choice2 == 4){
		money2 = money2 + 600;
		account = "카카오페이";
	} 
	else if (choice2 == 5){
		money2 = money2 + 700;
		account = "네이버페이";
	} 
	
	
%><%=account%><%=money2%>