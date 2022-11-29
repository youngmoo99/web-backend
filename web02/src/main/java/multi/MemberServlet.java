package multi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insert.do")
public class MemberServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert.do 주소가 요청됨 ");
		
		//String id = null; // 지역변수!, 쓰레기 값이 들어잇음
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("당신의 id는 "+id + "이고, 비밀번호는 "+pw);
		//db처리 
		//출력 (html) 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		out.print("로그인 id는 >> "+id +"<br>");
		out.print("로그인 pw는>> "+pw+"<br>");
		out.close();
	}

}
