package db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	public ArrayList<MemberVO> list() {
	
		//vo를 넣어줄 커다란 박스역할을 할 수 있는 부품을 사용 예정 
		//가변 길이인 경우 arrayList
		//MemberVO가 많이 들어간 arraylist박스를 하나 만들어줌
		ArrayList<MemberVO> list = new ArrayList<>();
		MemberVO bag = null; // 변수 초기화 시켜주어야함 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//특정한 위치에 있는 드라이버 파일을 램에 읽어들여 설정
			System.out.println("1. 드라이버 설정 성공.@@@@");
			
			
			//2. db연결 mySQL: school, oracle: xe
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger"; 
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			System.out.println("2. db연결 성공.@@@@@@");
			
			//3. sql문을 만든다. 
			String sql = "select * from member"; 
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
				String pw = rs.getString("pw"); 
				String name = rs.getString(3); 
				String tel = rs.getString(4);
				System.out.println("검색한 결과 >> id=" + id2+ ", pw=" + pw + ", name=" + name + ", tel=" + tel );
				
				//ui에서 사용자가 검색한 결과를 볼 수 있어야한다 
				// 4개의 데이터를 ui에게 return 해주자 
				// 2) 가방을 만들어서 
				bag = new MemberVO();
				//3)데이터를 넣고 
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
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
	
	public int login(MemberVO bag) {
		System.out.println(bag);
		int result = 0; // 0인경우 실패라고하자
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//특정한 위치에 있는 드라이버 파일을 램에 읽어들여 설정
			System.out.println("1. 드라이버 설정 성공.@@@@");
			
			
			//2. db연결 mySQL: school, oracle: xe
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger"; 
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			System.out.println("2. db연결 성공.@@@@@@");
			
			//3. sql문을 만든다. 
			String sql = "select * from member where id = ? and pw = ?"; 
			//준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId()); //1번 물음표에 가방에 저장해놓은 id값을 스트링으로 넣어줘!
			ps.setString(2, bag.getPw()); //2번 물음표에 가방에 저장해놓은 pw값을 스트링으로 넣어줘!
			
			System.out.println("3. sql문 생성 성공.@@@@@");
			//String site = "http://www.naver.com";
			//Url url = new Url(site); //객체화!!
			
			//4. sql문을 db서버에 보낸다. --> 결과가 어떻게 되었는지 자바프로그램 알려줌.
			ResultSet rs = ps.executeQuery(); // select 만 query를 사용  
			//rs.next() true면 결과아 있음 false면 없음 
			//System.out.println("4. sql문 db서버로 전송 성공. @@@@@ 반영된 row수 >>"  + rs.next());
			if (rs.next()) {// 결과 값이 true 이면 
				System.out.println("검색 결과가 있음 ");
				result = 1;			
			}
			
			//db처리와 관련된 메모리 할당된 것 해제 시켜주기 
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//3 ) 리턴하자 (전달)
		return result;
		
	} //login
	
	// 검색 1명 기능 - row 1개 
	public MemberVO one(String id) {
		//자바에서 DBMS를 연결하려고 함.
		//JDBC 프로그래밍 절차
		//4단계 절차
		//1. 드라이버 설정- 드라이버(커넥터) 로딩
		//   db의 유형, 버전에 따라 매우 많음.
		//   필요할 때 다운로드 받아 써야 함.
		MemberVO bag = null; // 변수 초기화 시켜주어야함 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//특정한 위치에 있는 드라이버 파일을 램에 읽어들여 설정
			System.out.println("1. 드라이버 설정 성공.@@@@");
			
			
			//2. db연결 mySQL: school, oracle: xe
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger"; 
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			System.out.println("2. db연결 성공.@@@@@@");
			
			//3. sql문을 만든다. 
			String sql = "select * from member where id = ?"; 
			//준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); //1번 물음표에 id에 저장해놓은 값을 스트링으로 넣어줘!
			System.out.println("3. sql문 생성 성공.@@@@@");
			//String site = "http://www.naver.com";
			//Url url = new Url(site); //객체화!!
			
			//4. sql문을 db서버에 보낸다. --> 결과가 어떻게 되었는지 자바프로그램 알려줌.
			ResultSet rs = ps.executeQuery(); // select 만 query를 사용  
			//rs.next() true면 결과아 있음 false면 없음 
			//System.out.println("4. sql문 db서버로 전송 성공. @@@@@ 반영된 row수 >>"  + rs.next());
			if (rs.next()) {// 결과 값이 true 이면 
				System.out.println("검색 결과가 있음 ");
				String id2 = rs.getString(1); //컬럼의 순서 1번 id 값을 추출 
				String pw = rs.getString("pw"); // 컬럼이름이나 순서 아무거나 가능 
				String name = rs.getString(3); 
				String tel = rs.getString(4);
				System.out.println("검색한 결과 >> id=" + id2+ ", pw=" + pw + ", name=" + name + ", tel=" + tel );
				
				//ui에서 사용자가 검색한 결과를 볼 수 있어야한다 
				// 4개의 데이터를 ui에게 return 해주자 
				// 1) 가방을 만들어서 
				bag = new MemberVO();
				//2)데이터를 넣고 
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
				
			}
			//db처리와 관련된 메모리 할당된 것 해제 시켜주기 
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//3 ) 리턴하자 (전달)
		return bag;
		
	} //select
	
	public void insert(MemberVO bag) {
		System.out.println(bag);
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
		String sql = "insert into member values (?, ?, ?, ?)"; 
		//String sql = "delete from member where id = 'grape' ";
		//준비된 문장 (Preparedstatement) 
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, bag.getId()); // 1번 물음표에 bag에 저장해놓은 id값을 스트링으로 넣기 
		ps.setString(2, bag.getPw()); // 1번 물음표에 bag에 저장해놓은 pw값을 스트링으로 넣기 
		ps.setString(3, bag.getName()); // 1번 물음표에 bag에 저장해놓은 name값을 스트링으로 넣기 
		ps.setString(4, bag.getTel()); // 1번 물음표에 bag에 저장해놓은 tel값을 스트링으로 넣기 
		
		
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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//특정한 위치에 있는 드라이버 파일을 램에 읽어들여 설정
			System.out.println("1. 드라이버 설정 성공.@@@@");
			
			
			//2. db연결 mySQL: school, oracle: xe
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger"; 
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			System.out.println("2. db연결 성공.@@@@@@");
			
			//3. sql문을 만든다. 
			String sql = "delete from member where id = ?"; 
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
	
	
}