package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class gasifanDAO {
	public ArrayList<GasifanVO> list() {
		
		//vo를 넣어줄 커다란 박스역할을 할 수 있는 부품을 사용 예정 
		//가변 길이인 경우 arrayList
		//MemberVO가 많이 들어간 arraylist박스를 하나 만들어줌
		ArrayList<GasifanVO> list = new ArrayList<>();
		GasifanVO bag = null; // 변수 초기화 시켜주어야함 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//특정한 위치에 있는 드라이버 파일을 램에 읽어들여 설정
			System.out.println("1. 드라이버 설정 성공.@@@@");
			
			
			//2. db연결 mySQL: school, oracle: xe
			String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234"; 
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			System.out.println("2. db연결 성공.@@@@@@");
			
			//3. sql문을 만든다. 
			String sql = "select * from gasifan"; 
			//준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			
			System.out.println("3. sql문 생성 성공.@@@@@");
			//String site = "http://www.naver.com";
			//Url url = new Url(site); //객체화!!
			
			//4. sql문을 db서버에 보낸다. --> 결과가 어떻게 되었는지 자바프로그램 알려줌.
			ResultSet rs = ps.executeQuery(); // select 만 query를 사용  
			//rs.next() true면 결과아 있음 false면 없음 
			//System.out.println("4. sql문 db서버로 전송 성공. @@@@@ 반영된 row수 >>"  + rs.next());
			while (rs.next()) {// 결과 값이 true 이면 
				System.out.println("검색 결과가 있음 ");
				//1. 한 행의 값들을 추출
				//2. vo를 만들어준다
				//3. vo에 추출한 값들을 넣어준다
				//4. vo를 list에 넣어준다 
				//1) 값 추출
				String id2 = rs.getString(1); 
				String title = rs.getString("title"); 
				String content = rs.getString(3); 
				String writer = rs.getString(4);
				System.out.println("검색한 결과 >> id=" + id2+ ", title=" + title + ", content=" + content + ", writer=" + writer );
				
				//ui에서 사용자가 검색한 결과를 볼 수 있어야한다 
				// 4개의 데이터를 ui에게 return 해주자 
				// 2) 가방을 만들어서 
				bag = new GasifanVO();
				//3)데이터를 넣고 
				bag.setId(id2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
				
				
				list.add(bag);
			}
			System.out.println("box(list)에 들어간 가방의 개수 >> "+list.size());
			//db처리와 관련된 메모리 할당된 것 해제 시켜주기 
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//3 ) 리턴하자 (전달)
		return list;
		
	} //list
	public void update(GasifanVO bag) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("1. 드라이버 설정 성공.@@@@");
		
		//2. db 연결 mySQL : school, oracle: xe 
		String url ="jdbc:mysql://localhost:3306/school?useUnicode=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user,password);
		System.out.println("2. db연결 성공.@@@@@");
		
		//3. sql 문을 만든다 
		String sql = "update gasifan set title=?, content=?, writer=? where id=?"; 
		//String sql = "delete from member where id = 'grape' ";
		//준비된 문장 (Preparedstatement) 
		PreparedStatement ps = con.prepareStatement(sql);

		
		
		ps.setString(1,bag.getTitle()); // 1번 물음표에 id에 저장해놓은 값을 스트링으로 넣기 
		ps.setString(2, bag.getContent()); // 2번 물음표에 id에 저장해놓은 값을 스트링으로 넣기 
		ps.setString(3, bag.getWriter()); // 1번 물음표에 id에 저장해놓은 값을 스트링으로 넣기 
		ps.setString(4, bag.getId());
		
		
		System.out.println("3. sql문 생성 성공");
		
		
		//4. sql문을 db 서버에 보낸다 --> 결과가 어떻게 되었는지 자바 프로그램 알려줌 
		int result = ps.executeUpdate();
		
		System.out.println("4. sql문 db서버로 전송 성공 반영된 row 수 >> " +result);
		
		ps.close();
		con.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	}
	
	
	public void insert(GasifanVO bag) {
		//자바에서 DBMS를 연결하려고 함
		// jdbc 프로그래밍 절차
		// 4단계 절차 
		//1. 드라이버 설정 - 드라이버(커넥터) 로딩 
		// db, 버전, 유형에 따라 매우많음 
		// 필요할 때 다운로드 받아 써야 함 
		//mysql은 com.mysql.cj.jdbc.Driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("1. 드라이버 설정 성공.@@@@");
		
		//2. db 연결 mySQL : school, oracle: xe 
		String url ="jdbc:mysql://localhost:3306/school?useUnicode=true&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user,password);
		System.out.println("2. db연결 성공.@@@@@");
		
		//3. sql 문을 만든다 
		String sql = "insert into gasifan values (?, ?, ?, ?)"; 
		//String sql = "delete from member where id = 'grape' ";
		//준비된 문장 (Preparedstatement) 
		PreparedStatement ps = con.prepareStatement(sql);

		
		ps.setString(1, bag.getId()); // 1번 물음표에 id에 저장해놓은 값을 스트링으로 넣기 
		ps.setString(2,bag.getTitle()); // 1번 물음표에 id에 저장해놓은 값을 스트링으로 넣기 
		ps.setString(3, bag.getContent()); // 1번 물음표에 id에 저장해놓은 값을 스트링으로 넣기 
		ps.setString(4, bag.getWriter()); // 1번 물음표에 id에 저장해놓은 값을 스트링으로 넣기 
		
		
		System.out.println("3. sql문 생성 성공");
		
		
		//4. sql문을 db 서버에 보낸다 --> 결과가 어떻게 되었는지 자바 프로그램 알려줌 
		int result = ps.executeUpdate();
		
		System.out.println("4. sql문 db서버로 전송 성공 반영된 row 수 >> " +result);
		
		ps.close();
		con.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(String id) {
		//자바에서 DBMS를 연결하려고 함.
		//JDBC 프로그래밍 절차
		//4단계 절차
		//1. 드라이버 설정- 드라이버(커넥터) 로딩
		//   db의 유형, 버전에 따라 매우 많음.
		//   필요할 때 다운로드 받아 써야 함.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//특정한 위치에 있는 드라이버 파일을 램에 읽어들여 설정
			System.out.println("1. 드라이버 설정 성공.@@@@");
			
			
			//2. db연결 mySQL: school, oracle: xe
			String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234"; 
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			System.out.println("2. db연결 성공.@@@@@@");
			
			//3. sql문을 만든다. 
			String sql = "delete from gasifan where id = ?"; 
			//준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); //1번 물음표에 id에 저장해놓은 값을 스트링으로 넣어줘!
			System.out.println("3. sql문 생성 성공.@@@@@");
			//String site = "http://www.naver.com";
			//Url url = new Url(site); //객체화!!
			
			//4. sql문을 db서버에 보낸다. --> 결과가 어떻게 되었는지 자바프로그램 알려줌.
			int result = ps.executeUpdate(); // r의 결과는 table, cud는 숫자(실행된row수) //1 
			System.out.println("4. sql문 db서버로 전송 성공. @@@@@ 반영된 row수 >>"  + result);
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	} //delete
	public GasifanVO select(String id) {
		//자바에서 DBMS를 연결하려고 함.
		//JDBC 프로그래밍 절차
		//4단계 절차
		//1. 드라이버 설정- 드라이버(커넥터) 로딩
		//   db의 유형, 버전에 따라 매우 많음.
		//   필요할 때 다운로드 받아 써야 함.
		GasifanVO bag = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//특정한 위치에 있는 드라이버 파일을 램에 읽어들여 설정
			System.out.println("1. 드라이버 설정 성공.@@@@");
			
			
			//2. db연결 mySQL: school, oracle: xe
			String url = "jdbc:mysql://localhost:3306/school?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234"; 
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			System.out.println("2. db연결 성공.@@@@@@");
			
			//3. sql문을 만든다. 
			String sql = "select * from gasifan where id = ?"; 
			//준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); //1번 물음표에 id에 저장해놓은 값을 스트링으로 넣어줘!
			
			System.out.println("3. sql문 생성 성공.@@@@@");
			//String site = "http://www.naver.com";
			//Url url = new Url(site); //객체화!!
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String id1 = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				JOptionPane.showMessageDialog(null, id1+" "+title+" "+content+" "+writer);
				System.out.println(id1+" "+title+" "+content+" "+writer);			
				bag = new GasifanVO();
				
				bag.setId(id1);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
			}
			ps.close();
			con.close();
			rs.close();
			
		
//			System.out.println("4. sql문 db서버로 전송 성공. @@@@@ 반영된 row수 >>" );
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return bag;
		
	} //select
	
	
	
}