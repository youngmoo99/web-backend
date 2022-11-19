package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB연결테스트 {
	public static void main(String[] args) {
		//자바에서 DBMS를 연결하려고 함
		// jdbc 프로그래밍 절차
		// 4단계 절차 
		//1. 드라이버 설정 - 드라이버(커넥터) 로딩 
		// db, 버전, 유형에 따라 매우많음 
		// 필요할 때 다운로드 받아 써야 함 
		//mysql은 com.mysql.cj.jdbc.Driver
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("1. 드라이버 설정 성공.@@@@");
		
		//2. db 연결 mySQL : school, oracle: xe 
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection con = DriverManager.getConnection(url, user,password);
		System.out.println("2. db연결 성공.@@@@@");
		
		//3. sql 문을 만든다 
		//String sql = "insert into member values ('melon445','3503 ','lee','03333')"; 
		String sql = "delete from member where id = 'grape' ";
		//준비된 문장 (Preparedstatement) 
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		System.out.println("3. sql문 생성 성공");
		
		
		//4. sql문을 db 서버에 보낸다 --> 결과가 어떻게 되었는지 자바 프로그램 알려줌 
		int result = ps.executeUpdate();
		
		System.out.println("4. sql문 db서버로 전송 성공 반영된 row 수 >> " +result);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	}
