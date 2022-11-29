package multi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/hello2")
public class FirstServlet extends HttpServlet {

    
  
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿이 싱글톤으로 하나 생성됨");
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("hello2 주소가 요청됨 ");
	
	//String id = null; // 지역변수!, 쓰레기 값이 들어잇음
	
	String food = request.getParameter("food");
	String drink = request.getParameter("drink");
	System.out.println("먹고싶은 음식은"+food + "이고, 음료수는 "+drink);
	//db처리 
	//출력 (html) 
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter(); 
	out.print("food>> "+food +"<br>");
	out.print("drink>> "+drink+"<br>");
	
	out.close();
	
	
	}

}
